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
import py.com.lothar.portabilityprocess.entities.PValidaciones;

/**
 *
 * @author extiem
 */
@Stateless
public class PValidacionesFacade extends AbstractFacade<PValidaciones> implements AbstractFacadeInterface<PValidaciones>{
    @PersistenceContext(unitName = "PortabilidadBO_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PValidacionesFacade() {
        super(PValidaciones.class);
    }
    
    @Override
    public PValidaciones findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PValidaciones> findByTransactionId(BigInteger transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PValidaciones> findByValidationId(BigInteger validationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PValidaciones> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
