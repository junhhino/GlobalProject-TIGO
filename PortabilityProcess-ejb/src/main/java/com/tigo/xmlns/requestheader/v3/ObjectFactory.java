
package com.tigo.xmlns.requestheader.v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tigo.xmlns.requestheader.v3 package. 
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

    private final static QName _GeneralConsumerInfoTypeConsumerID_QNAME = new QName("http://xmlns.tigo.com/RequestHeader/V3", "consumerID");
    private final static QName _GeneralConsumerInfoTypeTransactionID_QNAME = new QName("http://xmlns.tigo.com/RequestHeader/V3", "transactionID");
    private final static QName _GeneralConsumerInfoTypeCountry_QNAME = new QName("http://xmlns.tigo.com/RequestHeader/V3", "country");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tigo.xmlns.requestheader.v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link GeneralConsumerInfoType }
     * 
     */
    public GeneralConsumerInfoType createGeneralConsumerInfoType() {
        return new GeneralConsumerInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/RequestHeader/V3", name = "consumerID", scope = GeneralConsumerInfoType.class)
    public JAXBElement<String> createGeneralConsumerInfoTypeConsumerID(String value) {
        return new JAXBElement<String>(_GeneralConsumerInfoTypeConsumerID_QNAME, String.class, GeneralConsumerInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/RequestHeader/V3", name = "transactionID", scope = GeneralConsumerInfoType.class)
    public JAXBElement<String> createGeneralConsumerInfoTypeTransactionID(String value) {
        return new JAXBElement<String>(_GeneralConsumerInfoTypeTransactionID_QNAME, String.class, GeneralConsumerInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.tigo.com/RequestHeader/V3", name = "country", scope = GeneralConsumerInfoType.class)
    public JAXBElement<CountryContentType> createGeneralConsumerInfoTypeCountry(CountryContentType value) {
        return new JAXBElement<CountryContentType>(_GeneralConsumerInfoTypeCountry_QNAME, CountryContentType.class, GeneralConsumerInfoType.class, value);
    }

}
