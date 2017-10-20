/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.lothar.portabilityprocess.entities.PTiposInbound;
import py.com.lothar.portabilityprocess.log.LoggerUtil;

/**
 *
 * @author extiem
 */
@Stateless
public class PTiposInboundFacade extends AbstractFacade<PTiposInbound> implements AbstractFacadeInterface<PTiposInbound>{
    
    private static final org.apache.log4j.Logger logger = LoggerUtil.getLogger(PTiposInboundFacade.class);
    
    @PersistenceContext(unitName = "PortabilidadBO_PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PTiposInboundFacade() {
        super(PTiposInbound.class);
    }
    
    @Override
    public PTiposInbound findByName(String name) {
        try{
            Query query = getEntityManager().createNamedQuery("PTiposInbound.findByTipo");
            query.setParameter("tipo", name.toUpperCase());
            return (PTiposInbound) query.getSingleResult();
        }catch(NoResultException ex){
            logger.error("La consulta no retorno datos, " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<PTiposInbound> findByTransactionId(BigInteger transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTiposInbound> findByValidationId(BigInteger validationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PTiposInbound> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
