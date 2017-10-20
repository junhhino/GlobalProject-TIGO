/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javaapplication6.NominationResponse;

/**
 *
 * @author Fran
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, JAXBException {
        // TODO code application logic here\\
        String resp = null;
        String tipoPersona="F";
        String localhost="73.37.0.42";
        Integer port= 65017;
        BufferedReader entrada, teclado;
        PrintStream salida;

        //File file = new File("C:\\Users\\Fran\\Desktop\\file.xml");
        /*InvocationSocket socketconn = new InvocationSocket();
        
        String nombresString;
        String apellidoString;
        String fechaNacimientoString;
        String zero="0";
        Integer x;
        String mensaje;
        
        String nombres="maria", apellido="lopez", nroDocumento="123456nrodoc",
                oep="123456oep",Nacionalidad="ext", formaRegistro="web",
                nroCuenta="123nroCta", registraCuenta="S",imei="",registraImei="N";
        Date fechaNacimiento= new Date();
        Integer tipoDocumento=25;
        
        
        mensaje=String.valueOf(tipoPersona);
                
        nombresString= nombres.toUpperCase();
        mensaje=mensaje.concat(nombresString);
        for(x=1+mensaje.length();x<42;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        apellidoString= apellido.toUpperCase();
        mensaje=mensaje.concat(apellidoString);
        for(x=mensaje.length();x<82;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        fechaNacimientoString = sdf.format(fechaNacimiento);
        mensaje=mensaje.concat(fechaNacimientoString);
        
        if(tipoDocumento/10>0)
            mensaje=mensaje.concat(String.valueOf(tipoDocumento));
        else
            mensaje=mensaje.concat(zero).concat(String.valueOf(tipoDocumento));
        
        mensaje=mensaje.concat(nroDocumento);
        for(x=mensaje.length();x<112;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(oep);
        for(x=mensaje.length();x<132;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(Nacionalidad);
        for(x=mensaje.length();x<135;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(formaRegistro);
        for(x=mensaje.length();x<145;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(nroCuenta);
        for(x=mensaje.length();x<155;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(registraCuenta);
        
        mensaje=mensaje.concat(imei);
        for(x=mensaje.length();x<175;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(registraImei);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        System.out.println(mensaje);
            
        try {

              
              JAXBContext jaxbContext = JAXBContext.newInstance(test.class);
              Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

              // output pretty printed
              jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

              jaxbMarshaller.marshal(customer, file);
              jaxbMarshaller.marshal(customer, System.out);

            } catch (JAXBException e) {
            }

        try{
            
            Socket socket= new Socket(localhost,port); 
            
            //flujo de entrada, es el flujo donde se recibira los mensajes provenientes
            //del socket servidor
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           
            teclado = new BufferedReader(new InputStreamReader(System.in));
            //te guarda en tec lo que se escribe en el tecldo
           // String tec= teclado.readLine();
            //flujo de salida, donde se le enviara los mensajes al socket servidor
            salida= new PrintStream(socket.getOutputStream());
            //se envia al servidor el mensaje
            salida.println("PMARIA  ");      
            String msgSalida = entrada.readLine();
            
            //InvocationSocket socketconn = new InvocationSocket();
           // NominationResponse socketresp = socketconn.initConnectiotSocket("FMARIA");
            
           // System.out.println(socketresp.getCodRespuesta()+"|"+socketresp.getDescripcion()+"|"+socketresp.getNroCliente());
             System.out.println(msgSalida);
           
        }
        catch( UnknownHostException e ) {
               System.out.println( e );
               System.out.println("No se conecto al socket1");
        }catch( IOException e ) {
               System.out.println( e );
               System.out.println("No se conecto al socket");
        }*/
        
        
        /*String mensaje, proveedor="SMS", codProceso="AA",codVendString,
                zero="0",codVendedor="1535",nroCtaVendedor="542",tipoActivacion="A",tipoCliente="F",
                contString,docIdentidad="4165087",clienteString,formaPago="C",nroTarjetaCredito="123456789",
                planConsumoEquival="12",subTipoCuenta="123",imei="123456789",nroCuentaPreprogramado="123456",
                iccid="123456";
        Date fechaNacimiento=new Date();
                
                
        Integer x, codPinVendedor=15684,contrato=12345678,cliente=12345678,zonaVenta=12345678,nroFormulario=841643,modoEquipoEquival=12;
                
         mensaje=proveedor;
        for(x=mensaje.length();x<10;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(codProceso);
                System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        for(x=mensaje.length();x<12;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        
        codVendString=String.valueOf(codVendedor);
        for(x=mensaje.length();x<17-codVendString.length();x++)
        {
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(codVendString);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(String.valueOf(codPinVendedor));
        for(x=mensaje.length();x<27;x++)
        {
            mensaje=mensaje.concat(" ");
        }
           System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(nroCtaVendedor);
        for(x=mensaje.length();x<37;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(tipoActivacion);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(tipoCliente);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        contString=String.valueOf(contrato);
        for(x=mensaje.length();x<48-contString.length();x++)
        {
            mensaje=mensaje.concat(zero);
        }
        mensaje= mensaje.concat(contString);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(docIdentidad);
        for(x=mensaje.length();x<68;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fechaNacimientoString = sdf.format(fechaNacimiento);
        mensaje=mensaje.concat(fechaNacimientoString);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        clienteString=String.valueOf(cliente);
        for(x=mensaje.length();x<85-clienteString.length();x++)
        {
            mensaje=mensaje.concat(zero);
        }
        mensaje= mensaje.concat(clienteString   );
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje=mensaje.concat(formaPago);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje= mensaje.concat(nroTarjetaCredito);
        for(x=mensaje.length();x<102;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        if(planConsumoEquival.length()<2)
            mensaje=mensaje.concat(String.valueOf(planConsumoEquival));
        else
            mensaje=mensaje.concat(zero).concat(String.valueOf(planConsumoEquival));
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje= mensaje.concat(subTipoCuenta);
        for(x=mensaje.length();x<107;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje= mensaje.concat(imei);
        for(x=mensaje.length();x<126;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        String zonaVentaString=String.valueOf(zonaVenta);
        for(x=mensaje.length();x<135-zonaVentaString.length();x++)
        {
            mensaje= mensaje.concat(zero);
        }
        mensaje= mensaje.concat(zonaVentaString);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje= mensaje.concat(nroCuentaPreprogramado);
        for(x=mensaje.length();x<145;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        mensaje= mensaje.concat(iccid);
        for(x=mensaje.length();x<164;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        String nroForString=String.valueOf(nroFormulario);
        for(x=mensaje.length();x<175-nroForString.length();x++)
        {
            mensaje= mensaje.concat(zero);
        }
        mensaje= mensaje.concat(nroForString);
        System.out.println("este es el mensaje: '"+mensaje+"'esta es su longitud"+mensaje.length());
        String modoEEString=String.valueOf(modoEquipoEquival);
        for(x=mensaje.length();x<177-modoEEString.length();x++)
        {
            mensaje= mensaje.concat(zero);
        }
        mensaje= mensaje.concat(modoEEString);
        
        
      
        System.out.println();*/
        
        String	    codTransaccion	=	"PPONAIR"	;
