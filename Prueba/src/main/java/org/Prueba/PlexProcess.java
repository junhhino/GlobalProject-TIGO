package org.Prueba;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import lothar.util.LParameter;
import lothar.util.LParameter;




public class PlexProcess {
	
	private Connection conn;
	private String path;
	private Long transactionId;
    private LParameter params;
    private Long externalId;
    private String prefijo = "";
    public PlexProcess(){
    	
    }
    
	
	public void run() throws UnsupportedEncodingException{
        path = PlexProcess.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(path);
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);
        path = path.substring(0, path.lastIndexOf("/"));
        path = path + "/etc/configuration.properties";
        System.out.println(path);
        params= new LParameter(path);
        if(params!= null)
        {
        	initConnection(params);
        }
        else{
        }
        
        

	}
	public void initConnection(LParameter opt) {
        try {
            if (conn != null) {
                conn.close();
            }
            conn = ConnectionPool.getPool("Oracle",opt).getConnection();
        } catch ( SQLException ex) {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        } catch (ClassNotFoundException ex) {
        }
    }
	
	
}
