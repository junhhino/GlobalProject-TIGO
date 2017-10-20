/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.dao;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.lothar.portabilityprocess.entities.PTransacciones;

/**
 *
 * @author extiem
 */
@Stateless
public class PTransaccionesFacade extends AbstractFacade<PTransacciones> implements AbstractFacadeInterface<PTransacciones>{
    @PersistenceContext(unitName = "PortabilidadBO_PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PTransaccionesFacade() {
        super(PTransacciones.class);
    }

    @Override
    public PTransacciones findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTransacciones> findByTransactionId(BigInteger transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTransacciones> findByValidationId(BigInteger validationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTransacciones> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
