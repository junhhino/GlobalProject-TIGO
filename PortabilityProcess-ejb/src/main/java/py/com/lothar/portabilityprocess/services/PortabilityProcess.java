/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.services;

import com.tigo.xmlns.portability.portabilityprocess.v1.schema.DevolutionInfo;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.DevolutionInfoType;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.DocumentInfoType;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.ExecuteTransactionRequest;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.ExecuteTransactionResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetDevolutionResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPendingInvoicesQuantityResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPortOutValidationRequest;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPortOutValidationResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionByMsisdnRequest;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionByMsisdnResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionRequest;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnDataListType;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInformationType;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.PortOutValidationRequest;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.PortOutValidationResponse;
import com.tigo.xmlns.portability.portabilityprocess.v1.schema.StatusListType;
import com.tigo.xmlns.requestheader.v3.CountryContentType;
import com.tigo.xmlns.requestheader.v3.GeneralConsumerInfoType;
import com.tigo.xmlns.requestheader.v3.RequestHeader;
import com.tigo.xmlns.responseheader.v3.GeneralResponseType;
import com.tigo.xmlns.responseheader.v3.ObjectFactory;
import com.tigo.xmlns.responseheader.v3.ResponseHeader;
import com.tigo.xmlns.responseheader.v3.StatusContentType;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import py.com.lothar.middleware.operations.CommonsQuery;
import py.com.lothar.portabilityprocess.dao.AbstractFacadeInterface;
import py.com.lothar.portabilityprocess.entities.PEstadosProceso;
import py.com.lothar.portabilityprocess.entities.PTiposInbound;
import py.com.lothar.portabilityprocess.entities.PTransacciones;
import py.com.lothar.portabilityprocess.entities.PTransaccionesCuentas;
import py.com.lothar.portabilityprocess.entities.PValidaciones;
import py.com.lothar.portabilityprocess.entities.PValidacionesCuentas;
import py.com.lothar.portabilityprocess.log.LoggerUtil;
import py.com.lothar.portabilityprocess.util.Configuration;

/**
 *
 * @author extiem
 */
