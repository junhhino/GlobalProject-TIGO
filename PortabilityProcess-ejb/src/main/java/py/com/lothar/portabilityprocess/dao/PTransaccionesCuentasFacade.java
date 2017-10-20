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
import py.com.lothar.portabilityprocess.entities.PTransaccionesCuentas;

/**
 *
 * @author extiem
 */
@Stateless
public class PTransaccionesCuentasFacade extends AbstractFacade<PTransaccionesCuentas> implements AbstractFacadeInterface<PTransaccionesCuentas>{
    @PersistenceContext(unitName = "PortabilidadBO_PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PTransaccionesCuentasFacade() {
        super(PTransaccionesCuentas.class);
    }

    @Override
    public PTransaccionesCuentas findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTransaccionesCuentas> findByTransactionId(BigInteger transactionId) {
        Query query = getEntityManager().createQuery("SELECT p FROM PTransaccionesCuentas p WHERE p.idTransaccion.idTransaccion = :transactionId");
        query.setParameter("transactionId", transactionId);
        return query.getResultList();
    }

    @Override
    public List<PTransaccionesCuentas> findByValidationId(BigInteger validationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTransaccionesCuentas> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode) {
        Query query = getEntityManager().createQuery("SELECT p FROM PTransaccionesCuentas p WHERE p.nroCuenta = :msisdn AND p.idTransaccion.codigoProceso = :processCode ORDER BY p.fechaHoraAlta DESC");
        query.setParameter("msisdn", msisdn);
        query.setParameter("processCode", processCode);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return query.getResultList();
    }
    
    
}
