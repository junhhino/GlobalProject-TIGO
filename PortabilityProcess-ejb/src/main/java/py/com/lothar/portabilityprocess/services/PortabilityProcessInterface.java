/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.services;

import java.util.List;
import javax.ejb.Local;
import py.com.lothar.portabilityprocess.entities.PTransacciones;
import py.com.lothar.portabilityprocess.entities.PValidaciones;

/**
 *
 * @author extiem
 */
@Local
public interface PortabilityProcessInterface {
    
    public void processValidationRequest(List<String> cuentas, PValidaciones validacion);
    
    public void processTransactionRequest(List<String> cuentas, PTransacciones transaccion);
    
}