@Stateless
@WebService(serviceName = "PortabilityProcessService", portName = "PortabilityProcessPort", endpointInterface = "com.tigo.xmlns.portability.portabilityprocess.v1.PortabilityProcessPortType", targetNamespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1")

public class PortabilityProcess {

    private static final org.apache.log4j.Logger logger = LoggerUtil.getLogger(PortabilityProcess.class);
    private Configuration cfg = Configuration.getInstance();
    @EJB(beanName = "PTransaccionesFacade")
    private AbstractFacadeInterface transaccionesFacade;
    @EJB(beanName = "PTransaccionesCuentasFacade")
    private AbstractFacadeInterface transaccionesCuentasFacade;
    @EJB(beanName = "PValidacionesFacade")
    private AbstractFacadeInterface validacionesFacade;
    @EJB(beanName = "PValidacionesCuentasFacade")
    private AbstractFacadeInterface validacionesCuentasFacade;
    @EJB(beanName = "PTiposInboundFacade")
    private AbstractFacadeInterface tiposInboundFacade;
    @EJB(beanName = "PEstadosProcesoFacade")
    private AbstractFacadeInterface estadosProcesoFacade;
    @EJB(beanName = "PortabilityProcessBean")
    private PortabilityProcessInterface portabilityProcessBean;

    /**
     *
     * @param request
     * @return
     */
    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.PortOutValidationResponse portOutValidation(com.tigo.xmlns.portability.portabilityprocess.v1.schema.PortOutValidationRequest request) {
        final PortOutValidationResponse response = new PortOutValidationResponse();
        String correlationId = "";
        try {
            RequestHeader requestHeader = request.getRequestHeader();
            GeneralConsumerInfoType generalConsumer = requestHeader.getGeneralConsumerInformation();

            String consumerId = generalConsumer.getConsumerID().getValue();
            correlationId = generalConsumer.getCorrelationID();
            CountryContentType country = generalConsumer.getCountry().getValue();
            String transactionId = generalConsumer.getTransactionID().getValue();

            logger.info("RequestHeader");
            logger.info("ConsumerId: " + consumerId);
            logger.info("CorrelationId: " + correlationId);
            logger.info("Country: " + country.value());
            logger.info("TransactionId: " + transactionId);

            final PValidaciones validacion = new PValidaciones();

            PortOutValidationRequest.RequestBody requestBody = request.getRequestBody();
            DocumentInfoType legalEntity = requestBody.getLegalEntity();
            if (legalEntity != null) {
                validacion.setPjNumeroDocumento(legalEntity.getDocumentNumber());
                validacion.setPjTipoDocumento(legalEntity.getDocumentType());
            }
            PortOutValidationRequest.RequestBody.NaturalPerson naturalPerson = requestBody.getNaturalPerson();
            if (naturalPerson != null) {
                validacion.setPfExtension(naturalPerson.getExtension());
                validacion.setPfNumeroDocumento(naturalPerson.getDocumentNumber());
                validacion.setPfTipoDocumento(naturalPerson.getDocumentType());
            }
            List<String> lista = requestBody.getMsisdnList().getMsisdn();

            PEstadosProceso estadoCargando = (PEstadosProceso) estadosProcesoFacade.findByName(PEstadosProceso.CARGANDO);
            logger.info("Estado Proceso obtenido: " + estadoCargando);

            validacion.setExternalTransactionId(new BigInteger(transactionId));
            validacion.setFechaHoraAlta(new Date());
            validacion.setTipoInboundId((PTiposInbound) tiposInboundFacade.findByName(PTiposInbound.WEB_SERVICE));
            validacion.setEstadoProcesoId(estadoCargando);
            validacion.setCodProceso(new BigInteger("200"));

            validacionesFacade.create(validacion);
            logger.info("Registro de validacion creado, id: " + validacion.getValidacionId());

            //Ejecutar Hilo para procesar cuentas
            portabilityProcessBean.processValidationRequest(lista, validacion);

            PortOutValidationResponse.ResponseBody responseBody = new PortOutValidationResponse.ResponseBody();
            responseBody.setIdTransaction(validacion.getValidacionId());

            ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
            response.setResponseHeader(responseHeader);
            response.setResponseBody(responseBody);
            logger.info("Retornando respuesta, ValidacionId: " + validacion.getValidacionId() + " , ResponseCode: " + responseHeader.getGeneralResponse().getCode().getValue()
                    + " , ResponseDescription: " + responseHeader.getGeneralResponse().getDescription().getValue());
        } catch (Exception ex) {
            logger.error("Se ha producido un error al procesar solicitud.");
            logger.error("Exception", ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        }
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPortOutValidationResponse getPortOutValidation(com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPortOutValidationRequest request) {
        final GetPortOutValidationResponse response = new GetPortOutValidationResponse();
        String correlationId = "";
        try {
            RequestHeader requestHeader = request.getRequestHeader();
            GeneralConsumerInfoType generalConsumer = requestHeader.getGeneralConsumerInformation();
            GetPortOutValidationResponse.ResponseBody responseBody = new GetPortOutValidationResponse.ResponseBody();

            String consumerId = generalConsumer.getConsumerID().getValue();
            correlationId = generalConsumer.getCorrelationID();
            CountryContentType country = generalConsumer.getCountry().getValue();
            String transactionId = generalConsumer.getTransactionID().getValue();

            logger.info("RequestHeader");
            logger.info("ConsumerId: " + consumerId);
            logger.info("CorrelationId: " + correlationId);
            logger.info("Country: " + country.value());
            logger.info("TransactionId: " + transactionId);

            GetPortOutValidationRequest.RequestBody requestBody = request.getRequestBody();
            logger.info("RequestBody ValidationId: " + requestBody.getIdTransaction());

            //Buscar Validation por ValidationId
            PValidaciones validacion = (PValidaciones) validacionesFacade.find(requestBody.getIdTransaction());
            if (validacion == null) {
                ResponseHeader responseHeader = getResponseHeader("1", "NEG", correlationId, "La consulta no retorno datos", StatusContentType.ERROR);
                response.setResponseHeader(responseHeader);
                return response;
            }

            if (!validacion.getEstadoProcesoId().getValor().equals(PEstadosProceso.FINALIZADO)) {
                ResponseHeader responseHeader = getResponseHeader("0", "NEG", correlationId, "La consulta se encuentra en Estado: " + validacion.getEstadoProcesoId().getValor(), StatusContentType.OK);
                responseBody.setTransactionStatus(validacion.getEstadoProcesoId().getValor());
                response.setResponseHeader(responseHeader);
                response.setResponseBody(responseBody);
                return response;
            }

            //Buscar lista  de cuentas por Validaciones
            logger.info("Consultando lista de cuentas asociadas a la validacion.");
            List<PValidacionesCuentas> vCuentas = validacionesCuentasFacade.findByValidationId(validacion.getValidacionId());
            logger.info("Respuesta a consulta obtenida");

            final MsisdnDataListType msisdnDataList = new MsisdnDataListType();

            final GregorianCalendar calendar = new GregorianCalendar();
            for (PValidacionesCuentas vCuenta : vCuentas) {
                MsisdnDataListType.MsisdnInfo info = new MsisdnDataListType.MsisdnInfo();
                info.setExistence(vCuenta.getExistencia());
                info.setLoan(vCuenta.getComodato());
                info.setMsisdn(vCuenta.getNroCuenta());
                info.setOwnerName(vCuenta.getTitular());
                info.setPendingInvoices(vCuenta.getPendientes());
                info.setEmissionDate(vCuenta.getFechaEmision());
                info.setValidityDate(vCuenta.getFechaVigencia());
                info.setReceiptDesc(vCuenta.getDescComp());

//                String[] estadosList = vCuenta.getEstados().split(",");
//                StatusListType statusList = new StatusListType();
//                for (String estado : estadosList) {
//                    StatusListType.StatusType statusType = new StatusListType.StatusType();
//                    statusType.setStatus(estado);
//                    //statusType.setType(estado.getTipo());
//                    statusList.getStatusType().add(statusType);
//                }
                StatusListType statusList = new StatusListType();
                statusList.getStatus().add(vCuenta.getEstados());
                info.setStatusList(statusList);
                msisdnDataList.getMsisdnInfo().add(info);

                if (vCuenta.getFechaHabilitacion() != null) {

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.setLenient(false);
                    String fechaHabilitacion = sdf.format(vCuenta.getFechaHabilitacion());
                    java.util.Date d = sdf.parse(fechaHabilitacion);

                    // Verificar formato de fecha
                    calendar.setTime(d);
                    XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
//                    date2.setHour(0);
//                    date2.setMinute(0);
//                    date2.setSecond(0);
//                    date2.setMillisecond(0);
//                    date2.setTimezone(1);

//                    info.setEnablementDate(date2);
                    info.setEnablementDate(fechaHabilitacion);

                } else {
                    info.setEnablementDate(null);
                }

            }

            responseBody.setMsisdnList(msisdnDataList);
            responseBody.setTransactionStatus(validacion.getEstadoProcesoId().getValor());

            ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
            response.setResponseHeader(responseHeader);
            response.setResponseBody(responseBody);
            logger.info("Retornando respuesta, ValidacionId: " + validacion.getValidacionId() + " , ResponseCode: " + responseHeader.getGeneralResponse().getCode().getValue()
                    + " , ResponseDescription: " + responseHeader.getGeneralResponse().getDescription().getValue());

        } catch (ParseException ex) {
            logger.error("Se ha producido un error al procesar solicitud.");
            logger.error("Exception", ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        } catch (DatatypeConfigurationException ex) {
            logger.error("Se ha producido un error al procesar solicitud.");
            logger.error("Exception", ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        }
        return response;
    }

    /**
     * Ejecutar transaccion
     *
     * @param request
     * @return
     */
    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.ExecuteTransactionResponse executeTransaction(com.tigo.xmlns.portability.portabilityprocess.v1.schema.ExecuteTransactionRequest request) {
        logger.info("Request Recibido...");
        final ExecuteTransactionResponse response = new ExecuteTransactionResponse();
        String correlationId = "";
        try {
            RequestHeader requestHeader = request.getRequestHeader();
            GeneralConsumerInfoType generalConsumer = requestHeader.getGeneralConsumerInformation();

            String consumerId = generalConsumer.getConsumerID().getValue();
            correlationId = generalConsumer.getCorrelationID();
            CountryContentType country = generalConsumer.getCountry().getValue();
            String transactionId = generalConsumer.getTransactionID().getValue();

            logger.info("RequestHeader.");
            logger.info("ConsumerId: " + consumerId);
            logger.info("CorrelationId: " + correlationId);
            logger.info("Country: " + country.value());
            logger.info("TransactionId: " + transactionId);

            //RequestBody
            ExecuteTransactionRequest.RequestBody requestBody = request.getRequestBody();
            BigInteger processCode = requestBody.getProcessCode();
            List<String> lista = requestBody.getMsisdnList().getMsisdn();

            logger.info("RequestBody.");
            logger.info("CodigoProceso: " + processCode);
            logger.info("Cantidad Cuentas: " + lista.size());

            //Crear registro de transaccion
            logger.info("Se creara registro de transaccion.");
            PTransacciones transaccion = new PTransacciones();
            transaccion.setCodigoProceso(processCode);
            transaccion.setExternalTransactionId(new BigInteger(transactionId));
            transaccion.setFechaHoraAlta(new Date());
            PEstadosProceso estadoCargando = (PEstadosProceso) estadosProcesoFacade.findByName(PEstadosProceso.CARGANDO);
            logger.info("Estado proceso obtenido: " + estadoCargando);
            transaccion.setEstadoProcesoId(estadoCargando);
            transaccion.setTipoInboundId((PTiposInbound) tiposInboundFacade.findByName(PTiposInbound.WEB_SERVICE));
            transaccionesFacade.create(transaccion);
            logger.info("Registro de transaccion creado, id: " + transaccion.getIdTransaccion());

            //Ejecutar Hilo para procesar cuentas
            portabilityProcessBean.processTransactionRequest(lista, transaccion);

            ExecuteTransactionResponse.ResponseBody responseBody = new ExecuteTransactionResponse.ResponseBody();
            responseBody.setIdTransaction(transaccion.getIdTransaccion());

            ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
            response.setResponseHeader(responseHeader);
            response.setResponseBody(responseBody);
            logger.info("Retornando respuesta, ResponseCode: " + responseHeader.getGeneralResponse().getCode().getValue()
                    + " , ResponseDescription: " + responseHeader.getGeneralResponse().getDescription().getValue());

        } catch (Exception ex) {
            logger.error("Se ha producido un error al procesar solicitud.");
            logger.error("Exception", ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        }
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionResponse getTransaction(com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionRequest request) {
        final GetTransactionResponse response = new GetTransactionResponse();
        String correlationId = "";
        try {
            RequestHeader requestHeader = request.getRequestHeader();
            GeneralConsumerInfoType generalConsumer = requestHeader.getGeneralConsumerInformation();

            String consumerId = generalConsumer.getConsumerID().getValue();
            correlationId = generalConsumer.getCorrelationID();
            CountryContentType country = generalConsumer.getCountry().getValue();
            String transactionId = generalConsumer.getTransactionID().getValue();

            logger.info("RequestHeader");
            logger.info("ConsumerId: " + consumerId);
            logger.info("CorrelationId: " + correlationId);
            logger.info("Country: " + country.value());
            logger.info("TransactionId: " + transactionId);

            GetTransactionRequest.RequestBody requestBody = request.getRequestBody();
            logger.info("Buscando Transaccion por IdTransaccion: " + requestBody.getIdTransaction());

            //Buscar Transaccion por IdTransaccion
            PTransacciones transaccion = (PTransacciones) transaccionesFacade.find(requestBody.getIdTransaction());
            if (transaccion == null) {
                ResponseHeader responseHeader = getResponseHeader("1", "NEG", correlationId, "La consulta no retorno datos", StatusContentType.ERROR);
                response.setResponseHeader(responseHeader);
                return response;
            }

            MsisdnInformationType msisdnInfo = new MsisdnInformationType();

            List<PTransaccionesCuentas> tcuentas = transaccionesCuentasFacade.findByTransactionId(transaccion.getIdTransaccion());
            final GregorianCalendar calendar = new GregorianCalendar();

            for (PTransaccionesCuentas tcuenta : tcuentas) {
                com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo info = new com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo();
                info.setMsisdn(tcuenta.getNroCuenta());
                info.setProcessCode(transaccion.getCodigoProceso());
                info.setProcessStatus(tcuenta.getEstadoProcesoId().getValor());

                if (tcuenta.getFechaHoraInit() != null) {
                    calendar.setTime(tcuenta.getFechaHoraInit());
                    info.setExecutionDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                } else {
                    info.setExecutionDateTime(null);
                }
                msisdnInfo.getMsisdnInfo().add(info);
            }

            GetTransactionResponse.ResponseBody responseBody = new GetTransactionResponse.ResponseBody();
            responseBody.setIdTransaction(transaccion.getIdTransaccion());
            responseBody.setMsisdnList(msisdnInfo);
            responseBody.setTransactionStatus_0020(transaccion.getEstadoProcesoId().getValor());

            ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
            response.setResponseHeader(responseHeader);
            response.setResponseBody(responseBody);
            logger.info("Retornando respuesta, TransaccionId: " + transaccion.getIdTransaccion() + " , ResponseCode: " + responseHeader.getGeneralResponse().getCode().getValue()
                    + " , ResponseDescription: " + responseHeader.getGeneralResponse().getDescription().getValue());

        } catch (Exception ex) {
            logger.error("Se ha producido un error al procesar solicitud.");
            logger.error("Exception", ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        }
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionByMsisdnResponse getTransactionByMsisdn(com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetTransactionByMsisdnRequest request) {
        final GetTransactionByMsisdnResponse response = new GetTransactionByMsisdnResponse();
        String correlationId = "";
        try {
            RequestHeader requestHeader = request.getRequestHeader();
            GeneralConsumerInfoType generalConsumer = requestHeader.getGeneralConsumerInformation();

            String consumerId = generalConsumer.getConsumerID().getValue();
            correlationId = generalConsumer.getCorrelationID();
            CountryContentType country = generalConsumer.getCountry().getValue();
            String transactionId = generalConsumer.getTransactionID().getValue();

            logger.info("RequestHeader");
            logger.info("ConsumerId: " + consumerId);
            logger.info("CorrelationId: " + correlationId);
            logger.info("Country: " + country.value());
            logger.info("TransactionId: " + transactionId);

            GetTransactionByMsisdnRequest.RequestBody requestBody = request.getRequestBody();
            logger.info("RequestBody Msisdn: " + requestBody.getMsisdn());
            logger.info("RequestBody ProcessCode: " + requestBody.getProcessCode());

            //Buscar Transaccion por N�mero de Cuenta y Codigo de Proceso
            List<PTransaccionesCuentas> tcuentas = transaccionesCuentasFacade.findByMsisdnAndProcessCode(requestBody.getMsisdn(), requestBody.getProcessCode());
            if (tcuentas.isEmpty()) {
                ResponseHeader responseHeader = getResponseHeader("1", "NEG", correlationId, "La consulta no retorno datos", StatusContentType.ERROR);
                response.setResponseHeader(responseHeader);
                return response;
            }
            com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo info = new MsisdnInfo();

            final GregorianCalendar calendar = new GregorianCalendar();

            for (PTransaccionesCuentas tcuenta : tcuentas) {
                info.setMsisdn(tcuenta.getNroCuenta());
                info.setProcessCode(requestBody.getProcessCode());
                info.setProcessStatus(tcuenta.getEstadoProcesoId().getValor());

                if (tcuenta.getFechaHoraInit() != null) {
                    calendar.setTime(tcuenta.getFechaHoraInit());
                    info.setExecutionDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
                } else {
                    info.setExecutionDateTime(null);
                }
            }

            GetTransactionByMsisdnResponse.ResponseBody responseBody = new GetTransactionByMsisdnResponse.ResponseBody();
            responseBody.setMsisdnInfo(info);

            ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
            response.setResponseHeader(responseHeader);
            response.setResponseBody(responseBody);
            logger.info("Retornando respuesta, ResponseCode: " + responseHeader.getGeneralResponse().getCode().getValue()
                    + " , ResponseDescription: " + responseHeader.getGeneralResponse().getDescription().getValue());

        } catch (Exception ex) {
            logger.error("Se ha producido un error al procesar solicitud.");
            logger.error("Exception", ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        }
        return response;
    }

    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetDevolutionResponse getDevolution(com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetDevolutionRequest parameters) throws SQLException {

        //Configuration cfg = Configuration.getInstance("/py/com/lothar/portabilityprocess/util");
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Date d1, fechaReg;
        boolean validarFecha = true;
        boolean existenDatos = false;
        //System.out.println("getPoolAS: " + cfg.getPoolAS());
        GetDevolutionResponse response = new GetDevolutionResponse();
        DevolutionInfoType devolutionInfoType = new DevolutionInfoType();
        String correlationId = parameters.getRequestHeader().getGeneralConsumerInformation().getCorrelationID();

        try {
            conn = cfg.getPoolAS().getConnection();
            cs = conn.prepareCall("{" + cfg.getExecuteSP() + "}");
            //parametros de entrada
            String startDate = parameters.getRequestBody().getStartDate() == null ? "" : parameters.getRequestBody().getStartDate().toString(); //"2016-04-07";
            String endDate = parameters.getRequestBody().getEndDate() == null ? "" : parameters.getRequestBody().getEndDate().toString(); //"2016-07-05";
            cs.setString(1, startDate);
            cs.setString(2, endDate);
            cs.setString(3, parameters.getRequestBody().getStatus().toUpperCase());

            //Validar campo StartDate (Debe tener el formato de acuerdo al parametro formatoFechaHora)
            if (!startDate.isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat(cfg.getFormatoFechaHora());
                    sdf.setLenient(false);
                    d1 = sdf.parse(startDate);
                    sdf.format(d1);
                } catch (Exception e) {
                    logger.info("[" + startDate + "] Formato invalido del campo start_date");
                    validarFecha = false;

                }
            }

            //Validar campo EndDate (Debe tener el formato de acuerdo al parametro formatoFechaHora)
            if (!endDate.isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat(cfg.getFormatoFechaHora());
                    sdf.setLenient(false);
                    d1 = sdf.parse(endDate);
                    sdf.format(d1);
                } catch (Exception e) {
                    logger.info("[" + endDate + "] Formato invalido del campo end_date");
                    validarFecha = false;

                }
            }

            // Validacion de Fechas
//            if (validarFecha) {
            // Validacion de Estado
            if (parameters.getRequestBody().getStatus().equalsIgnoreCase("A") || parameters.getRequestBody().getStatus().equalsIgnoreCase("H")) {
                boolean retorno4 = cs.execute();
                rs = cs.getResultSet();
                if (rs != null) // if(rs.next())
                {

                    while (rs.next()) {
                        existenDatos = true;
                        logger.info("Se encontraron los siguientes datos con el procedimiento almacenado");
                        logger.info("Nro Cuenta :" + rs.getString(1) + "," + "Tipo_devolucion :" + rs.getString(2) + "," + "Fecha-Registro: " + rs.getString(3) + "," + "Estado:" + rs.getString(4));

                        DevolutionInfo devolutionInfo = new DevolutionInfo();
                        devolutionInfo.setMsisdn(rs.getString(1));
                        devolutionInfo.setDevolutionType(rs.getString(2));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        sdf.setLenient(false);
                        fechaReg = sdf.parse(rs.getString(3));
                        sdf.format(fechaReg);

                        // Convertir Date a XMLGregorianCalendar
                        GregorianCalendar calendar = new GregorianCalendar();
//                        calendar.setTime(rs.getDate(3));
                        calendar.setTime(fechaReg);
//                        devolutionInfo.setRegisteredDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(rs.getDate(3).toString()));
                        devolutionInfo.setRegisteredDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(rs.getString(3)));
                        devolutionInfo.setStatus(rs.getString(4));
                        // Se agrega el resultado a la lista
                        devolutionInfoType.getDevolutionInfo().add(devolutionInfo);

                    }
                    if (existenDatos) {
                        // Response Body
                        GetDevolutionResponse.ResponseBody responseBody = new GetDevolutionResponse.ResponseBody();
                        responseBody.setDevolutionInfo(devolutionInfoType);
                        //Response Header
                        ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
                        response.setResponseHeader(responseHeader);
                        response.setResponseBody(responseBody);
                    } else {
                        logger.info("No se encontraron datos con el procedimiento almacenado");

                        GetDevolutionResponse.ResponseBody responseBody = new GetDevolutionResponse.ResponseBody();

                        responseBody.setDevolutionInfo(devolutionInfoType);

                        ResponseHeader responseHeader = getResponseHeader("1", "INFO", correlationId, "No se encontraron datos", StatusContentType.OK);

                        response.setResponseHeader(responseHeader);
                        response.setResponseBody(responseBody);
                    }

                } else {
                    logger.info("No se encontraron datos con el procedimiento almacenado");

                    GetDevolutionResponse.ResponseBody responseBody = new GetDevolutionResponse.ResponseBody();

                    responseBody.setDevolutionInfo(devolutionInfoType);

                    ResponseHeader responseHeader = getResponseHeader("1", "INFO", correlationId, "No se encontraron datos", StatusContentType.OK);

                    response.setResponseHeader(responseHeader);
                    response.setResponseBody(responseBody);

                }
            } else {
                logger.info("Estado Recibido Invalido");

                GetDevolutionResponse.ResponseBody responseBody = new GetDevolutionResponse.ResponseBody();

                responseBody.setDevolutionInfo(devolutionInfoType);

                ResponseHeader responseHeader = getResponseHeader("2", "NEG", correlationId, "Estado invalido", StatusContentType.ERROR);

                response.setResponseHeader(responseHeader);
                response.setResponseBody(responseBody);

            }
//            } else {
//                logger.info("Formato invalido de fechas");
//
//                GetDevolutionResponse.ResponseBody responseBody = new GetDevolutionResponse.ResponseBody();
//
//                responseBody.setIdTransaction(BigInteger.ZERO);
//                responseBody.setDevolutionInfo(devolutionInfoType);
//
//                ResponseHeader responseHeader = getResponseHeader("3", "NEG", correlationId, "Formato invalido de fechas. Formato valido: " + cfg.getFormatoFechaHora(), StatusContentType.ERROR);
//
//                response.setResponseHeader(responseHeader);
//                response.setResponseBody(responseBody);
//
//            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PortabilityProcess.class.getName()).log(Level.SEVERE, null, ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(PortabilityProcess.class.getName()).log(Level.SEVERE, null, ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        } catch (DatatypeConfigurationException ex) {
            java.util.logging.Logger.getLogger(PortabilityProcess.class.getName()).log(Level.SEVERE, null, ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
            } catch (Exception e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }

            cfg.getPoolAS().freeConnection(conn);
        }
        return response;

    }

    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPendingInvoicesQuantityResponse getPendingInvoicesQuantity(com.tigo.xmlns.portability.portabilityprocess.v1.schema.GetPendingInvoicesQuantityRequest parameters) {
        //TODO implement this method
        GetPendingInvoicesQuantityResponse response = new GetPendingInvoicesQuantityResponse();
        //ResponseHeader responseHeader = new ResponseHeader();

        //com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInformationType informationType = new com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInformationType();
//        com.tigo.xmlns.portability.portabilityprocess.v1.schema.PendingInvoicesType.MsisdnInfo info = new com.tigo.xmlns.portability.portabilityprocess.v1.schema.PendingInvoicesType.MsisdnInfo();
        com.tigo.xmlns.portability.portabilityprocess.v1.schema.PendingInvoicesType pendingInvoicesType = new com.tigo.xmlns.portability.portabilityprocess.v1.schema.PendingInvoicesType();
        GetPendingInvoicesQuantityResponse.ResponseBody responseBody = new GetPendingInvoicesQuantityResponse.ResponseBody();
        String correlationId = parameters.getRequestHeader().getGeneralConsumerInformation().getCorrelationID();
//        info.setMsisdn(null);
//
//        MsisdnInfo mi = new MsisdnInfo();
//        MsisdnInformationType mit = new MsisdnInformationType();
//        //    MsisdnInformat;
//
//        mit.getMsisdnInfo().add(mi);
//        pit.getMsisdnInfo().add();
//
//        mi.s pit
//        .
//         rb.setMsisdnList(null);

        List<String> lista = parameters.getRequestBody().getMsisdnList().getMsisdn();
        //String cuentas = "('";
        StringBuilder stringBuilder = new StringBuilder("('");

        for (int i = 0; i < lista.size(); i++) {

            if (i != lista.size() - 1) {
                stringBuilder.append(lista.get(i)).append("','");
                //cuentas += (lista.get(i) + "','");
            } else {
                stringBuilder.append(lista.get(i)).append("')");
                //cuentas += (lista.get(i) + "')");
            }

        }

        String cuentas = stringBuilder.toString();
        logger.info("Parametro de numero de cuentas: " + cuentas);

        try {

//            String qry = cfg.getSelectFacturasPendientes() + " AND b.MF4hA IN " + cuentas + " GROUP BY b.MF4hA ORDER BY b.MF4hA";
            String qry = cfg.getSelectFacturasPendientes().replace("?", cuentas);
            logger.info("Consulta: " + qry);
//            List<HashMap<String, Object>> ret = CommonsQuery.execQuery(cfg.getSelectFacturasPendientes(), cfg.getASdataSource(), cuentas);
            List<HashMap<String, Object>> ret = CommonsQuery.execQuery(qry, cfg.getASdataSource());
            if (!ret.isEmpty()) {
                for (HashMap<String, Object> hm : ret) {
                    com.tigo.xmlns.portability.portabilityprocess.v1.schema.PendingInvoicesType.MsisdnInfo info = new com.tigo.xmlns.portability.portabilityprocess.v1.schema.PendingInvoicesType.MsisdnInfo();
                    info.setMsisdn(hm.get("CUENTA").toString());
                    info.setPendingInvoices(new BigInteger(hm.get("CANT_FCM").toString()));
                    pendingInvoicesType.getMsisdnInfo().add(info);
                }
                responseBody.setMsisdnList(pendingInvoicesType);
                // ResponseHeader
                ResponseHeader responseHeader = getResponseHeader("0", "INFO", correlationId, "Proceso satisfactorio", StatusContentType.OK);
                response.setResponseHeader(responseHeader);
                response.setResponseBody(responseBody);

            } else {
                ResponseHeader responseHeader = getResponseHeader("1", "INFO", correlationId, "No se encontraron datos", StatusContentType.OK);
                response.setResponseHeader(responseHeader);
                response.setResponseBody(responseBody);
            }

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PortabilityProcess.class.getName()).log(Level.SEVERE, null, ex);
            ResponseHeader responseHeader = getResponseHeader("999", "TEC", correlationId, "Se ha producido un error. " + ex.getMessage(), StatusContentType.ERROR);
            response.setResponseHeader(responseHeader);
        }

        return response;
    }

    /**
     * Obtener ResponseHeader para los servicios.
     *
     * @param code
     * @param codeType
     * @param correlationId
     * @param description
     * @param statusContentType
     * @return
     */
    private ResponseHeader getResponseHeader(String code, String codeType, String correlationId, String description, StatusContentType statusContentType) {
        ObjectFactory objectFactory = new ObjectFactory();
        GeneralResponseType response = new GeneralResponseType();
        response.setCode(objectFactory.createGeneralResponseTypeCode(code));
        response.setCodeType(objectFactory.createGeneralResponseTypeCodeType(codeType));
        response.setCorrelationID(objectFactory.createGeneralResponseTypeCorrelationID(correlationId));
        response.setDescription(objectFactory.createGeneralResponseTypeDescription(description));
        response.setStatus(objectFactory.createGeneralResponseTypeStatus(statusContentType));
        ResponseHeader header = new ResponseHeader();
        header.setGeneralResponse(response);
        return header;
    }
}
