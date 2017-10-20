/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.dao;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author extiem
 */
@Local
public interface AbstractFacadeInterface<T> {

    public void create(T entity);

    public void edit(T entity);

    public void remove(T entity);

    public T find(Object id);
    
    public T findByName(String name);
    
    public List<T> findByTransactionId(BigInteger transactionId);
    
    public List<T> findByValidationId(BigInteger validationId);
    
    public List<T> findByMsisdnAndProcessCode(String msisdn, BigInteger processCode);
}
