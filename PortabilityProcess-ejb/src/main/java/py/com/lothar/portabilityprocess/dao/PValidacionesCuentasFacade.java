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
import javax.persistence.Query;
import py.com.lothar.portabilityprocess.entities.PValidacionesCuentas;

/**
 *
 * @author extiem
 */
@Stateless
public class PValidacionesCuentasFacade extends AbstractFacade<PValidacionesCuentas> implements AbstractFacadeInterface<PValidacionesCuentas>{
    @PersistenceContext(unitName = "PortabilidadBO_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PValidacionesCuentasFacade() {
        super(PValidacionesCuentas.class);
    }

    @Override
    public PValidacionesCuentas findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PValidacionesCuentas> findByTransactionId(BigInteger transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PValidacionesCuentas> findByValidationId(BigInteger validationId) {
        Query query = getEntityManager().createQuery("SELECT p FROM PValidacionesCuentas p WHERE p.validacionId.validacionId = :validationId");
        query.setParameter("validationId", validationId);
        return query.getResultList();
    }

    @Override
    public List<PValidacionesCuentas> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
