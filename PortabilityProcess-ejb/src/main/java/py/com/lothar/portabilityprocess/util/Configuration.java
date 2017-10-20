/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author LTHCAP
 */
public class Configuration {

    private static final Logger logger = Logger.getLogger("Configuration");
    private static String configFile;
    private static Configuration instance;
    private Properties properties = new Properties();
    private boolean successLoad = false;

    //Parametros de conexion a BCCS
    private String dbDriverNameAS;
    private String dbUserAS;
    private String dbUrlAS;
    private String dbPassAS;
    private int dbInitConnAS;
    private int dbTimeOutAS;
    private int dbMaxConnsAS;
    private String dbScriptAS;
    private int timeToLiveConnectionAS;

    private String executeSP;
    private String formatoFechaHora;
    private ConnectionPoolAS poolAS = null;

    private String sqlFilePath;
    private String selectFacturasPendientes;
    private String ASdataSource;

    private Configuration() {
        loadParameters();
    }

    private void loadParameters() {
//        FileInputStream inputStream = null;
        InputStream inputStream = null;
        try {

            successLoad = true;
//            inputStream = new FileInputStream(configFile);
            inputStream = getClass().getResourceAsStream("/etc/PortabilityProcess.properties");
            properties.load(inputStream);
            System.out.println("aaa" + inputStream);
            dbDriverNameAS = properties.getProperty("dbDriverNameAS");
            dbUserAS = properties.getProperty("dbUserAS");
            dbUrlAS = properties.getProperty("dbUrlAS");
            dbPassAS = properties.getProperty("dbPassAS");
            dbScriptAS = properties.getProperty("dbScriptAS");
            dbInitConnAS = Integer.parseInt(properties.getProperty("dbInitConnAS"));
            dbTimeOutAS = Integer.parseInt(properties.getProperty("dbTimeOutAS"));
            dbMaxConnsAS = Integer.parseInt(properties.getProperty("dbMaxConnsAS"));
            timeToLiveConnectionAS = Integer.parseInt(properties.getProperty("timeToLiveConnectionAS"));

            executeSP = properties.getProperty("executeSP");
            formatoFechaHora = properties.getProperty("formatoFechaHora");

            sqlFilePath = "/etc/PortabilityProcess.sql";
            loadSqlScript(sqlFilePath); //tomar todos los scripts
            selectFacturasPendientes = properties.getProperty("selectFacturasPendientes");
            ASdataSource = properties.getProperty("ASdataSource");

        } catch (FileNotFoundException ex) {
            successLoad = false;
            logger.error("Se ha producido un error al cargar archivo de configuracion");
            logger.error("Exception.", ex);
        } catch (IOException ex) {
            successLoad = false;
            logger.error("Se ha producido un error al cargar archivo de configuracion");
            logger.error("Exception.", ex);
        } catch (NullPointerException ex) {
            successLoad = false;
            logger.error("Se ha producido un error al cargar archivo de configuracion");
            logger.error("Exception.", ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                logger.error("Se ha producido un error al cerrar File Input Stream");
                logger.error("Exception.", ex);
            }
        }
    }

