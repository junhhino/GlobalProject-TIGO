/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.log;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author extiem
 */
public class LoggerUtil {
    private static java.net.URL url;
    private Logger logger = null;

    private LoggerUtil(Class<?> loggerClass) {
        try {
            loadProperties();
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger("LoggerUtil").log(Level.SEVERE, null, ex);
        }
        logger = Logger.getLogger(loggerClass);
    }
    
    public static Logger getLogger(Class<?> loggerClass) {
        return new LoggerUtil(loggerClass).getLogger();
    }
    
    private Logger getLogger() {
        return logger;
    }
    
    private static void loadProperties() throws MalformedURLException {
        try {
            String path = System.getProperty("user.dir") + File.separator + "PortabilidadBO" + File.separator + "PortabilidadBOLog4j.xml";
            url = new File(path).toURI().toURL();
            DOMConfigurator.configure(url);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger("LoggerUtil").log(Level.SEVERE, null, ex);
        }
    }
}
