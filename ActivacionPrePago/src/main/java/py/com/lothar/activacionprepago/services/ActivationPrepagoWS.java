/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.activacionprepago.services;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import py.com.lothar.activacionprepago.dto.AdditionalParameters;
import py.com.lothar.activacionprepago.dto.InvocationSocket;
import py.com.lothar.activacionprepago.response.ActivationPrepagoResponse;


        
/**
 *
 * @author Fran
 */
@WebService(serviceName = "ActivationPrepagoWS")
@Stateless()
public class ActivationPrepagoWS {

    /**
     * This is a sample web service operation
     */
    
    /**
     * 
     * @param codVendedor
     * @param codPinVendedor
     * @param nroCtaVendedor
     * @param tipoActivacion
     * @param tipoCliente
     * @param contrato
     * @param docIdentidad
     * @param fechaNacimiento
     * @param cliente
     * @param formaPago
     * @param nroTarjetaCredito
     * @param planConsumoEquival
     * @param subTipoCuenta
     * @param imei
     * @param zonaVenta
     * @param nroCuentaPreprogramado
     * @param iccid
     * @param nroFormulario
     * @param modoEquipoEquival
     * @param additionalParameters
     * @return 
     */
    @WebMethod(operationName = "activationprepago")
    public ActivationPrepagoResponse activationPrepago(
            @WebParam(name = "codvendedor") Integer codVendedor,
            @WebParam(name = "codpinvendedor") String codPinVendedor,
            @WebParam(name = "nrocuentavendedor") String nroCtaVendedor,
            @WebParam(name = "tipoacitvacion") String tipoActivacion,
            @WebParam(name = "tipocliente") String tipoCliente,
            @WebParam(name = "contrato") Integer contrato,
            @WebParam(name = "documentoidentidad") String docIdentidad,
            @WebParam(name = "fechanacimiento") Date fechaNacimiento,
            @WebParam(name = "cliente") Integer cliente,
            @WebParam(name = "formapago") String formaPago,
            @WebParam(name = "nrotarjetacredito") String nroTarjetaCredito,
            @WebParam(name = "planconsumoequival") String planConsumoEquival,
            @WebParam(name = "subtipocuenta") String subTipoCuenta,
            @WebParam(name = "imei") String imei    ,
            @WebParam(name = "zonaventa") Integer zonaVenta,
            @WebParam(name = "nrocuentapreprogramado") String nroCuentaPreprogramado,
            @WebParam(name = "iccid") String iccid,
            @WebParam(name = "nroformulario") Integer nroFormulario,
            @WebParam(name = "modoequipoeqivalente") Integer modoEquipoEquival,
            @WebParam(name = "additionalparameters") AdditionalParameters additionalParameters) throws IOException {
        String proveedor="slkdfds", codProceso="ks", zero="0";
        String mensaje,codVendString,contString,
                clienteString, zonaVentaString,nroForString, modoEEString;
        ActivationPrepagoResponse resp= new ActivationPrepagoResponse();
        Integer x;
        
        
        mensaje=proveedor;
        for(x=mensaje.length();x<10;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(codProceso);
        for(x=mensaje.length();x<13;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        
        codVendString=String.valueOf(codVendedor);
        for(x=mensaje.length();x<18-codVendString.length();x++)
        {
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(codVendString);
        
        mensaje=mensaje.concat(codPinVendedor);
        for(x=mensaje.length();x<28;x++)
        {
            mensaje=mensaje.concat(" ");
        }

        mensaje=mensaje.concat(nroCtaVendedor);
        for(x=mensaje.length();x<38;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(tipoActivacion);
        
        mensaje=mensaje.concat(tipoCliente);
        
        contString=String.valueOf(contrato);
        for(x=mensaje.length();x<49-contString.length();x++)
        {
            mensaje=mensaje.concat(zero);
        }
        mensaje= mensaje.concat(contString);
        
        mensaje=mensaje.concat(docIdentidad);
        for(x=mensaje.length();x<69;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fechaNacimientoString = sdf.format(fechaNacimiento);
        mensaje=mensaje.concat(fechaNacimientoString);
        
        clienteString=String.valueOf(cliente);
        for(x=mensaje.length();x<86-clienteString.length();x++)
        {
            mensaje=mensaje.concat(zero);
        }
        mensaje= mensaje.concat(clienteString   );
        
        mensaje=mensaje.concat(formaPago);
        
        mensaje= mensaje.concat(nroTarjetaCredito);
        for(x=mensaje.length();x<103;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        if(planConsumoEquival.length()<2)
            mensaje=mensaje.concat(String.valueOf(planConsumoEquival));
        else
            mensaje=mensaje.concat(zero).concat(String.valueOf(planConsumoEquival));
        
        mensaje= mensaje.concat(subTipoCuenta);
        for(x=mensaje.length();x<108;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje= mensaje.concat(imei);
        for(x=mensaje.length();x<127;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        zonaVentaString=String.valueOf(zonaVenta);
        for(x=mensaje.length();x<136-zonaVentaString.length();x++)
        {
            mensaje= mensaje.concat(zero);
        }
        mensaje= mensaje.concat(zonaVentaString);
        
        mensaje= mensaje.concat(nroCuentaPreprogramado);
        for(x=mensaje.length();x<146;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        mensaje= mensaje.concat(iccid);
        for(x=mensaje.length();x<165;x++)
        {
            mensaje=mensaje.concat(" ");
        }
        
        nroForString=String.valueOf(nroFormulario);
        for(x=mensaje.length();x<176-nroForString.length();x++)
        {
            mensaje= mensaje.concat(zero);
        }
        mensaje= mensaje.concat(nroForString);
        
        modoEEString=String.valueOf(modoEquipoEquival);
        for(x=mensaje.length();x<178-modoEEString.length();x++)
        {
            mensaje= mensaje.concat(zero);
        }
        mensaje= mensaje.concat(modoEEString);
        
        InvocationSocket sock= new InvocationSocket();
        resp=sock.initConnectiotSocket(mensaje);
        
        
        
            return resp;
    }
}
