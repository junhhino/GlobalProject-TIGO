
package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tigo.xmlns.parametertype.v2.ParameterType;
import com.tigo.xmlns.responseheader.v3.ResponseHeader;


/**
 * <p>Clase Java para GetPortOutValidationResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetPortOutValidationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.tigo.com/ResponseHeader/V3}ResponseHeader"/>
 *         &lt;element name="responseBody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="msisdnList" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}MsisdnDataListType" minOccurs="0"/>
 *                   &lt;element name="transactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="additionalResults" minOccurs="0">
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
@XmlType(name = "GetPortOutValidationResponse", propOrder = {
    "responseHeader",
    "responseBody"
})
public class GetPortOutValidationResponse {

    @XmlElement(name = "ResponseHeader", namespace = "http://xmlns.tigo.com/ResponseHeader/V3", required = true)
    protected ResponseHeader responseHeader;
    @XmlElement(required = true)
    protected GetPortOutValidationResponse.ResponseBody responseBody;

    /**
     * Obtiene el valor de la propiedad responseHeader.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Define el valor de la propiedad responseHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad responseBody.
     * 
     * @return
     *     possible object is
     *     {@link GetPortOutValidationResponse.ResponseBody }
     *     
     */
    public GetPortOutValidationResponse.ResponseBody getResponseBody() {
        return responseBody;
    }

    /**
     * Define el valor de la propiedad responseBody.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPortOutValidationResponse.ResponseBody }
     *     
     */
    public void setResponseBody(GetPortOutValidationResponse.ResponseBody value) {
        this.responseBody = value;
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
     *         &lt;element name="msisdnList" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}MsisdnDataListType" minOccurs="0"/>
     *         &lt;element name="transactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="additionalResults" minOccurs="0">
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
        "msisdnList",
        "transactionStatus",
        "additionalResults"
    })
    public static class ResponseBody {

        protected MsisdnDataListType msisdnList;
        protected String transactionStatus;
        protected GetPortOutValidationResponse.ResponseBody.AdditionalResults additionalResults;

        /**
         * Obtiene el valor de la propiedad msisdnList.
         * 
         * @return
         *     possible object is
         *     {@link MsisdnDataListType }
         *     
         */
        public MsisdnDataListType getMsisdnList() {
            return msisdnList;
        }

        /**
         * Define el valor de la propiedad msisdnList.
         * 
         * @param value
         *     allowed object is
         *     {@link MsisdnDataListType }
         *     
         */
        public void setMsisdnList(MsisdnDataListType value) {
            this.msisdnList = value;
        }

        /**
         * Obtiene el valor de la propiedad transactionStatus.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransactionStatus() {
            return transactionStatus;
        }

        /**
         * Define el valor de la propiedad transactionStatus.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransactionStatus(String value) {
            this.transactionStatus = value;
        }

        /**
         * Obtiene el valor de la propiedad additionalResults.
         * 
         * @return
         *     possible object is
         *     {@link GetPortOutValidationResponse.ResponseBody.AdditionalResults }
         *     
         */
        public GetPortOutValidationResponse.ResponseBody.AdditionalResults getAdditionalResults() {
            return additionalResults;
        }

        /**
         * Define el valor de la propiedad additionalResults.
         * 
         * @param value
         *     allowed object is
         *     {@link GetPortOutValidationResponse.ResponseBody.AdditionalResults }
         *     
         */
        public void setAdditionalResults(GetPortOutValidationResponse.ResponseBody.AdditionalResults value) {
            this.additionalResults = value;
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
        public static class AdditionalResults {

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