String	                codProceso	=	"AA"	;
Integer	                codVendedorPpaonair	=	45176	;
String	                codPinVendedor	=	"12345"	;
String	                planConsumoEquival	=	"2"	;
Integer	                modoEquipoEquival	=	1	;
String	                imei	=	"8959103000364885009"	;
String	                nroAsignado	=	"0000000000"	;
String	                zonaVenta	=	"3"	;
String	                subTipoCuenta	=	"GSM"	;
String	                docIdentidad	=	""	;
String	                nroActivador	=	"77390461"	;
Date	                fechaNacimiento	=	new Date()	;
String	                codPinActivacion	=	""	;
String	                iccid	=	""	;
String	                nroFormulario	=	""	;


 Integer x;
        String    zero="0";
        String mensaje;        
        mensaje = codTransaccion;
        for(x=mensaje.length();x<10;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(codProceso);
        
        for(x=mensaje.length();x<12;x++){
            mensaje=mensaje.concat(" ");
        }
        
        for(x=mensaje.length();x<(17-String.valueOf(codVendedorPpaonair).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(codVendedorPpaonair));
        
        for(x=mensaje.length();x<(27-codPinActivacion.length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(codPinActivacion);
        
        for(x=mensaje.length();x<(30-String.valueOf(modoEquipoEquival).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(planConsumoEquival);
        
        mensaje=mensaje.concat(String.valueOf(modoEquipoEquival));
        
        mensaje= mensaje.concat(imei);
        for(x=mensaje.length();x<(49-imei.length());x++){
            mensaje=mensaje.concat(zero);
        }
        
        for(x=mensaje.length();x<(59-String.valueOf(nroAsignado).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(nroAsignado));
        
        for(x=mensaje.length();x<(68-String.valueOf(zonaVenta).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(zonaVenta));
        
        mensaje=mensaje.concat(subTipoCuenta);
        for(x=mensaje.length();x<(74-subTipoCuenta.length());x++){
            mensaje=mensaje.concat(zero);
        }
        
        for(x=mensaje.length();x<(94-docIdentidad.length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(docIdentidad);
        
        for(x=mensaje.length();x<(104-nroActivador.length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(nroActivador);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fechaNacimientoString = sdf.format(fechaNacimiento);
        mensaje=mensaje.concat(fechaNacimientoString);
        
        for(x=mensaje.length();x<(124-String.valueOf(codPinActivacion).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(codPinActivacion);
        
        for(x=mensaje.length();x<(143-iccid.length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(iccid);
        
        for(x=mensaje.length();x<(154-String.valueOf(nroFormulario).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(nroFormulario));
        
        for(x=mensaje.length();x<233;x++){
            mensaje=mensaje.concat(" ");
        }
        
        
        
        
        
        
        
        System.out.println(mensaje+"\n"+mensaje.length());
        
        
        
        
        
        
       
        InvocationSocket sock= new InvocationSocket();
       
        mensaje = sock.initConnectiotSocket("HOla");

        
    }
}