/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocessactivationprepago.services;


import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import py.com.lothar.portabilityprocessactivationprepago.dto.AdditionalParameters;
import py.com.lothar.portabilityprocessactivationprepago.response.ActivationPrepagoResponse;
import py.com.lothar.portabilityprocessactivationprepago.dto.InvocationSocket;

        
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
     * @param codTransaccion
     * @param codProceso
     * @param codVendedorPpaonair
     * @param codPinVendedor
     * @param planConsumoEquival
     * @param modoEquipoEquival
     * @param imei
     * @param nroAsignado
     * @param zonaVenta
     * @param subTipoCuenta
     * @param docIdentidad
     * @param nroActivador
     * @param fechaNacimiento
     * @param codPinActivacion
     * @param iccid
     * @param nroFormulario
     * @param additionalParameters
     * @return
     * @throws IOException 
     */
    @WebMethod(operationName = "activationprepago")
    public ActivationPrepagoResponse activationPrepago(
        @WebParam(name = "codTransaccion") String codTransaccion,
        @WebParam(name = "codProceso") String codProceso,
        @WebParam(name = "codVendedorPpaonair") Integer codVendedorPpaonair,
        @WebParam(name = "codpinvendedor") String codPinVendedor,
        @WebParam(name = "planconsumoequival") String planConsumoEquival,
        @WebParam(name = "modoequipoeqivalente") String modoEquipoEquival,
        @WebParam(name = "imei") String imei,
        @WebParam(name = "nroAsignado") String nroAsignado,
        @WebParam(name = "zonaventa") String zonaVenta,
        @WebParam(name = "subtipocuenta") String subTipoCuenta,
        @WebParam(name = "documentoidentidad") Integer docIdentidad,
        @WebParam(name = "nroActivador") Integer  nroActivador,
        @WebParam(name = "fechaNacimiento") Integer fechaNacimiento,
        @WebParam(name = "codPinActivacion") Integer codPinActivacion,
        @WebParam(name = "iccid") Integer iccid,
        @WebParam(name = "nroformulario") Integer nroFormulario,
        @WebParam(name = "additionalparameters") AdditionalParameters additionalParameters) throws IOException {
        
        Integer x;
        String zero="0";
        String mensaje=codTransaccion; 
        
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
        
        mensaje=mensaje.concat(String.valueOf(codPinActivacion));
        for(x=mensaje.length();x<27;x++){
            mensaje=mensaje.concat(" ");
        }
        
        mensaje=mensaje.concat(planConsumoEquival);
               
        
        for(x=mensaje.length();x<(30-String.valueOf(modoEquipoEquival).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(modoEquipoEquival));
        
        mensaje= mensaje.concat(imei);
        for(x=mensaje.length();x<49;x++){
            mensaje=mensaje.concat(" ");
        }
        
        for(x=mensaje.length();x<59;x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(nroAsignado));
        
        for(x=mensaje.length();x<(68-zonaVenta.length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(zonaVenta);
        
        mensaje=mensaje.concat(subTipoCuenta);
        for(x=mensaje.length();x<(74-subTipoCuenta.length());x++){
            mensaje=mensaje.concat(zero);
        }
        
        for(x=mensaje.length();x<(94-String.valueOf(docIdentidad).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(docIdentidad));
        
        for(x=mensaje.length();x<(104-String.valueOf(nroActivador).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(nroActivador));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String fechaNacimientoString = sdf.format(fechaNacimiento);
        mensaje=mensaje.concat(fechaNacimientoString);
        
        for(x=mensaje.length();x<(124-String.valueOf(codPinActivacion).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(codPinActivacion));
        
        for(x=mensaje.length();x<(143-String.valueOf(iccid).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(iccid));
        
        for(x=mensaje.length();x<(154-String.valueOf(nroFormulario).length());x++){
            mensaje=mensaje.concat(zero);
        }
        mensaje=mensaje.concat(String.valueOf(nroFormulario));
        
        for(x=mensaje.length();x<233;x++){
            mensaje=mensaje.concat(" ");
        }

        InvocationSocket sock= new InvocationSocket();
         ActivationPrepagoResponse resp=sock.initConnectiotSocket(mensaje);

            return resp;
    }
}