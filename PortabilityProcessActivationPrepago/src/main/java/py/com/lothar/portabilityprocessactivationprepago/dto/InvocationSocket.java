/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocessactivationprepago.dto;


import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import py.com.lothar.portabilityprocessactivationprepago.response.ActivationPrepagoResponse;

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
        map.put("00","	Proceso Satisfactorio	");
        map.put("01","	Numero de Cuenta Pagador no existe	");
        map.put("02","	Numero de Cuenta Acreedor no existe	");
        map.put("03","	Numero de Cuenta Pagador invalido	");
        map.put("04","	Numero de Cuenta Acreedor invalido	");
        map.put("05","	Pin de la Cuenta invalido	");
        map.put("06","	La Cuenta no posee Pin	");
        map.put("07","	Monto invalido	");
        map.put("08","	Error en calculo Limite de Credito	");
        map.put("09","	Monto a Acreditar supera Limite de Cta	");
        map.put("10","	Error en la Acreditacion	");
        map.put("11","	Error en Generacion del Movimiento DB/CR	");
        map.put("12","	Tipo Cuenta no existe o no esta Activo	");
        map.put("13","	Nro de Cuenta no existe	");
        map.put("14","	Pin no coincide c/ el regist. en la Cta	");
        map.put("15","	Cuenta invalida x Validacion de Procesos	");
        map.put("16","	Falta parametros del sistema	");
        map.put("17","	La Cuenta esta bloqueada x otro proceso	");
        map.put("18","	Nuevo Estado no paramet p/ Cambio Estado	");
        map.put("19","	Usuario no autorizado p/ Cambio Estado	");
        map.put("20","	El IMEI esta registrado como controlado	");
        map.put("21","	El IMEI esta activo en el Sistema	");
        map.put("22","	El IMEI se encuentra en el Inventario	");
        map.put("23","	El nuevo SubTipoCta invalido p/ la Cta	");
        map.put("24","	El Codigo de Marca Modelo no existe	");
        map.put("25","	Cod MarcaMod no coincide c/ el ingresado	");
        map.put("26","	El IMEI de la Cuenta es invalido	");
        map.put("27","	Serie ICCID es invalido o esta en Blanco	");
        map.put("28","	EH Vend. no corresponde a la Serie ICCID	");
        map.put("29","	El Plan Consumo es invalido o no existe	");
        map.put("30","	EH Vend. es invalido o no existe	");
        map.put("31","	Nro Doc. de Ident. ingresado es invalido	");
        map.put("32","	La Fecha de Nac. ingresado es invalido	");
        map.put("33","	Plan Comercial es invalido o no existe	");
        map.put("34","	La Cuenta ya esta Nominativizada	");
        map.put("35","	Cod P. Física o Jurídica no corresponde	");
        map.put("36","	El legajo de la Cuenta esta en proceso	");
        map.put("37","	La Cuenta no esta Nominativizada	");
        map.put("38","	Nro Doc Iden. no existe	");
        map.put("39","	Se ha creado el legajo de la cuenta	");
        map.put("40","	Nro Cuenta no Disponible	");
        map.put("41","	Nro Cuenta con Estado Reservado	");
        map.put("42","	No se pudo realizar la Transf. Contrato	");
        map.put("43","	Nro Cuenta Solicitante invalido	");
        map.put("44","	La Cuenta ya posee Pin	");
        map.put("45","	La Cuenta no posee Limite de Consumo	");
        map.put("46","	Debe ingresar Nuevo Limte de Consumo	");
        map.put("47","	Nuevo Lim Consumo es menor al Limite Min	");
        map.put("48","	Nuevo Lim Consumo es mayor al Limite Max	");
        map.put("49","	Nuevo Lim Consumo es <= al Lim Actual	");
        map.put("50","	Doc ident supera Lim Max Cant Ctas a Reg	");
        map.put("51","	La Promocion ya no se encuentra vigente	");
        map.put("52","	Falta parametrizacion para Promocion	");
        map.put("53","	La Cta debe ser PRE o POS Tipo Fact Fija	");
        map.put("54","	Saldo Cta es inferior al Monto a Transf.	");
        map.put("55","	Servicio no existe	");
        map.put("56","	Servicio no es válido	");
        map.put("57","	Codigo de Agrupador no existe	");
        map.put("58","	Codigo de Agrupador no es válido	");
        map.put("59","	Operación o Acción no válida	");
        map.put("60","	Error Asignar o Eliminar Servicio a Cta	");
        map.put("61","	Error en Validaciones de Cambio de Plan	");
        map.put("62","	La cuenta no posee valor agregado	");
        map.put("63","	Cta supera lim max de consulta permitido	");
        map.put("64","	Error en el procesamiento de respuesta	");
        map.put("65","	Error en la Cuenta del Agente	");
        map.put("66","	Agente invalido	");
        map.put("67","	Error interno en la aplicacion 	");
        map.put("68","	Credito invalido 	");
        map.put("69","	Error en la Base de Datos 	");
        map.put("70","	Error general en la aplicacion 	");
        map.put("71","	PIN Válido (Administrador)	");
        map.put("72","	No existe PIN	");
        map.put("73","	PIN Invalido	");
        map.put("74","	PIN será bloqueado por intentos fallidos	");
        map.put("75","	El PIN se encuentra bloqueado	");
        map.put("76","	PIN Válido (no Administrador)	");
        map.put("77","	Primera vez que ingresa, cambie su PIN	");
        map.put("78","	Su PIN ha caducado, debe cambiar	");
        map.put("79","	El PIN ha sido cambiado	");
        map.put("80","	El PIN ha sido bloqueado	");
        map.put("81","	Accion Válida	");
        map.put("82","	Ya existe solicitud de cambio en proceso	");
        map.put("83","	Solicitud Realizada	");
        map.put("84","	Solicitud Confirmada	");
        map.put("85","	Solicitud Cancelada	");
        map.put("86","	No está generado Perfil Base p/ Tipo Usuario	");
        map.put("87","	No existe Perfil Base p/ Tipo de Usuario	");
        map.put("88","	El Perfil no posee acceso a la operación	");
        map.put("89","	Ya existe una sol. de cambio en proceso	");
        map.put("90","	No existe solicitud para dicha cuenta	");
        map.put("91","	El PIN solo puede estar compuesto x nros	");
        map.put("92","	Ha superado cant max digitos p/ el PIN	");
        map.put("93","	No ha alcanzado cant min digitos p/ PIN	");
        map.put("94","	El PIN debe ser solo numérico	");
        map.put("95","	Solicitud no finalizo correctamente	");
        map.put("96","	Accion no Activa	");
        map.put("97","	No existen datos para mostrar	");
        map.put("98","	Nro Cta Vendedor no valido	");
        map.put("99","	Ehumano no posee Nro Cta Vendedor	");

       
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
            socketResp.setCodRespuesta(Integer.valueOf(msgSalida.substring(0, 2)));
            socketResp.setDescripcion(map.get(msgSalida.substring(0, 2)));
            if(msgSalida.substring(0, 2).equals("00"))
            {
                socketResp.setNroCliente(Integer.valueOf(msgSalida.substring(21, 29)));
            }
                
             return socketResp;                        
        }
        catch( UnknownHostException e ) {
            //logger.error("Fallo de conexion: ", e);
        }catch( IOException e ) {
        //   logger.error("Fallo de conexion: ", e);
        }        
    return null;
    }
}
