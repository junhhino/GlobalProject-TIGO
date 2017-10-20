package py.com.lothar.portabilityprocess.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author lthrpq
 */
public class ConnectionPoolAS {

    private static final Logger logger = Logger.getLogger(ConnectionPoolAS.class);
    private static ConcurrentHashMap<String, ConnectionPoolAS> connectionPool
            = new ConcurrentHashMap<String, ConnectionPoolAS>();
    private static int dbTimeOut;
    private static int dbMaxConns;
    private LinkedHashSet<Connection> freeConns
            = new LinkedHashSet<Connection>();
    private int checkedOut;
    private String dbDriverName;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String dbScript;
    private String key;
    private long lastTimeUsedConnection;
    private int ttlConnection;//si es 0, no hacer caso a este parametro

    /**
     * Se utiliza cuando no se va a tener mas de una base de datos al cual
     * conectar
     *
     * @return ConnectionPool
     */
    public static synchronized ConnectionPoolAS getPool()
            throws ClassNotFoundException, SQLException,
            IllegalArgumentException {
        return getPool("");
    }

    /**
     * Si se pasa el par�metro newConection true, entonces se crea un nuevo
     * pool de conexiones, eliminando el que est� en uso. El pool que est�
     * en uso libera sus conexiones en la llamada del garbage collection.
     *
     * @return ConnectionPool
     */
    public static synchronized ConnectionPoolAS getPool(boolean newConection)
            throws ClassNotFoundException, SQLException,
            IllegalArgumentException {
        return getPool("", newConection);
    }

    /**
     * Crea un nuevo Pool de Conexiones si no existe, si existe devuelve el
     * actual.
     *
     * @param key
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.IllegalArgumentException
     */
    public static synchronized ConnectionPoolAS getPool(String key)
            throws ClassNotFoundException, SQLException,
            IllegalArgumentException {
        ConnectionPoolAS pool = null;
        if (!connectionPool.containsKey(key)) {
            ConnectionPoolAS pool2 = new ConnectionPoolAS(key);
            pool = connectionPool.putIfAbsent(key, pool2);
            if (pool != null) {
                pool.finalizarPool();
            } else {
                logger.info("SE INSTANCIO UN NUEVO POOL; " + pool);
            }
        }
        pool = connectionPool.get(key);
        return pool;
    }

    /**
     * Crea un nuevo ConnectionPool. Si el pool ya existe y el parametro
     * newConection es true se elimina el Pool actual para reemplazarlo por otro
     * nuevo. El pool eliminado tiene implementado el finalize en el que se
     * cierran todas las conexines a la bd.
     *
     * @param key
     * @param newConection
     * @return ConnectionPool
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.IllegalArgumentException
     */
    public static synchronized ConnectionPoolAS getPool(String key, boolean newConection)
            throws ClassNotFoundException, SQLException,
            IllegalArgumentException {
        ConnectionPoolAS pool = null;
        if (!connectionPool.containsKey(key) || newConection) {
            ConnectionPoolAS pool2 = new ConnectionPoolAS(key);
            pool = connectionPool.putIfAbsent(key, pool2);
            if (pool != null) {
                pool.finalizarPool();
            } else {
                logger.info("SE INSTANCIO UN NUEVO POOL; " + pool);
            }
        }
        pool = connectionPool.get(key);
        return pool;
    }

    private ConnectionPoolAS(String key) throws ClassNotFoundException,
            SQLException, IllegalArgumentException {
        Configuration cfg = Configuration.getInstance();

        dbTimeOut = cfg.getDbTimeOutAS();
        dbMaxConns = cfg.getDbMaxConnsAS();
        dbDriverName = cfg.getDbDriverNameAS();
        dbUrl = cfg.getDbUrlAS();
        dbUser = cfg.getDbUserAS();
        dbPassword = cfg.getDbPassAS();
        dbScript = cfg.getDbScriptAS();
        ttlConnection = cfg.getTimeToLiveConnectionAS();
//        dbTimeOut = 1800;
//        dbMaxConns = 1;
//        dbDriverName = "com.ibm.as400.access.AS400JDBCDriver";
//        dbUrl = "jdbc:as400://73.37.0.42;BCCS";
//        dbUser = "APPWSPORTN";
//        dbPassword = "telecel1";
//        dbScript = "SELECT * FROM SYSIBM.SYSDUMMY1";
//        ttlConnection = 0;

        try {// Registra entre los drivers disponibles
            Class.forName(dbDriverName);
        } catch (ClassNotFoundException cnf) {
            logger.error("Error al cargar el driver: " + dbDriverName, cnf);
            throw cnf;
        }
        initPool();
        //Timer, controla el tiempo de vida de la conexion, si ttl es cero no hacer nada
        if (ttlConnection > 0) {
            Timer timer = new Timer(true);
            timer.schedule(new ControlConnection(),
                    ttlConnection, //initial delay
                    ttlConnection);  //subsequent rate
        }
    }

