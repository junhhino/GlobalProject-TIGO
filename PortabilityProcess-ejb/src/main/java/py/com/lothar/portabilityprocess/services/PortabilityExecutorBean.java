/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.services;

import javax.ejb.Stateless;

/**
 *
 * @author extiem
 */
@Stateless
public class PortabilityExecutorBean implements PortabilityExecutorInterface{
    
    
    @Override
    public void processRequest(Thread task){
        task.start();
    }
}
