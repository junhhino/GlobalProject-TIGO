
package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tigo.xmlns.parametertype.v2.ParameterType;
import com.tigo.xmlns.requestheader.v3.RequestHeader;


/**
 * <p>Clase Java para PortOutValidationRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PortOutValidationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.tigo.com/RequestHeader/V3}RequestHeader"/>
 *         &lt;element name="requestBody">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="legalEntity" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}DocumentInfoType" minOccurs="0"/>
 *                   &lt;element name="naturalPerson" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}DocumentInfoType">
 *                           &lt;sequence>
 *                             &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="msisdnList" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}MsisdnListType"/>
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
@XmlType(name = "PortOutValidationRequest", propOrder = {
    "requestHeader",
    "requestBody"
})
public class PortOutValidationRequest {

    @XmlElement(name = "RequestHeader", namespace = "http://xmlns.tigo.com/RequestHeader/V3", required = true)
    protected RequestHeader requestHeader;
    @XmlElement(required = true)
    protected PortOutValidationRequest.RequestBody requestBody;

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
     *     {@link PortOutValidationRequest.RequestBody }
     *     
     */
    public PortOutValidationRequest.RequestBody getRequestBody() {
        return requestBody;
    }

    /**
     * Define el valor de la propiedad requestBody.
     * 
     * @param value
     *     allowed object is
     *     {@link PortOutValidationRequest.RequestBody }
     *     
     */
    public void setRequestBody(PortOutValidationRequest.RequestBody value) {
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
     *         &lt;element name="legalEntity" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}DocumentInfoType" minOccurs="0"/>
     *         &lt;element name="naturalPerson" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}DocumentInfoType">
     *                 &lt;sequence>
     *                   &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="msisdnList" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}MsisdnListType"/>
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
        "legalEntity",
        "naturalPerson",
        "msisdnList",
        "additionalParameters"
    })
    public static class RequestBody {

        protected DocumentInfoType legalEntity;
        protected PortOutValidationRequest.RequestBody.NaturalPerson naturalPerson;
        @XmlElement(required = true)
        protected MsisdnListType msisdnList;
        protected PortOutValidationRequest.RequestBody.AdditionalParameters additionalParameters;

        /**
         * Obtiene el valor de la propiedad legalEntity.
         * 
         * @return
         *     possible object is
         *     {@link DocumentInfoType }
         *     
         */
        public DocumentInfoType getLegalEntity() {
            return legalEntity;
        }

        /**
         * Define el valor de la propiedad legalEntity.
         * 
         * @param value
         *     allowed object is
         *     {@link DocumentInfoType }
         *     
         */
        public void setLegalEntity(DocumentInfoType value) {
            this.legalEntity = value;
        }

        /**
         * Obtiene el valor de la propiedad naturalPerson.
         * 
         * @return
         *     possible object is
         *     {@link PortOutValidationRequest.RequestBody.NaturalPerson }
         *     
         */
        public PortOutValidationRequest.RequestBody.NaturalPerson getNaturalPerson() {
            return naturalPerson;
        }

        /**
         * Define el valor de la propiedad naturalPerson.
         * 
         * @param value
         *     allowed object is
         *     {@link PortOutValidationRequest.RequestBody.NaturalPerson }
         *     
         */
        public void setNaturalPerson(PortOutValidationRequest.RequestBody.NaturalPerson value) {
            this.naturalPerson = value;
        }

        /**
         * Obtiene el valor de la propiedad msisdnList.
         * 
         * @return
         *     possible object is
         *     {@link MsisdnListType }
         *     
         */
        public MsisdnListType getMsisdnList() {
            return msisdnList;
        }

        /**
         * Define el valor de la propiedad msisdnList.
         * 
         * @param value
         *     allowed object is
         *     {@link MsisdnListType }
         *     
         */
        public void setMsisdnList(MsisdnListType value) {
            this.msisdnList = value;
        }

        /**
         * Obtiene el valor de la propiedad additionalParameters.
         * 
         * @return
         *     possible object is
         *     {@link PortOutValidationRequest.RequestBody.AdditionalParameters }
         *     
         */
        public PortOutValidationRequest.RequestBody.AdditionalParameters getAdditionalParameters() {
            return additionalParameters;
        }

        /**
         * Define el valor de la propiedad additionalParameters.
         * 
         * @param value
         *     allowed object is
         *     {@link PortOutValidationRequest.RequestBody.AdditionalParameters }
         *     
         */
        public void setAdditionalParameters(PortOutValidationRequest.RequestBody.AdditionalParameters value) {
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


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}DocumentInfoType">
         *       &lt;sequence>
         *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "extension"
        })
        public static class NaturalPerson
            extends DocumentInfoType
        {

            protected String extension;

            /**
             * Obtiene el valor de la propiedad extension.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExtension() {
                return extension;
            }

            /**
             * Define el valor de la propiedad extension.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExtension(String value) {
                this.extension = value;
            }

        }

    }

}
