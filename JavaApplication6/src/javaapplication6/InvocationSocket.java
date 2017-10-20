/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;


import java.sql.Connection;
import java.io.*;
import static java.lang.Math.log;
import java.net.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javaapplication6.NominationResponse;

/**
 *
 * @author Fran
 */
public class InvocationSocket {
    private final Integer port1=65015;
    private final Integer port2=65016;
    private final Integer port3=65015;
    private final String localhost = "73.37.0.42";
    
    public InvocationSocket(){
        
    }
    
    public String initConnectiotSocket(String msgEntrada) throws IOException{
        
        String resp = null;
        String localH=this.localhost;
        Integer[] port=new Integer[3];
        Integer count;
        port[0]=this.port1;
        port[1]=this.port2;
        port[2]=this.port2;
        Socket socket=null;
        
        BufferedReader entrada;
        PrintStream salida;
        NominationResponse socketResp = new NominationResponse();
        AdditionalParameters addparameters= new AdditionalParameters();
              
        Map<String,String> map= new HashMap<String, String>();
        map.put("	000	","	Proceso Satisfactorio	");
        map.put("001","	Numero de Cuenta Pagador no existe	");
        map.put("002","	Numero de Cuenta Acreedor no existe	");
        map.put("003","	Numero de Cuenta Pagador invalido	");
        map.put("004","	Numero de Cuenta Acreedor invalido	");
        map.put("005","	Pin de la Cuenta invalido	");
        map.put("006","	La Cuenta no posee Pin	");
        map.put("007","	Monto invalido	");
        map.put("008","	Error en calculo Limite de Credito	");
        map.put("009","	Monto a Acreditar supera Limite de Cta	");
        map.put("010","	Error en la Acreditacion	");
        map.put("011","	Error en Generacion del Movimiento DB/CR	");
        map.put("012","	Tipo Cuenta no existe o no esta Activo	");
        map.put("013","	Nro de Cuenta no existe	");
        map.put("014","	Pin no coincide c/ el regist. en la Cta	");
        map.put("015","	Cuenta inv. por valida. por Procesos	");
        map.put("016","	Falta parametros del sistema	");
        map.put("017","	La Cuenta esta bloqueada x otro proceso	");
        map.put("018","	Nuevo Estado no paramet p/ Cambio Estado	");
        map.put("019","	Usuario no autorizado p/ Cambio Estado	");
        map.put("020","	Serie ICCID bloqueado por otro Usuario	");
        map.put("021","	El IMEI esta activo en el Sistema	");
        map.put("022","	El IMEI se encuentra en el Inventario	");
        map.put("023","	El nuevo SubTipoCta invalido p/ la Cta	");
        map.put("024","	El Codigo de Marca Modelo no existe	");
        map.put("025","	Cod MarcaMod no coincide c/ el ingresado	");
        map.put("026","	El IMEI de la Cuenta es invalido	");
        map.put("027","	Serie ICCID es invalido o esta en Blanco	");
        map.put("028","	EH Vend. no corresponde a la Serie ICCID	");
        map.put("029","	El Plan Consumo es invalido o no existe	");
        map.put("030","	EH Vend. es invalido o no existe	");
        map.put("031","	Nro Doc. de Ident. ingresado es invalido	");
        map.put("032","	La Fecha de Nac. ingresado es invalido	");
        map.put("033","	Plan Comercial es invalido o no existe	");
        map.put("034","	La Cuenta ya esta Nominativizada	");
        map.put("035","	Cod P. Física o Jurídica no corresponde	");
        map.put("036","	El legajo de la Cuenta esta en proceso	");
        map.put("037","	La Cuenta no esta Nominativizada	");
        map.put("038","	Nro Doc Iden. no existe	");
        map.put("039","	Se ha creado el legajo de la cuenta	");
        map.put("040","	Nro Cuenta no Disponible	");
        map.put("041","	Nro Cuenta con Estado Reservado	");
        map.put("042","	No se pudo realizar la Transf. Contrato         	");
        map.put("043","	Nro Cuenta Solicitante invalido	");
        map.put("044","	La Cuenta ya posee Pin	");
        map.put("045","	La Cuenta no posee Limite de Consumo	");
        map.put("046","	Debe ingresar Nuevo Limte de Consumo	");
        map.put("047","	Nuevo Lim Consumo es menor al Limite Min	");
        map.put("048","	Nuevo Lim Consumo es mayor al Limite Max	");
        map.put("049","	Nuevo Lim Consumo es <= al Lim Actual	");
        map.put("050","	Doc ident supera Lim Max Cant Ctas a Reg	");
        map.put("051","	La Promocion ya no se encuentra vigente	");
        map.put("052","	Falta parametrizacion para Promocion	");
        map.put("053","	Cta debe ser Prepago/Pospago tipo FFija	");
        map.put("054","	Saldo Cta es menor al Monto a Transferir	");
        map.put("055","	Servicio no existe	");
        map.put("056","	Servicio no es válido	");
        map.put("057","	Codigo de Agrupador no existe	");
        map.put("058","	Codigo de Agrupador no es válido	");
        map.put("059","	Operación o Acción no válida	");
        map.put("060","	Error Asignar o Eliminar Servicio a Cta	");
        map.put("061","	Error en Validaciones de Cambio de Plan	");
        map.put("062","	La cuenta no posee valor agregado	");
        map.put("063","	Cta supera lim max de consulta permitido	");
        map.put("064","	Error en el procesamiento de respuesta	");
        map.put("065","	Error en la Cuenta del Agente	");
        map.put("066","	Agente invalido	");
        map.put("067","	Error interno en la aplicacion	");
        map.put("068","	Credito invalido	");
        map.put("069","	Error en la Base de Datos	");
        map.put("070","	Error general en la aplicacion	");
        map.put("071","	PIN Valido (Administrador)	");
        map.put("072","	No existe PIN	");
        map.put("073","	PIN Invalido	");
        map.put("074","	PIN sera bloqueado x intentos fallidos	");
        map.put("075","	El PIN se encuentra bloqueado	");
        map.put("076","	PIN Valido (no Administrador)	");
        map.put("077","	Primera vez que ingresa debe cambiar PIN	");
        map.put("078","	Su PIN ha caducado, debe cambiar	");
        map.put("079","	El PIN ha sido cambiado	");
        map.put("080","	El PIN ha sido bloqueado	");
        map.put("081","	Accion Valida	");
        map.put("082","	Existe una solicitud de cambio en proces	");
        map.put("083","	Solicitud Realizada	");
        map.put("084","	Solicitud Confirmada	");
        map.put("085","	Solicitud Cancelada	");
        map.put("086","	No hay Perfil Base para Tipo Usuario	");
        map.put("087","	No hay Perfil Base para Tipo Usuario	");
        map.put("088","	Perfil no posee acceso a dicha operacion	");
        map.put("089","	Existe una solicitud de cambio en proces	");
        map.put("090","	No existe solicitud para dicha cuenta	");
        map.put("091","	PIN solo puede estar compuesto por nros	");
        map.put("092","	Supero la cant de digitos para nuevo PIN	");
        map.put("093","	No alcanzo cant min d digito p nuevo PIN	");
        map.put("094","	El PIN debe ser solo numerico	");
        map.put("095","	Solicitud no finalizado correctamente	");
        map.put("096","	Accion no Activa	");
        map.put("097","	No existen datos para mostrar	");
        map.put("098","	Nro Cta Vendedor no valido	");
        map.put("099","	Ehumano no posee Nro Cta Vendedor	");
        map.put("100","	Red congestionada intente mas tarde	");
        map.put("101","	Card Identification no es Valido	");
        map.put("102","	Card Identification no Identificado	");
        map.put("103","	Card Identification Estado Activa	");
        map.put("104","	Card Identification Estado Bloqueado	");
        map.put("105","	Card Identification Estado Usado	");
        map.put("106","	Card Identification Estado Robado	");
        map.put("107","	Card Identification Estado Entregado	");
        map.put("108","	Identificador Individual Entregado	");
        map.put("109","	Identificador Individual Disponible	");
        map.put("110","	Operador Tipo no parametrizado	");
        map.put("111","	Esa cuenta ya está configurada	");
        map.put("112","	Instructor no existe o no está activo	");
        map.put("113","	Configurador no existe o no está activo	");
        map.put("114","	Cuenta no configurada	");
        map.put("115","	Configurador no posee instructo asociado	");
        map.put("116","	Configurador ya posee instructo asociado	");
        map.put("117","	Cta Origen no asociada al Administrador	");
        map.put("118","	Cuenta configurada Inactiva	");
        map.put("119","	Configurador no esta asociado a Instruct	");
        map.put("120","	Error al obtener cliente contrato	");
        map.put("121","	El Nro de Solicitud ya fue utilizado	");
        map.put("122","	Error al grabar solicitud	");
        map.put("123","	Error al grabar expediente	");
        map.put("124","	No se pudo obtener Ciclo de Facturacion	");
        map.put("125","	No encontro Numero Cuenta libre	");
        map.put("126","	Opcion no esta Operativo	");
        map.put("127","	Estado Cuenta Invalido	");
        map.put("128","	Cuenta Invalido Proceso	");
        map.put("129","	Segmento Invalido Proceso	");
        map.put("130","	No Existe Cobranza o esta Anulado	");
        map.put("131","	Ha sobrepasado su limite de compromisos	");
        map.put("132","	Error al Procesar Reconexion	");
        map.put("133","	Ya existe Cambio de Plan Pendiente	");
        map.put("134","	Roaming no habilitado p/ el Plan Consumo	");
        map.put("135","	La cuenta posee roaming activo	");
        map.put("136","	La Cta no tiene asociado una Serie ICCID	");
        map.put("137","	La Cuenta esta registrada como robada	");
        map.put("138","	La Cuenta no esta registrada como robada	");
        map.put("139","	El Identificador del equipo no es valido	");
        map.put("140","	El Usuario ya Existe	");
        map.put("141","	Error al insertar Cuenta	");
        map.put("142","	No existen rangos p/ generar nro recibo	");
        map.put("143","	No se puede generar el comprobante	");
        map.put("144","	Error en la consulta de saldo	");
        map.put("145","	Datos Enviados	");
        map.put("146","	Datos no actualizados	");
        map.put("147","	Transaccion en proceso	");
        map.put("148","	Trafico insuficiente para la transaccion	");
        map.put("149","	Cliente ya tiene cuenta activa	");
        map.put("150","	Saldo de Garantia Vendedor insuficiente	");
        map.put("151","	Cliente no Existe	");
        map.put("152","	Error en Tipo Persona Fisica o Juridica	");
        map.put("153","	No Existe Persona Juridica	");
        map.put("154","	No existe Doc Ident Representante Cta	");
        map.put("155","	Error en la Respuesta de Informconf	");
        map.put("156","	La cuenta no posee el Servicio	");
        map.put("157","	Bloqueo de PIN por Fraude	");
        map.put("158","	Bloqueo Voluntario de PIN	");
        map.put("159","	El Vend no está asociado a ningún Agente	");
        map.put("160","	Cod Agente Solicitado no Corresponde	");
        map.put("161","	El Rango de Fecha es mayor al permitido	");
        map.put("162","	No esta permitido la reimpresión Factura	");
        map.put("163","	IMEI registrado en el sistema inválido	");
        map.put("164","	Fecha periodo inválido	");
        map.put("165","	Canal de venta no habilitado	");
        map.put("166","	Supera la cant consulta permitidas x dia	");
        map.put("167","	No se recibio el Nro de Cuenta	");
        map.put("168","	Nro Cuenta no pertenece al Cliente	");
        map.put("169","	La Transaccion no puede realizarse	");
        map.put("170","	Cuenta no valida para esta operación	");
        map.put("171","	Transaccion en proceso	");
        map.put("172","	Transaccion reconfimada	");
        map.put("173","	Monto no supera el minimo facturable	");
        map.put("174","	Solicitud no confirmada	");
        map.put("175","	Solicitud ya confirmada	");
        map.put("176","	EL Usuario no tiene registrado su Nro CI	");
        map.put("177","	Existen datos requeridos nulos	");
        map.put("178","	La cuenta ya esta registrada	");
        map.put("179","	Tipo de documento incorrecto	");
        map.put("180","	El imei ya se encuentra registrado	");
        map.put("181","	Vuelva a reintentar	");
        map.put("182","	Vendedor no habilitado para nominar	");
        map.put("183","	Nro cuenta no activada por vendedor	");
        map.put("184","	No tiene edad suficiente para registrar	");
        map.put("185","	IMEI no enviado a la plataforma EIR	");
        map.put("186","	Monto supera al max permitido	");
        map.put("187","	Nro Cuenta Prepaga no registrada	");
        map.put("188","	Nro cuenta Pospaga no registrada	");
        map.put("189","	El Equipo no esta registrado	");
        map.put("190","	Nro Cuenta recibida nula	");
        map.put("191","	La Linea es una Cuenta Pospaga	");
        map.put("192","	Ciudad ingresada invalida	");
        map.put("193","	Cargo de equipo humano invalido	");
        map.put("194","	IMEI no Valido	");
        map.put("195","	Operador no encontrado	");
        map.put("196","	Tipo de Operacion invalida	");
        map.put("197","	Tipo de lista incorrecta	");
        map.put("198","	Ya existe el IMEI en el operador Tigo	");
        map.put("199","	El IMEI se encuentra en la Lista Gris	");
        map.put("200","	El IMEI se encuentra en la Lista Negra	");
        map.put("201","	IMEI registrado con otro Nro Documento	");
        map.put("202","	El IMEI no se encuentra registrado	");
        map.put("203","	El IMEI se encuentra en la Lista Blanca	");
        map.put("204","	El IMEI IMSI no se encuentra disponible	");
        map.put("205","	El Nro de pase del IMEI es incorrecto	");
        map.put("206","	El IMEI IMSI no se encuentra registrado	");
        map.put("207","	Error el IMIE IMSI ya fue dado de baja	");
        map.put("208","	Motivo de registro incorrecto	");
        map.put("209","	Time out en la consulta Nro Documento	");
        map.put("210","	Cantidad de dias deber ser mayor a cero	");
        map.put("211","	Cargo de equipo humano No existe	");
        map.put("212","	No existe Cargo Vendedor Equival de Agen	");
        map.put("213","	No existe codigo de proceso	");
        map.put("214","	Error en coordenadas GPS	");
        map.put("215","	No se pudo enviar comando a la NPU	");
        map.put("216","	No se visualiza modulacion	");
        map.put("217","	No hay respuesta de la NPU	");
        map.put("218","	No se encontro el enlace	");
        map.put("219","	El enlace supera parametros permitidos	");
        map.put("220","	No concuerda distancia NPU/GPS	");
        map.put("221","	Tecnico no esta asociado a Partner	");
        map.put("222","	Solicitud no pertenece al Partner	");
        map.put("223","	No se encuentra numero de Solicitud	");
        map.put("224","	No existe expediente para cuenta	");
        map.put("225","	Equipo ingresado no es Indoor	");
        map.put("226","	Equipo no esta en Deposito del Partner	");
        map.put("227","	Equipo ingresado no es outdoor	");
        map.put("228","	Celda no posee Tipo Interface	");
        map.put("229","	Celda no posee Valor Interface	");
        map.put("230","	Celda no encontrada para Ubicación	");
        map.put("231","	Mascara invalida	");
        map.put("232","	Tipo de Cliente Invalido	");
        map.put("233","	No se pudo obtener Vlan Libre	");
        map.put("234","	No se encuentra secuencia de cuenta	");
        map.put("235","	No encuentra IP libre para la celda	");
        map.put("236","	No pudo Obtener IP radio de la celda	");
        map.put("237","	Hubo errores en la Activacion	");
        map.put("238","	Cuenta no Asociada al Simcard	");
        map.put("239","	La Cuenta esta Bloqueada	");
        map.put("240","	El Simcard esta bloqueado	");
        map.put("241","	Error en Cambio de Simcard	");
        map.put("242","	No se pudo obtener IMSI	");
        map.put("243","	Error en validaciones de Simcard	");
        map.put("244","	No se pudo eliminar la cuenta	");
        map.put("245","	El parámetro tiene un valor inválido	");
        map.put("246","	Tarif.Plataforma no existe o no está act	");
        map.put("247","	Moneda no existe o es inválida	");
        map.put("248","	Grupo Impuesto no existe o es inválido	");
        map.put("249","	Tipo Transaccion inválido	");
        map.put("250","	Dias Validez inválido	");
        map.put("251","	Motivo no existe o es inválido	");
        map.put("252","	Nro Memo no existe o es inválido	");
        map.put("253","	Nro Reclamo Tickect no existe o es invál	");
        map.put("254","	No existe Monto Límite mes x E. Humano	");
        map.put("255","	No existe Monto Acumulado x E. Humano	");
        map.put("256","	El Monto excede el límite mes x E.Humano	");
        map.put("257","	Usuario no existe o es inválido	");
        map.put("258","	E.Humano no habilitado acreditar/debitar	");
        map.put("259","	Nro de SIMCARD recibida nula	");
        map.put("260","	No existe el Nro de SIMCARD	");
        map.put("261","	IMSI ingresado no coincide	");
        map.put("262","	No existe Monto Límite transacc.x E.Hum.	");
        map.put("263","	El Monto excede el límite transacc.x EH.	");
        map.put("264","	IMEI no habilitado para Prefijo	");
        map.put("265","	El IMEI IMSI dado baja x generación pase	");
        map.put("266","	Nro Pase recibido nulo	");
        map.put("267","	El IMEI esta nominado con otra cuenta	");
        map.put("268","	Nro Documento debe ser solo numero	");
        map.put("269","	Debe ingresar apellido paterno o materno	");
        map.put("270","	Existe Documento pero no Pfisica	");
        map.put("271","	No Existe Persona Fisica	");
        map.put("272","	Nro Documento ya existe	");
        map.put("273","	Ha superado la cantidad de transacciones	");
        map.put("274","	IMEI no posee datos	");
        map.put("275","	IMEI no existe en el stock	");
        map.put("276","	IMEI no posee SAIN	");
        map.put("277","	IMEI se encuentra en listas diferentes	");
        map.put("278","	No se Pudo Reciclar la cuenta	");
        map.put("279","	No se pudo Reservar la cuenta	");
        map.put("280","	Segmento Invalido para entrega de equipo	");
        map.put("281","	Equipo Humano en estado historico	");
        map.put("288","	Segmento Invalido para Activacion	");
        map.put("289","	Serie ICCID esta asoc a cuenta Activa	");
        map.put("290","	Llego al Lim Ctas a activarse por ICCID	");
        map.put("291","	Llego al Lim Ctas a activarse por ICCID	");
        map.put("293","	Error en la politica de credito	");
        map.put("300","	Cliente Epin no existe	");
        map.put("302","	Cuenta Epin invalido	");
        map.put("303","	Cuenta ya esta en maximo limite	");
        map.put("304","	Plan de consumo no posee limite base	");
        map.put("305","	Pin Invalido, no corresponde al EH	");
        map.put("306","	EHumano no corresponde a la cuenta	");
        map.put("307","	Cuenta no Habilitada para cambio de SIM	");
        map.put("308","	Descuento de garantia del jefe	");
        map.put("309","	Vendedor no tiene Work Station	");
        map.put("310","	No Existe Registro	");
        map.put("311","	Tipo cambio equipo Invalido	");
        map.put("312","	Error al obtener cargos por procesos	");
        map.put("313","	Tipo cuenta plan comercial !=Tipo Cuenta	");
        map.put("314","	Mod.Pago Plan Comercial !=M.P.Cuenta            	");
        map.put("315","	Plan Comercial no habil. p/ Ubic.	");
        map.put("316","	Plan Consumo no habil. p/ Ubic.	");
        map.put("317","	Producto no valido p/ Plan Comercial	");
        map.put("318","	Mot.Registrac.no habilitado p/Plan comer	");
        map.put("319","	Estado Invalido del Ident. Individual	");
        map.put("320","	Estado Invalido Ident.Indiv. en IDCTL	");
        map.put("321","	Modalidad Equipo != Sub Tipo cuenta	");
        map.put("322","	Servicio invalido p/ Modelo o Sub T.Cuen	");
        map.put("323","	No se debe ingresar Serie ICCID	");
        map.put("324","	Error en politica de entrega de equipo	");
        map.put("325","	No Ingrear Compr.p/este Tipo de Cambio	");
        map.put("326","	Tipo Comprob no parametrizado p/ Proceso	");
        map.put("327","	Tipo Comprob Invalido p/ Proceso	");
        map.put("328","	El Nro de Comprobante no existe	");
        map.put("329","	Estado Comprobante invalido	");
        map.put("330","	Comprobante invalido p/ la operación	");
        map.put("331","	Debe ingresar un comprobante	");
        map.put("332","	Ident.Indiv. Actual esta regist.en IDCTL	");
        map.put("336","	Vendedor no Habilitado p/ la ZONA	");
        map.put("337","	BIN de Tarjeta de Credito no corresponde	");
        map.put("339","	Nro Asignado no Habilitado para la ZONA	");
        map.put("340","	Zona de Venta Invalida	");
        map.put("341","	Nro cuenta Asignado Incorrecto	");
        map.put("342","	Doc. Identidad inválido	");
        map.put("343","	Cliente Moroso	");
        map.put("344","	Sim no habilitado para plan Consumo	");
        map.put("345","	Eq. Humano no Hab. para Vender POSPAGO	");
        map.put("346","	Ident.Indiv esta asociado a una cuenta	");
        map.put("347","	No coincide Cliente-Contr.Cuenta vs Comp	");
        map.put("348","	La Cuenta ya posee comodato	");
        map.put("355","	Cantidad de Cuotas inválida	");
        map.put("360","	La cuenta ya tiene asociado el servicio	");
        map.put("382","	La fecha debe ser igual al del sistema	");
        map.put("383","	El Plan de Consumo no tiene costo	");
        map.put("384","	Anticipo insuficiente p/ Retiro Equipo	");
        map.put("394","	Monto del servicio supera Límite de Cta	");
        map.put("395","	Fecha Invalida	");
        map.put("398","	La transaccion no existe	");
        map.put("399","	Tipo Simcard invalido p/ Plan de Consumo	");
        map.put("400","	1ro debe realizar cambio de simcard USIM	");
        map.put("999","	Error por defecto	");
        
            //conexion al socketde activacion pospago
            try{

                
                socket= new Socket(localH,65000);
                
            //flujo de entrada, es el flujo donde se recibira los mensajes provenientes
            //del socket servidor
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //te guarda en tec lo que se escribe en el tecldo
           // String tec= teclado.readLine();
            //flujo de salida, donde se le enviara los mensajes al socket servidor
            salida= new PrintStream(socket.getOutputStream());
            //se envia al servidor el mensaje
            salida.println("PPONAIR   AA15036000000000090189591030002045001150000000000000000505GSM                                 000101010000000000008959103000204500115                                                             ");
            String msgSalida =entrada.readLine(); 
            /*if(("   ".equals(msgSalida.substring(0, 3))) && ("   ".equals(msgSalida.substring(24, 27))))
            {
                System.out.println("eSTOY EN EL PRIMER IF");
                socketResp.setNroCliente(msgSalida.substring(48, 57));
                socketResp.setCodRespuesta(null);
                socketResp.setDescripcion(null);
            }                  
            else if("   ".equals(msgSalida.substring(0, 3))){
                System.out.println("eSTOY EN EL Segundo IF");
                Integer num=Integer.valueOf(msgSalida.substring(24, 27));
                socketResp.setCodRespuesta(num);
                System.out.println(msgSalida.substring(24, 27));
            
            }else{
                System.out.println(msgSalida.substring(0, 3));
            System.out.println("eSTOY EN EL TERCER IF");
            Integer num = Integer.valueOf(msgSalida.substring(0, 3));
            socketResp.setCodRespuesta(num);
            socketResp.setDescripcion(map.get(msgSalida.substring(0,3)));
            }*/

            
            //socketResp.setAdditionalParameters(null);
            
            
                System.err.println("cod mensaje= "+msgSalida.substring(0, 2));
            System.err.println("mensaje= "+map.get("0"+msgSalida.substring(0, 2)));
            if(msgSalida.substring(0, 2).equals("00"))
            {
                System.err.println("descripcion"+Integer.valueOf(msgSalida.substring(21, 29)));
            }
            
            
            count=5;
            
            
            
             return msgSalida;
                        
            }
            catch( UnknownHostException e ) {
                     System.out.println( e );

            }catch( IOException e ) {
                        System.out.println( e );
                    
            }
    return null;
    }
}
