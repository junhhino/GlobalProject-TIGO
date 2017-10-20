package org.Prueba;

import java.io.UnsupportedEncodingException;

import org.Prueba.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException
    {
        System.out.println( "Hello World!" );
        
        PlexProcess resp= new PlexProcess();
        resp.run();
    }
}
