
package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tigo.xmlns.parametertype.v2.ParameterType;
import com.tigo.xmlns.requestheader.v3.RequestHeader;


/**
 * <p>Clase Java para GetTransactionRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetTransactionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.tigo.com/RequestHeader/V3}RequestHeader"/>
 *         &lt;element name="requestBody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="idTransaction" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="additionalParameters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://xmlns.tigo.com/ParameterType/V2}ParameterType" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransactionRequest", propOrder = {
    "requestHeader",
    "requestBody"
})
public class GetTransactionRequest {

    @XmlElement(name = "RequestHeader", namespace = "http://xmlns.tigo.com/RequestHeader/V3", required = true)
    protected RequestHeader requestHeader;
    @XmlElement(required = true)
    protected GetTransactionRequest.RequestBody requestBody;

    /**
     * Obtiene el valor de la propiedad requestHeader.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    /**
     * Define el valor de la propiedad requestHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setRequestHeader(RequestHeader value) {
        this.requestHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad requestBody.
     * 
     * @return
     *     possible object is
     *     {@link GetTransactionRequest.RequestBody }
     *     
     */
    public GetTransactionRequest.RequestBody getRequestBody() {
        return requestBody;
    }

    /**
     * Define el valor de la propiedad requestBody.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTransactionRequest.RequestBody }
     *     
     */
    public void setRequestBody(GetTransactionRequest.RequestBody value) {
        this.requestBody = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="idTransaction" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="additionalParameters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://xmlns.tigo.com/ParameterType/V2}ParameterType" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idTransaction",
        "additionalParameters"
    })
    public static class RequestBody {

        @XmlElement(required = true)
        protected BigInteger idTransaction;
        protected GetTransactionRequest.RequestBody.AdditionalParameters additionalParameters;

        /**
         * Obtiene el valor de la propiedad idTransaction.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getIdTransaction() {
            return idTransaction;
        }

        /**
         * Define el valor de la propiedad idTransaction.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setIdTransaction(BigInteger value) {
            this.idTransaction = value;
        }

        /**
         * Obtiene el valor de la propiedad additionalParameters.
         * 
         * @return
         *     possible object is
         *     {@link GetTransactionRequest.RequestBody.AdditionalParameters }
         *     
         */
        public GetTransactionRequest.RequestBody.AdditionalParameters getAdditionalParameters() {
            return additionalParameters;
        }

        /**
         * Define el valor de la propiedad additionalParameters.
         * 
         * @param value
         *     allowed object is
         *     {@link GetTransactionRequest.RequestBody.AdditionalParameters }
         *     
         */
        public void setAdditionalParameters(GetTransactionRequest.RequestBody.AdditionalParameters value) {
            this.additionalParameters = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{http://xmlns.tigo.com/ParameterType/V2}ParameterType" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "parameterType"
        })
        public static class AdditionalParameters {

            @XmlElement(name = "ParameterType", namespace = "http://xmlns.tigo.com/ParameterType/V2", required = true)
            protected List<ParameterType> parameterType;

            /**
             * Gets the value of the parameterType property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the parameterType property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getParameterType().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ParameterType }
             * 
             * 
             */
            public List<ParameterType> getParameterType() {
                if (parameterType == null) {
                    parameterType = new ArrayList<ParameterType>();
                }
                return this.parameterType;
            }

        }

    }

}
