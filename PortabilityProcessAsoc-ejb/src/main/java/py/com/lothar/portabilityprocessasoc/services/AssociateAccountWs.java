/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocessasoc.services;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import java.io.UnsupportedEncodingException;

import javax.ejb.Stateless;
import py.com.lothar.portabilityprocessasoc.dto.AdditionalParameters;
import py.com.lothar.portabilityprocessasoc.response.AssociateAccountResponse;
import py.com.lothar.portabilityprocessasoc.dto.*;

/**
 *
 * @author fran
 */
@WebService(serviceName = "AssociateAccountWs")
@Stateless()
public class AssociateAccountWs {

     
        
    /**
    * Metodo que asocia una cuenta porta a una cuenta temporal con la opcion
    * de decidir  la consulta o no al Gateway
    * 
    * @param nroCuenta 
    * @param nroCuentaPort
    * @param iccid
    * @param consultarGetway 
    * @param additionalParameters 
    * @return {AsociateAccountResponse} 
     * @throws UnsupportedEncodingException 
    * 
    */
   	    
    @WebMethod(operationName = "associateAccount")
    public AssociateAccountResponse associateAccount(@WebParam(name = "nroCuenta") 
    String nroCuenta, @WebParam (name = "nroCuentaPort") String nroCuentaPort,
    @WebParam (name= "iccid") Integer iccid, @WebParam (name= "consultarGetway") Integer consultarGetway, 
    @WebParam (name= "additionaParameters")   AdditionalParameters additionalParameters) throws UnsupportedEncodingException {

    
    
        
    PlexProcess connect= new PlexProcess();
    
    connect.run();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        AssociateAccountResponse r= new AssociateAccountResponse();   
        r.setCodigoProceso(2);
        r.setIdTransaccion(12);
        r.setDescripcion("");
        
        
        
        
        return r;
    }   
}
