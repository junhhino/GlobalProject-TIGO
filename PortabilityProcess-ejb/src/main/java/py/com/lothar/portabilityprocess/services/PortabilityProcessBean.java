/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.services;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
//import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import py.com.lothar.portabilityprocess.dao.AbstractFacadeInterface;
import py.com.lothar.portabilityprocess.entities.PEstadosProceso;
import py.com.lothar.portabilityprocess.entities.PTransacciones;
import py.com.lothar.portabilityprocess.entities.PTransaccionesCuentas;
import py.com.lothar.portabilityprocess.entities.PValidaciones;
import py.com.lothar.portabilityprocess.entities.PValidacionesCuentas;
import py.com.lothar.portabilityprocess.log.LoggerUtil;

/**
 *
 * @author extiem
 */
@Stateless
public class PortabilityProcessBean implements PortabilityProcessInterface{    
    private static final org.apache.log4j.Logger logger = LoggerUtil.getLogger(PortabilityProcessBean.class);
    @EJB(beanName = "PTransaccionesCuentasFacade") 
    private AbstractFacadeInterface transaccionesCuentasFacade;
    @EJB(beanName = "PTransaccionesFacade") 
    private AbstractFacadeInterface transaccionesFacade;
    @EJB(beanName = "PValidacionesCuentasFacade") 
    private AbstractFacadeInterface validacionesCuentasFacade;
    @EJB(beanName = "PValidacionesFacade") 
    private AbstractFacadeInterface validacionesFacade;
    @EJB(beanName = "PEstadosProcesoFacade") 
    private AbstractFacadeInterface estadosProcesoFacade;
    @EJB(beanName = "PortabilityExecutorBean")
    private PortabilityExecutorInterface portabilityExecutorBean;
    
    public PortabilityProcessBean() {
    }
    
    //@Asynchronous
    /*@Override
    public void processTransactionRequest(List<String> cuentas, PTransacciones transaccion){
        String prefixLog = "[ " + transaccion.getIdTransaccion() + "] ";
        try{
            logger.log(Level.INFO, "{0} Procesar lista de cuentas.", prefixLog);
            PEstadosProceso estadoPendiente = (PEstadosProceso) estadosProcesoFacade.findByName(PEstadosProceso.PENDIENTE);
            int count = 0;
            for (String cuenta : cuentas) {
                PTransaccionesCuentas tcuentas = new PTransaccionesCuentas();
                tcuentas.setNroCuenta(cuenta);
                tcuentas.setFechaHoraAlta(new Date());
                tcuentas.setIdTransaccion(transaccion);
                tcuentas.setEstadoProcesoId(estadoPendiente);
                try{
                    Thread.sleep(100);
                    count++;
                    if(count >= 10){
                        logger.log(Level.INFO, "{0} Lanzando Exception de prueba...", prefixLog);
                        throw new Exception("Exception de prueba...");
                    }
                    transaccionesCuentasFacade.create(tcuentas);
                    logger.log(Level.INFO, "{0} Cuenta registrada para procesamiento: {1}", new Object[]{prefixLog, cuenta});
                } catch (Exception ex){
                    logger.log(Level.WARNING, "{0} No se pudo registrar la cuenta: {1}", new Object[]{prefixLog, cuenta});
                    logger.log(Level.WARNING, "Exception. ", ex);
                }
            }
            
            transaccion.setEstadoProcesoId(estadoPendiente);
            transaccionesFacade.edit(transaccion);
            logger.log(Level.INFO, "{0} Cuentas registrada exitosamente.", prefixLog);
        }catch(Exception ex){
            logger.log(Level.WARNING, "{0} Se ha producido un error al procesar lista de cuentas.", prefixLog);
            logger.log(Level.WARNING, "Exception. ", ex);
        }
    }*/

    @Override
    public void processTransactionRequest(final List<String> cuentas, final PTransacciones transaccion) {
        Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                String prefixLog = "[ " + transaccion.getIdTransaccion() + "] ";
                try{
                    logger.info(prefixLog + "Procesar lista de cuentas");
                    PEstadosProceso estadoPendiente = (PEstadosProceso) estadosProcesoFacade.findByName(PEstadosProceso.PENDIENTE);
                    for (String cuenta : cuentas) {
                        PTransaccionesCuentas tcuentas = new PTransaccionesCuentas();
                        tcuentas.setNroCuenta(cuenta);
                        tcuentas.setFechaHoraAlta(new Date());
                        tcuentas.setIdTransaccion(transaccion);
                        tcuentas.setEstadoProcesoId(estadoPendiente);
                        try{
                            transaccionesCuentasFacade.create(tcuentas);
                            logger.info(prefixLog + "Cuenta registrada para procesamiento: " + cuenta);
                        } catch (Exception ex){
                            logger.error(prefixLog + "No se pudo registrar la cuenta: " + cuenta);
                            logger.error(prefixLog + "Exception. ", ex);
                        }
                    }

                    transaccion.setEstadoProcesoId(estadoPendiente);
                    transaccionesFacade.edit(transaccion);
                    logger.info(prefixLog + "Cuentas registradas exitosamente");
                }catch(Exception ex){
                    logger.error(prefixLog + "Se ha producido un error al procesar lista de cuentas");
                    logger.error(prefixLog + "Exception. ", ex);
                }
            }
        };
        logger.info("[" + transaccion.getIdTransaccion() + "] Iniciando tarea para grabar cuentas, transaction");
        portabilityExecutorBean.processRequest(new Thread(runnable));
    }

    @Override
    public void processValidationRequest(final List<String> cuentas, final PValidaciones validacion) {
         Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                String prefixLog = "[ " + validacion.getValidacionId() + "] ";
                try{
                    logger.info(prefixLog + "Procesar lista de cuentas");
                    PEstadosProceso estadoPendiente = (PEstadosProceso) estadosProcesoFacade.findByName(PEstadosProceso.PENDIENTE);
                    for (String cuenta : cuentas) {
                        PValidacionesCuentas vCuentas = new PValidacionesCuentas();
                        vCuentas.setNroCuenta(cuenta);
                        vCuentas.setFechaHoraAlta(new Date());
                        vCuentas.setValidacionId(validacion);
                        vCuentas.setEstadoProcesoId(estadoPendiente);
                        try{
                            validacionesCuentasFacade.create(vCuentas);
                            logger.info(prefixLog + "Cuenta registrada para procesamiento: " + cuenta);
                        } catch (Exception ex){
                            logger.error(prefixLog + "No se pudo registrar la cuenta: " + cuenta);
                            logger.error(prefixLog + "Exception. ", ex);
                        }
                    }
                    validacion.setEstadoProcesoId(estadoPendiente);
                    validacionesFacade.edit(validacion);
                    logger.info(prefixLog + "Cuentas registradas exitosamente");
                }catch(Exception ex){
                    logger.error(prefixLog + "Se ha producido un error al procesar lista de cuentas");
                    logger.error(prefixLog + "Exception. ", ex);
                }
            }
        };
        logger.info("[" + validacion.getValidacionId() + "] Iniciando tarea para grabar cuentas, validaciones");
        portabilityExecutorBean.processRequest(new Thread(runnable));
    }
    
}