    /**
     *
     * @param file
     * @return
     */
    public static Configuration getInstance(String file) {
        configFile = file;
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public static String getConfigFile() {
        return configFile;
    }

    public static void setConfigFile(String configFile) {
        Configuration.configFile = configFile;
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public static void setInstance(Configuration instance) {
        Configuration.instance = instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public boolean isSuccessLoad() {
        return successLoad;
    }

    public void setSuccessLoad(boolean successLoad) {
        this.successLoad = successLoad;
    }

    public String getDbDriverNameAS() {
        return dbDriverNameAS;
    }

    public void setDbDriverNameAS(String dbDriverNameAS) {
        this.dbDriverNameAS = dbDriverNameAS;
    }

    public String getDbUserAS() {
        return dbUserAS;
    }

    public void setDbUserAS(String dbUserAS) {
        this.dbUserAS = dbUserAS;
    }

    public String getDbUrlAS() {
        return dbUrlAS;
    }

    public void setDbUrlAS(String dbUrlAS) {
        this.dbUrlAS = dbUrlAS;
    }

    public String getDbPassAS() {
        return dbPassAS;
    }

    public void setDbPassAS(String dbPassAS) {
        this.dbPassAS = dbPassAS;
    }

    public int getDbInitConnAS() {
        return dbInitConnAS;
    }

    public void setDbInitConnAS(int dbInitConnAS) {
        this.dbInitConnAS = dbInitConnAS;
    }

    public int getDbTimeOutAS() {
        return dbTimeOutAS;
    }

    public void setDbTimeOutAS(int dbTimeOutAS) {
        this.dbTimeOutAS = dbTimeOutAS;
    }

    public int getDbMaxConnsAS() {
        return dbMaxConnsAS;
    }

    public void setDbMaxConnsAS(int dbMaxConnsAS) {
        this.dbMaxConnsAS = dbMaxConnsAS;
    }

    public String getDbScriptAS() {
        return dbScriptAS;
    }

    public void setDbScriptAS(String dbScriptAS) {
        this.dbScriptAS = dbScriptAS;
    }

    public int getTimeToLiveConnectionAS() {
        return timeToLiveConnectionAS;
    }

    public void setTimeToLiveConnectionAS(int timeToLiveConnectionAS) {
        this.timeToLiveConnectionAS = timeToLiveConnectionAS;
    }

    public String getExecuteSP() {
        return executeSP;
    }

    public void setExecuteSP(String executeSP) {
        this.executeSP = executeSP;
    }

    public String getFormatoFechaHora() {
        return formatoFechaHora;
    }

    public void setFormatoFechaHora(String formatoFechaHora) {
        this.formatoFechaHora = formatoFechaHora;
    }

    public String getSelectFacturasPendientes() {
        return selectFacturasPendientes;
    }

    public void setSelectFacturasPendientes(String selectFacturasPendientes) {
        this.selectFacturasPendientes = selectFacturasPendientes;
    }

    public String getASdataSource() {
        return ASdataSource;
    }

    public void setASdataSource(String ASdataSource) {
        this.ASdataSource = ASdataSource;
    }

    private void loadSqlScript(String path) {
        String s;
        String key = "";
        StringBuffer sb = new StringBuffer();
        boolean firstTime = true;
        BufferedReader br = null;
        InputStream inputStream = null;
        InputStreamReader reader = null;
        try {
            inputStream = getClass().getResourceAsStream(path);
            reader = new InputStreamReader(inputStream, "UTF-8");

            // be sure to not have line starting with "--" or "/*" or any other non aplhabetical character
            br = new BufferedReader(reader);

            while ((s = br.readLine()) != null) {
                String str = s.replaceAll("( *)\\-\\-.*", "");//omitir comentarios

                if (str.equalsIgnoreCase("")) {
                    continue;
                }
                //tomar el primer igual, que ser??a variable = script sql
                if (firstTime) {
                    int equalsIndex = str.indexOf("=");
                    if (equalsIndex > 0) {
                        str = str.substring(equalsIndex + 1, str.length());
                        key = s.substring(0, equalsIndex).trim();
                        firstTime = false;
                    }
                }
                str = str.replaceFirst("^ *", "").trim();//elminar espacio en blanco al principio y al final
                sb.append(str).append(" ");

                int semiColonIndex = s.indexOf(';');
                if (semiColonIndex >= 0) {//el punto y coma (;) delimita la setencia sql
                    String sentence = sb.toString().replaceFirst("^ *", "").trim();//elminar espacio en blanco al principio y al final

                    sentence = sentence.replaceAll(";", "");//elminar ; de la sentencia
                    properties.setProperty(key != null ? key : "", sentence);
                    sb = sb.delete(0, sb.length());//borramos la cadena para empezar de nuevo
                    firstTime = true;
                    key = "";
                }
            }
            //} catch (Exception e) {
            //System.out.println("Error:" + e);
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public ConnectionPoolAS getPoolAS() {
        try {
            if (poolAS != null) {
                return poolAS;
            }
            return ConnectionPoolAS.getPool();
        } catch (Exception ex) {
            logger.error("Error al obtener el pool..." + ex);
            return null;
        }
    }

    public void setPoolAS(ConnectionPoolAS poolAS) {
        this.poolAS = poolAS;
    }
}
