/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.activacionprepago.dto;

import java.sql.Connection;
import java.io.*;
import static java.lang.Math.log;
import java.net.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import py.com.lothar.activacionprepago.response.ActivationPrepagoResponse;


/**
 *
 * @author Fran
 */
public class InvocationSocket {
    private final Integer port=65000;
    private final String localhost = "73.37.0.42";
    
    
    public InvocationSocket(){
        
    }
    
    public ActivationPrepagoResponse initConnectiotSocket(String msgEntrada) throws IOException{
        
        String resp = null;
        String localH=this.localhost;
        Integer port=this.port;
        BufferedReader entrada;
        PrintStream salida;
        ActivationPrepagoResponse socketResp = new ActivationPrepagoResponse();
              
        Map<String,String> map= new HashMap<String, String>();
        map.put("000","	Activación Exitosa");
        map.put("001","	Nro Asignado No Disponible   ");
        map.put("002","	ESN está ROBADO     	");
        map.put("003","	Estado del ESN CONTROLADO ");
        map.put("004","	Modelo de Eq no corresponde ");
        map.put("005","	Error por problemas con el Pin del Vendedor ");
        map.put("006","	Error por problemas con el Plan Consumo");
        map.put("007","	Eq. Humano no Habilidado para Vender");
        map.put("008","	No existe Rango de Nros libres para Activación ");
        map.put("009","	Zona de Venta Inválida  ");
        map.put("010","	Vendedor no Habilitado para vender en la ZONA  ");
        map.put("011","	Nro Asignado no Habilitado para la ZONA ");
        map.put("012","	Sub Tipo Cta no corresponde al Nro Asignado");
        map.put("013","	Nro Asignado Incorrecto. ");
        map.put("014","	Plan Comercial inválido para el Plan de consumo seleccionado");
        map.put("015","	Doc. Identidad inválido");
        map.put("016","	Cod Pin Activación Inválido");
        map.put("017","	ESN no Peritado para Activación   	");
        map.put("018","	Eq. Humano no puede Activar Tarjeta Pin ");
        map.put("019","	Edad del Cliente no corresponde para activar la cta  ");
        map.put("020","	Serie ICCID bloqueado por otro Usuario ");
        map.put("021","	Llegó al Lim Ctas a activarse por ICCID ");
        map.put("022","	Serie ICCID existe en IDCTL  ");
        map.put("023","	Serie ICCID no existe en IDCTL SIM CARD ");
        map.put("024","	ICCID no existe o tiene Est inv en Stock");
        map.put("025","	ICCID no tiene Est valido p/la operacion");
        map.put("026","	ICCID ingresado no existe o es invalido ");
        map.put("027","	ICCID no requerido para Sub Tipo Cuenta ");
        map.put("028","	SIM no corresponde para el plan");
        map.put("048","	Supera Cantidad de Cuentas por CI    ");
        map.put("099","	Cód Error por Defecto ");

        
        try{
            
            Socket socket= new Socket(localH,port);
            
            //flujo de entrada, es el flujo donde se recibira los mensajes provenientes
            //del socket servidor
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //flujo de salida, donde se le enviara los mensajes al socket servidor
            salida= new PrintStream(socket.getOutputStream());
            //se envia al servidor el mensaje
            salida.println(msgEntrada);
            
            String msgSalida =entrada.readLine(); 
            
            socketResp.setCodRespuesta(Integer.valueOf(msgSalida.substring(10, 13)));
            socketResp.setDescripcion(map.get(msgSalida.substring(10, 13)));
            
                
             return socketResp;
                        
        }
        catch( UnknownHostException e ) {
                 System.out.println( e );
        }catch( IOException e ) {
                    System.out.println( e );
        }

        
    return null;
    }
}
