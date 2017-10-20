
package com.tigo.xmlns.requestheader.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="GeneralConsumerInformation" type="{http://xmlns.tigo.com/RequestHeader/V3}GeneralConsumerInfoType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "RequestHeader")
public class RequestHeader {

    @XmlElement(name = "GeneralConsumerInformation", required = true)
    protected GeneralConsumerInfoType generalConsumerInformation;

    /**
     * Obtiene el valor de la propiedad generalConsumerInformation.
     * 
     * @return
     *     possible object is
     *     {@link GeneralConsumerInfoType }
     *     
     */
    public GeneralConsumerInfoType getGeneralConsumerInformation() {
        return generalConsumerInformation;
    }

    /**
     * Define el valor de la propiedad generalConsumerInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralConsumerInfoType }
     *     
     */
    public void setGeneralConsumerInformation(GeneralConsumerInfoType value) {
        this.generalConsumerInformation = value;
    }

}
