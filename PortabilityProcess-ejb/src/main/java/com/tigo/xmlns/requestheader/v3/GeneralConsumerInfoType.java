
package com.tigo.xmlns.requestheader.v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GeneralConsumerInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GeneralConsumerInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consumerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://xmlns.tigo.com/RequestHeader/V3}CountryContentType" minOccurs="0"/>
 *         &lt;element name="correlationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralConsumerInfoType", propOrder = {
    "consumerID",
    "transactionID",
    "country",
    "correlationID"
})
public class GeneralConsumerInfoType {

    @XmlElementRef(name = "consumerID", namespace = "http://xmlns.tigo.com/RequestHeader/V3", type = JAXBElement.class)
    protected JAXBElement<String> consumerID;
    @XmlElementRef(name = "transactionID", namespace = "http://xmlns.tigo.com/RequestHeader/V3", type = JAXBElement.class)
    protected JAXBElement<String> transactionID;
    @XmlElementRef(name = "country", namespace = "http://xmlns.tigo.com/RequestHeader/V3", type = JAXBElement.class)
    protected JAXBElement<CountryContentType> country;
    @XmlElement(required = true)
    protected String correlationID;

    /**
     * Obtiene el valor de la propiedad consumerID.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsumerID() {
        return consumerID;
    }

    /**
     * Define el valor de la propiedad consumerID.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsumerID(JAXBElement<String> value) {
        this.consumerID = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionID.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionID() {
        return transactionID;
    }

    /**
     * Define el valor de la propiedad transactionID.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionID(JAXBElement<String> value) {
        this.transactionID = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CountryContentType }{@code >}
     *     
     */
    public JAXBElement<CountryContentType> getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CountryContentType }{@code >}
     *     
     */
    public void setCountry(JAXBElement<CountryContentType> value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad correlationID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationID() {
        return correlationID;
    }

    /**
     * Define el valor de la propiedad correlationID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationID(String value) {
        this.correlationID = value;
    }

}
