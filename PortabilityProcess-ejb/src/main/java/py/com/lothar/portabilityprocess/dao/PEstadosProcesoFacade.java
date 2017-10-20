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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import py.com.lothar.portabilityprocess.entities.PEstadosProceso;
import py.com.lothar.portabilityprocess.log.LoggerUtil;

/**
 *
 * @author extiem
 */
@Stateless
public class PEstadosProcesoFacade extends AbstractFacade<PEstadosProceso> implements AbstractFacadeInterface<PEstadosProceso>{
    private static final Logger logger = LoggerUtil.getLogger(PEstadosProcesoFacade.class);
    
    @PersistenceContext(unitName = "PortabilidadBO_PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PEstadosProcesoFacade() {
        super(PEstadosProceso.class);
    }
    
    @Override
    public PEstadosProceso findByName(String name) {
        try{
            Query query = getEntityManager().createNamedQuery("PEstadosProceso.findByValor");
            query.setParameter("valor", name.toUpperCase());
            return (PEstadosProceso) query.getSingleResult();
        }catch(NoResultException ex){
            logger.error("La consulta no retorno datos, " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<PEstadosProceso> findByTransactionId(BigInteger transactionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PEstadosProceso> findByValidationId(BigInteger validationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PEstadosProceso> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