    /**
     * initial connections Sets the initial connections
     */
    private void initPool() throws SQLException {
        freeConns.add(newConnection());
    }

    /**
     * Returns un objeto coneccion desde el pool
     */
    public Connection getConnection()
            throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection(dbTimeOut * 1000L);
            connection.setAutoCommit(true);
            return connection;
        } catch (SQLException e) {
            if (connection != null) {
                connection.close();
            }
            throw e;
        }
    }

    /**
     * Returns un objeto coneccion no autocommit desde el pool
     *
     * public Connection getNotAutoCommitConnection() throws SQLException {
     * Connection connection = getConnection(dbTimeOut * 1000L);
     * connection.setAutoCommit(false); return connection; }
     */
    /**
     * @param timeout
     * @return <br>
     * If no connection available it will wait for "timeout" ,But after
     * "timeout" there still hasn't connection,it will throw a error
     */
    private synchronized Connection getConnection(long timeout)
            throws SQLException {
        long startTime = System.currentTimeMillis();
        long remaining = timeout;
        Connection conn = null;
        while ((conn = getPooledConnection()) == null) {
            try {
                wait(remaining);
            } catch (InterruptedException e) {
            }
            remaining = timeout - (System.currentTimeMillis() - startTime);
            if (remaining <= 0) {
                throw new SQLException("Error: timed-out");
            }
        }
        if (!isConnectionOK(conn)) {
            conn.close();
            return getConnection(remaining);
        }
        checkedOut++;
        if (logger.isDebugEnabled()) {
            logger.debug(getStats());
        }
        return conn;
    }

    /**
     * @param conn Connection
     * @return <br>
     * Checks if the connection is OK
     */
    private boolean isConnectionOK(Connection conn) {
        Statement testStmt = null;
        try {
            if (!conn.isClosed()) {
                testStmt = conn.createStatement();
                testStmt.execute(dbScript);
                testStmt.close();
            } else {
                return false;
            }
        } catch (SQLException e) {
            if (testStmt != null) {
                try {
                    testStmt.close();
                } catch (SQLException se) {
                }
            }
            return false;
        }
        return true;
    }

    /**
     * @return a new connection Returns a connection from freeConns.
     */
    private Connection getPooledConnection() throws SQLException {
        lastTimeUsedConnection = System.currentTimeMillis();
        if (freeConns.size() > 0) {
            Connection conn = freeConns.iterator().next();
            if (freeConns.remove(conn)) {
                return conn;
            }
        } else if (checkedOut < dbMaxConns || dbMaxConns == 0) {
            return newConnection();
        }
        return null;// no pudo tomar una conexion
    }

    /**
     * @return a new connection <br>
     * Creates a new connection
     */
    private Connection newConnection() throws SQLException {
        try {
            Connection conn
                    = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return conn;
        } catch (SQLException e) {
            logger.error("Error al crear nueva conexion.");
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Key: " + key + " Driver:" + dbDriverName + " Url: "
                + dbUrl + " " + getStats();
    }

    /**
     * Agrega al pool de conexiones el objeto conexion, si a�n no existe en
     * �l.
     *
     * @param conn
     */
    public synchronized void freeConnection(Connection conn) {
        try {
            if (conn != null && freeConns.add(renewConnection(conn))) {
                checkedOut--;
                if (logger.isDebugEnabled()) {
                    logger.debug(getStats());
                }
                notifyAll();
            }
        } catch (Exception ex) {
            logger.error("Error al reiniciar conexion:" + ex);
        }
    }

    /**
     * To release all the connection.
     */
    public synchronized void release() {
//        logger.info("Cerrando todas las conexiones de free connection, tama�o freeConns:" + freeConns.size());
        Iterator it = freeConns.iterator();
        while (it.hasNext()) {
            Connection con = (Connection) it.next();
            try {
                con.close();
            } catch (SQLException e) {
                logger.error("No se pudo cerrar una conexion. ");
            }
        }
        freeConns.clear();
    }

    /**
     * Shows the status of connections
     */
    public String getStats() {
        return "Total conexiones: " + (freeConns.size() + checkedOut)
                + " Disponible: " + freeConns.size()
                + " Utilizados: " + checkedOut;
    }

    protected void finalizarPool() {
        release();
    }

    @Override
    protected void finalize() {
        release();
    }

    //Clase para controlar el tiempo de vida de las conexiones
    class ControlConnection extends TimerTask {

        public void run() {
            if ((System.currentTimeMillis() - lastTimeUsedConnection) > ttlConnection) {
                //free connection y cierre automatico de todas las conexiones activas
                release();
            }

        }
    }

    public synchronized Connection renewConnection(Connection conn) throws Exception {
        Connection con = null;
        try {
            conn.close();
            con = newConnection();
        } catch (SQLException e) {
            logger.error("No se pudo Refrescar la Conexion!!");
        }
        return con;
    }
}
