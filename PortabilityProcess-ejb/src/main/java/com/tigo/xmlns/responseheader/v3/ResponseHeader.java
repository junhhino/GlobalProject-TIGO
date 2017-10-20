
package com.tigo.xmlns.responseheader.v3;

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
 *         &lt;element name="GeneralResponse" type="{http://xmlns.tigo.com/ResponseHeader/V3}GeneralResponseType"/>
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
@XmlRootElement(name = "ResponseHeader")
public class ResponseHeader {

    @XmlElement(name = "GeneralResponse", required = true)
    protected GeneralResponseType generalResponse;

    /**
     * Obtiene el valor de la propiedad generalResponse.
     * 
     * @return
     *     possible object is
     *     {@link GeneralResponseType }
     *     
     */
    public GeneralResponseType getGeneralResponse() {
        return generalResponse;
    }

    /**
     * Define el valor de la propiedad generalResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralResponseType }
     *     
     */
    public void setGeneralResponse(GeneralResponseType value) {
        this.generalResponse = value;
    }

}
