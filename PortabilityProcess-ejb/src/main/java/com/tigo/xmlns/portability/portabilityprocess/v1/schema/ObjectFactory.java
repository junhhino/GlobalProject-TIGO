
package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tigo.xmlns.portability.portabilityprocess.v1.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PortOutValidationRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "portOutValidationRequest");
    private final static QName _ExecuteTransactionResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "executeTransactionResponse");
    private final static QName _GetTransactionResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getTransactionResponse");
    private final static QName _GetDevolutionRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getDevolutionRequest");
    private final static QName _GetPortOutValidationRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getPortOutValidationRequest");
    private final static QName _GetPendingInvoicesQuantityRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getPendingInvoicesQuantityRequest");
    private final static QName _GetTransactionByMsisdnRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getTransactionByMsisdnRequest");
    private final static QName _PortOutValidationResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "portOutValidationResponse");
    private final static QName _GetPortOutValidationResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getPortOutValidationResponse");
    private final static QName _GetTransactionByMsisdnResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getTransactionByMsisdnResponse");
    private final static QName _GetDevolutionResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getDevolutionResponse");
    private final static QName _GetTransactionRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getTransactionRequest");
    private final static QName _ExecuteTransactionRequest_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "executeTransactionRequest");
    private final static QName _GetPendingInvoicesQuantityResponse_QNAME = new QName("http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", "getPendingInvoicesQuantityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tigo.xmlns.portability.portabilityprocess.v1.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MsisdnDataListType }
     * 
     */
    public MsisdnDataListType createMsisdnDataListType() {
        return new MsisdnDataListType();
    }

    /**
     * Create an instance of {@link PendingInvoicesType }
     * 
     */
    public PendingInvoicesType createPendingInvoicesType() {
        return new PendingInvoicesType();
    }

    /**
     * Create an instance of {@link GetDevolutionRequest }
     * 
     */
    public GetDevolutionRequest createGetDevolutionRequest() {
        return new GetDevolutionRequest();
    }

    /**
     * Create an instance of {@link GetDevolutionRequest.RequestBody }
     * 
     */
    public GetDevolutionRequest.RequestBody createGetDevolutionRequestRequestBody() {
        return new GetDevolutionRequest.RequestBody();
    }

    /**
     * Create an instance of {@link GetPortOutValidationRequest }
     * 
     */
    public GetPortOutValidationRequest createGetPortOutValidationRequest() {
        return new GetPortOutValidationRequest();
    }

    /**
     * Create an instance of {@link GetPortOutValidationRequest.RequestBody }
     * 
     */
    public GetPortOutValidationRequest.RequestBody createGetPortOutValidationRequestRequestBody() {
        return new GetPortOutValidationRequest.RequestBody();
    }

    /**
     * Create an instance of {@link GetPendingInvoicesQuantityRequest }
     * 
     */
    public GetPendingInvoicesQuantityRequest createGetPendingInvoicesQuantityRequest() {
        return new GetPendingInvoicesQuantityRequest();
    }

    /**
     * Create an instance of {@link GetPendingInvoicesQuantityRequest.RequestBody }
     * 
     */
    public GetPendingInvoicesQuantityRequest.RequestBody createGetPendingInvoicesQuantityRequestRequestBody() {
        return new GetPendingInvoicesQuantityRequest.RequestBody();
    }

    /**
     * Create an instance of {@link ExecuteTransactionResponse }
     * 
     */
    public ExecuteTransactionResponse createExecuteTransactionResponse() {
        return new ExecuteTransactionResponse();
    }

    /**
     * Create an instance of {@link ExecuteTransactionResponse.ResponseBody }
     * 
     */
    public ExecuteTransactionResponse.ResponseBody createExecuteTransactionResponseResponseBody() {
        return new ExecuteTransactionResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link PortOutValidationRequest }
     * 
     */
    public PortOutValidationRequest createPortOutValidationRequest() {
        return new PortOutValidationRequest();
    }

    /**
     * Create an instance of {@link PortOutValidationRequest.RequestBody }
     * 
     */
    public PortOutValidationRequest.RequestBody createPortOutValidationRequestRequestBody() {
        return new PortOutValidationRequest.RequestBody();
    }

    /**
     * Create an instance of {@link GetTransactionResponse }
     * 
     */
    public GetTransactionResponse createGetTransactionResponse() {
        return new GetTransactionResponse();
    }

    /**
     * Create an instance of {@link GetTransactionResponse.ResponseBody }
     * 
     */
    public GetTransactionResponse.ResponseBody createGetTransactionResponseResponseBody() {
        return new GetTransactionResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link GetDevolutionResponse }
     * 
     */
    public GetDevolutionResponse createGetDevolutionResponse() {
        return new GetDevolutionResponse();
    }

    /**
     * Create an instance of {@link GetDevolutionResponse.ResponseBody }
     * 
     */
    public GetDevolutionResponse.ResponseBody createGetDevolutionResponseResponseBody() {
        return new GetDevolutionResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link GetTransactionRequest }
     * 
     */
    public GetTransactionRequest createGetTransactionRequest() {
        return new GetTransactionRequest();
    }

    /**
     * Create an instance of {@link GetTransactionRequest.RequestBody }
     * 
     */
    public GetTransactionRequest.RequestBody createGetTransactionRequestRequestBody() {
        return new GetTransactionRequest.RequestBody();
    }

    /**
     * Create an instance of {@link ExecuteTransactionRequest }
     * 
     */
    public ExecuteTransactionRequest createExecuteTransactionRequest() {
        return new ExecuteTransactionRequest();
    }

    /**
     * Create an instance of {@link ExecuteTransactionRequest.RequestBody }
     * 
     */
    public ExecuteTransactionRequest.RequestBody createExecuteTransactionRequestRequestBody() {
        return new ExecuteTransactionRequest.RequestBody();
    }

    /**
     * Create an instance of {@link GetPendingInvoicesQuantityResponse }
     * 
     */
    public GetPendingInvoicesQuantityResponse createGetPendingInvoicesQuantityResponse() {
        return new GetPendingInvoicesQuantityResponse();
    }

    /**
     * Create an instance of {@link GetPendingInvoicesQuantityResponse.ResponseBody }
     * 
     */
    public GetPendingInvoicesQuantityResponse.ResponseBody createGetPendingInvoicesQuantityResponseResponseBody() {
        return new GetPendingInvoicesQuantityResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link GetTransactionByMsisdnRequest }
     * 
     */
    public GetTransactionByMsisdnRequest createGetTransactionByMsisdnRequest() {
        return new GetTransactionByMsisdnRequest();
    }

    /**
     * Create an instance of {@link GetTransactionByMsisdnRequest.RequestBody }
     * 
     */
    public GetTransactionByMsisdnRequest.RequestBody createGetTransactionByMsisdnRequestRequestBody() {
        return new GetTransactionByMsisdnRequest.RequestBody();
    }

    /**
     * Create an instance of {@link PortOutValidationResponse }
     * 
     */
    public PortOutValidationResponse createPortOutValidationResponse() {
        return new PortOutValidationResponse();
    }

    /**
     * Create an instance of {@link PortOutValidationResponse.ResponseBody }
     * 
     */
    public PortOutValidationResponse.ResponseBody createPortOutValidationResponseResponseBody() {
        return new PortOutValidationResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link GetPortOutValidationResponse }
     * 
     */
    public GetPortOutValidationResponse createGetPortOutValidationResponse() {
        return new GetPortOutValidationResponse();
    }

    /**
     * Create an instance of {@link GetPortOutValidationResponse.ResponseBody }
     * 
     */
    public GetPortOutValidationResponse.ResponseBody createGetPortOutValidationResponseResponseBody() {
        return new GetPortOutValidationResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link GetTransactionByMsisdnResponse }
     * 
     */
    public GetTransactionByMsisdnResponse createGetTransactionByMsisdnResponse() {
        return new GetTransactionByMsisdnResponse();
    }

    /**
     * Create an instance of {@link GetTransactionByMsisdnResponse.ResponseBody }
     * 
     */
    public GetTransactionByMsisdnResponse.ResponseBody createGetTransactionByMsisdnResponseResponseBody() {
        return new GetTransactionByMsisdnResponse.ResponseBody();
    }

    /**
     * Create an instance of {@link DevolutionInfoType }
     * 
     */
    public DevolutionInfoType createDevolutionInfoType() {
        return new DevolutionInfoType();
    }

    /**
     * Create an instance of {@link MsisdnListType }
     * 
     */
    public MsisdnListType createMsisdnListType() {
        return new MsisdnListType();
    }

    /**
     * Create an instance of {@link com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo }
     * 
     */
    public com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo createMsisdnInfo() {
        return new com.tigo.xmlns.portability.portabilityprocess.v1.schema.MsisdnInfo();
    }

    /**
     * Create an instance of {@link MsisdnInformationType }
     * 
     */
    public MsisdnInformationType createMsisdnInformationType() {
        return new MsisdnInformationType();
    }

    /**
     * Create an instance of {@link DevolutionInfo }
     * 
     */
    public DevolutionInfo createDevolutionInfo() {
        return new DevolutionInfo();
    }

    /**
     * Create an instance of {@link StatusListType }
     * 
     */
    public StatusListType createStatusListType() {
        return new StatusListType();
    }

    /**
     * Create an instance of {@link DocumentInfoType }
     * 
     */
    public DocumentInfoType createDocumentInfoType() {
        return new DocumentInfoType();
    }

    /**
     * Create an instance of {@link MsisdnDataListType.MsisdnInfo }
     * 
     */
    public MsisdnDataListType.MsisdnInfo createMsisdnDataListTypeMsisdnInfo() {
        return new MsisdnDataListType.MsisdnInfo();
    }

    /**
     * Create an instance of {@link PendingInvoicesType.MsisdnInfo }
     * 
     */
    public PendingInvoicesType.MsisdnInfo createPendingInvoicesTypeMsisdnInfo() {
        return new PendingInvoicesType.MsisdnInfo();
    }

    /**
     * Create an instance of {@link GetDevolutionRequest.RequestBody.AdditionalParameters }
     * 
     */
    public GetDevolutionRequest.RequestBody.AdditionalParameters createGetDevolutionRequestRequestBodyAdditionalParameters() {
        return new GetDevolutionRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link GetPortOutValidationRequest.RequestBody.AdditionalParameters }
     * 
     */
    public GetPortOutValidationRequest.RequestBody.AdditionalParameters createGetPortOutValidationRequestRequestBodyAdditionalParameters() {
        return new GetPortOutValidationRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link GetPendingInvoicesQuantityRequest.RequestBody.AdditionalParameters }
     * 
     */
    public GetPendingInvoicesQuantityRequest.RequestBody.AdditionalParameters createGetPendingInvoicesQuantityRequestRequestBodyAdditionalParameters() {
        return new GetPendingInvoicesQuantityRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link ExecuteTransactionResponse.ResponseBody.AdditionalResults }
     * 
     */
    public ExecuteTransactionResponse.ResponseBody.AdditionalResults createExecuteTransactionResponseResponseBodyAdditionalResults() {
        return new ExecuteTransactionResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link PortOutValidationRequest.RequestBody.NaturalPerson }
     * 
     */
    public PortOutValidationRequest.RequestBody.NaturalPerson createPortOutValidationRequestRequestBodyNaturalPerson() {
        return new PortOutValidationRequest.RequestBody.NaturalPerson();
    }

    /**
     * Create an instance of {@link PortOutValidationRequest.RequestBody.AdditionalParameters }
     * 
     */
    public PortOutValidationRequest.RequestBody.AdditionalParameters createPortOutValidationRequestRequestBodyAdditionalParameters() {
        return new PortOutValidationRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link GetTransactionResponse.ResponseBody.AdditionalResults }
     * 
     */
    public GetTransactionResponse.ResponseBody.AdditionalResults createGetTransactionResponseResponseBodyAdditionalResults() {
        return new GetTransactionResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link GetDevolutionResponse.ResponseBody.AdditionalResults }
     * 
     */
    public GetDevolutionResponse.ResponseBody.AdditionalResults createGetDevolutionResponseResponseBodyAdditionalResults() {
        return new GetDevolutionResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link GetTransactionRequest.RequestBody.AdditionalParameters }
     * 
     */
    public GetTransactionRequest.RequestBody.AdditionalParameters createGetTransactionRequestRequestBodyAdditionalParameters() {
        return new GetTransactionRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link ExecuteTransactionRequest.RequestBody.AdditionalParameters }
     * 
     */
    public ExecuteTransactionRequest.RequestBody.AdditionalParameters createExecuteTransactionRequestRequestBodyAdditionalParameters() {
        return new ExecuteTransactionRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link GetPendingInvoicesQuantityResponse.ResponseBody.AdditionalResults }
     * 
     */
    public GetPendingInvoicesQuantityResponse.ResponseBody.AdditionalResults createGetPendingInvoicesQuantityResponseResponseBodyAdditionalResults() {
        return new GetPendingInvoicesQuantityResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link GetTransactionByMsisdnRequest.RequestBody.AdditionalParameters }
     * 
     */
    public GetTransactionByMsisdnRequest.RequestBody.AdditionalParameters createGetTransactionByMsisdnRequestRequestBodyAdditionalParameters() {
        return new GetTransactionByMsisdnRequest.RequestBody.AdditionalParameters();
    }

    /**
     * Create an instance of {@link PortOutValidationResponse.ResponseBody.AdditionalResults }
     * 
     */
    public PortOutValidationResponse.ResponseBody.AdditionalResults createPortOutValidationResponseResponseBodyAdditionalResults() {
        return new PortOutValidationResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link GetPortOutValidationResponse.ResponseBody.AdditionalResults }
     * 
     */
    public GetPortOutValidationResponse.ResponseBody.AdditionalResults createGetPortOutValidationResponseResponseBodyAdditionalResults() {
        return new GetPortOutValidationResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link GetTransactionByMsisdnResponse.ResponseBody.AdditionalResults }
     * 
     */
    public GetTransactionByMsisdnResponse.ResponseBody.AdditionalResults createGetTransactionByMsisdnResponseResponseBodyAdditionalResults() {
        return new GetTransactionByMsisdnResponse.ResponseBody.AdditionalResults();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortOutValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "portOutValidationRequest")
    public JAXBElement<PortOutValidationRequest> createPortOutValidationRequest(PortOutValidationRequest value) {
        return new JAXBElement<PortOutValidationRequest>(_PortOutValidationRequest_QNAME, PortOutValidationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "executeTransactionResponse")
    public JAXBElement<ExecuteTransactionResponse> createExecuteTransactionResponse(ExecuteTransactionResponse value) {
        return new JAXBElement<ExecuteTransactionResponse>(_ExecuteTransactionResponse_QNAME, ExecuteTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getTransactionResponse")
    public JAXBElement<GetTransactionResponse> createGetTransactionResponse(GetTransactionResponse value) {
        return new JAXBElement<GetTransactionResponse>(_GetTransactionResponse_QNAME, GetTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDevolutionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getDevolutionRequest")
    public JAXBElement<GetDevolutionRequest> createGetDevolutionRequest(GetDevolutionRequest value) {
        return new JAXBElement<GetDevolutionRequest>(_GetDevolutionRequest_QNAME, GetDevolutionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPortOutValidationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getPortOutValidationRequest")
    public JAXBElement<GetPortOutValidationRequest> createGetPortOutValidationRequest(GetPortOutValidationRequest value) {
        return new JAXBElement<GetPortOutValidationRequest>(_GetPortOutValidationRequest_QNAME, GetPortOutValidationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPendingInvoicesQuantityRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getPendingInvoicesQuantityRequest")
    public JAXBElement<GetPendingInvoicesQuantityRequest> createGetPendingInvoicesQuantityRequest(GetPendingInvoicesQuantityRequest value) {
        return new JAXBElement<GetPendingInvoicesQuantityRequest>(_GetPendingInvoicesQuantityRequest_QNAME, GetPendingInvoicesQuantityRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionByMsisdnRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getTransactionByMsisdnRequest")
    public JAXBElement<GetTransactionByMsisdnRequest> createGetTransactionByMsisdnRequest(GetTransactionByMsisdnRequest value) {
        return new JAXBElement<GetTransactionByMsisdnRequest>(_GetTransactionByMsisdnRequest_QNAME, GetTransactionByMsisdnRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortOutValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "portOutValidationResponse")
    public JAXBElement<PortOutValidationResponse> createPortOutValidationResponse(PortOutValidationResponse value) {
        return new JAXBElement<PortOutValidationResponse>(_PortOutValidationResponse_QNAME, PortOutValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPortOutValidationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getPortOutValidationResponse")
    public JAXBElement<GetPortOutValidationResponse> createGetPortOutValidationResponse(GetPortOutValidationResponse value) {
        return new JAXBElement<GetPortOutValidationResponse>(_GetPortOutValidationResponse_QNAME, GetPortOutValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionByMsisdnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getTransactionByMsisdnResponse")
    public JAXBElement<GetTransactionByMsisdnResponse> createGetTransactionByMsisdnResponse(GetTransactionByMsisdnResponse value) {
        return new JAXBElement<GetTransactionByMsisdnResponse>(_GetTransactionByMsisdnResponse_QNAME, GetTransactionByMsisdnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDevolutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getDevolutionResponse")
    public JAXBElement<GetDevolutionResponse> createGetDevolutionResponse(GetDevolutionResponse value) {
        return new JAXBElement<GetDevolutionResponse>(_GetDevolutionResponse_QNAME, GetDevolutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getTransactionRequest")
    public JAXBElement<GetTransactionRequest> createGetTransactionRequest(GetTransactionRequest value) {
        return new JAXBElement<GetTransactionRequest>(_GetTransactionRequest_QNAME, GetTransactionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteTransactionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "executeTransactionRequest")
    public JAXBElement<ExecuteTransactionRequest> createExecuteTransactionRequest(ExecuteTransactionRequest value) {
        return new JAXBElement<ExecuteTransactionRequest>(_ExecuteTransactionRequest_QNAME, ExecuteTransactionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPendingInvoicesQuantityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema", name = "getPendingInvoicesQuantityResponse")
    public JAXBElement<GetPendingInvoicesQuantityResponse> createGetPendingInvoicesQuantityResponse(GetPendingInvoicesQuantityResponse value) {
        return new JAXBElement<GetPendingInvoicesQuantityResponse>(_GetPendingInvoicesQuantityResponse_QNAME, GetPendingInvoicesQuantityResponse.class, null, value);
    }

}
