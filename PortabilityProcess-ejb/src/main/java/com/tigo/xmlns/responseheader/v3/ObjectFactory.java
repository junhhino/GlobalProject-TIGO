
package com.tigo.xmlns.responseheader.v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tigo.xmlns.responseheader.v3 package. 
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

    private final static QName _GeneralResponseTypeDescription_QNAME = new QName("http://xmlns.tigo.com/ResponseHeader/V3", "description");
    private final static QName _GeneralResponseTypeStatus_QNAME = new QName("http://xmlns.tigo.com/ResponseHeader/V3", "status");
    private final static QName _GeneralResponseTypeCorrelationID_QNAME = new QName("http://xmlns.tigo.com/ResponseHeader/V3", "correlationID");
    private final static QName _GeneralResponseTypeCodeType_QNAME = new QName("http://xmlns.tigo.com/ResponseHeader/V3", "codeType");
    private final static QName _GeneralResponseTypeCode_QNAME = new QName("http://xmlns.tigo.com/ResponseHeader/V3", "code");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tigo.xmlns.responseheader.v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResponseHeader }
     * 
     */
    public ResponseHeader createResponseHeader() {
        return new ResponseHeader();
    }

    /**
     * Create an instance of {@link GeneralResponseType }
     * 
     */
    public GeneralResponseType createGeneralResponseType() {
        return new GeneralResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/ResponseHeader/V3", name = "description", scope = GeneralResponseType.class)
    public JAXBElement<String> createGeneralResponseTypeDescription(String value) {
        return new JAXBElement<String>(_GeneralResponseTypeDescription_QNAME, String.class, GeneralResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/ResponseHeader/V3", name = "status", scope = GeneralResponseType.class)
    public JAXBElement<StatusContentType> createGeneralResponseTypeStatus(StatusContentType value) {
        return new JAXBElement<StatusContentType>(_GeneralResponseTypeStatus_QNAME, StatusContentType.class, GeneralResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/ResponseHeader/V3", name = "correlationID", scope = GeneralResponseType.class)
    public JAXBElement<String> createGeneralResponseTypeCorrelationID(String value) {
        return new JAXBElement<String>(_GeneralResponseTypeCorrelationID_QNAME, String.class, GeneralResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/ResponseHeader/V3", name = "codeType", scope = GeneralResponseType.class)
    public JAXBElement<String> createGeneralResponseTypeCodeType(String value) {
        return new JAXBElement<String>(_GeneralResponseTypeCodeType_QNAME, String.class, GeneralResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/ResponseHeader/V3", name = "code", scope = GeneralResponseType.class)
    public JAXBElement<String> createGeneralResponseTypeCode(String value) {
        return new JAXBElement<String>(_GeneralResponseTypeCode_QNAME, String.class, GeneralResponseType.class, value);
    }

}
