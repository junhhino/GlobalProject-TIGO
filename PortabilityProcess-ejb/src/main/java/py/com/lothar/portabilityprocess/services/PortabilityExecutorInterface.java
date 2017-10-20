/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.services;

import javax.ejb.Local;

/**
 *
 * @author extiem
 */
@Local
public interface PortabilityExecutorInterface {
    
    public void processRequest(Thread task);
}
