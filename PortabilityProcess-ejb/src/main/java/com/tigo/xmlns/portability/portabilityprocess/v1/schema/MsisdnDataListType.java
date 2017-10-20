package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Clase Java para MsisdnDataListType complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="MsisdnDataListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msisdnInfo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="existence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="statusList" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}StatusListType"/>
 *                   &lt;element name="loan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="enablementDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="pendingInvoices" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
@XmlType(name = "MsisdnDataListType", propOrder = {
    "msisdnInfo"
})
public class MsisdnDataListType {

    @XmlElement(required = true)
    protected List<MsisdnDataListType.MsisdnInfo> msisdnInfo;

    /**
     * Gets the value of the msisdnInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the msisdnInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsisdnInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MsisdnDataListType.MsisdnInfo }
     *
     *
     */
    public List<MsisdnDataListType.MsisdnInfo> getMsisdnInfo() {
        if (msisdnInfo == null) {
            msisdnInfo = new ArrayList<MsisdnDataListType.MsisdnInfo>();
        }
        return this.msisdnInfo;
    }

    /**
     * <p>
     * Clase Java para anonymous complex type.
     *
     * <p>
     * El siguiente fragmento de esquema especifica el contenido que se espera
     * que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="existence" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="statusList" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}StatusListType"/>
     *         &lt;element name="loan" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="enablementDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="pendingInvoices" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
        "msisdn",
        "existence",
        "ownerName",
        "statusList",
        "loan",
        "enablementDate",
        "pendingInvoices",
        "emissionDate",
        "validityDate",
        "receiptDesc"
    })
    public static class MsisdnInfo {

        @XmlElement(required = true)
        protected String msisdn;
        @XmlElement(required = true)
        protected String existence;
        @XmlElement(required = true)
        protected String ownerName;
        @XmlElement(required = true)
        protected StatusListType statusList;
        @XmlElement(required = true)
        protected String loan;
//        @XmlElement(required = true)
//        @XmlSchemaType(name = "date")
//        protected XMLGregorianCalendar enablementDate;
        @XmlElement(required = true)
        protected String enablementDate;
        @XmlElement(required = true)
        protected BigInteger pendingInvoices;
        @XmlElement(required = false)
        protected Date emissionDate;
        @XmlElement(required = false)
        protected Date validityDate;
        @XmlElement(required = false)
        protected String receiptDesc;

        /**
         * Obtiene el valor de la propiedad msisdn.
         *
         * @return possible object is {@link String }
         *
         */
        public String getMsisdn() {
            return msisdn;
        }

        /**
         * Define el valor de la propiedad msisdn.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setMsisdn(String value) {
            this.msisdn = value;
        }

        /**
         * Obtiene el valor de la propiedad existence.
         *
         * @return possible object is {@link String }
         *
         */
        public String getExistence() {
            return existence;
        }

        /**
         * Define el valor de la propiedad existence.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setExistence(String value) {
            this.existence = value;
        }

        /**
         * Obtiene el valor de la propiedad ownerName.
         *
         * @return possible object is {@link String }
         *
         */
        public String getOwnerName() {
            return ownerName;
        }

        /**
         * Define el valor de la propiedad ownerName.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setOwnerName(String value) {
            this.ownerName = value;
        }

        /**
         * Obtiene el valor de la propiedad statusList.
         *
         * @return possible object is {@link StatusListType }
         *
         */
        public StatusListType getStatusList() {
            return statusList;
        }

        /**
         * Define el valor de la propiedad statusList.
         *
         * @param value allowed object is {@link StatusListType }
         *
         */
        public void setStatusList(StatusListType value) {
            this.statusList = value;
        }

        /**
         * Obtiene el valor de la propiedad loan.
         *
         * @return possible object is {@link String }
         *
         */
        public String getLoan() {
            return loan;
        }

        /**
         * Define el valor de la propiedad loan.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setLoan(String value) {
            this.loan = value;
        }

        /**
         * Obtiene el valor de la propiedad enablementDate.
         *
         * @return possible object is {@link XMLGregorianCalendar }
         *
         */
//        public XMLGregorianCalendar getEnablementDate() {
//            return enablementDate;
//        }
        public String getEnablementDate() {
            return enablementDate;
        }

        /**
         * Define el valor de la propiedad enablementDate.
         *
         * @param value allowed object is {@link XMLGregorianCalendar }
         *
         */
//        public void setEnablementDate(XMLGregorianCalendar value) {
//            this.enablementDate = value;
//        }
        public void setEnablementDate(String value) {
            this.enablementDate = value;
        }

        /**
         * Obtiene el valor de la propiedad pendingInvoices.
         *
         * @return possible object is {@link BigInteger }
         *
         */
        public BigInteger getPendingInvoices() {
            return pendingInvoices;
        }

        /**
         * Define el valor de la propiedad pendingInvoices.
         *
         * @param value allowed object is {@link BigInteger }
         *
         */
        public void setPendingInvoices(BigInteger value) {
            this.pendingInvoices = value;
        }

        public Date getEmissionDate() {
            return emissionDate;
        }

        public void setEmissionDate(Date emissionDate) {
            this.emissionDate = emissionDate;
        }

        public Date getValidityDate() {
            return validityDate;
        }

        public void setValidityDate(Date validityDate) {
            this.validityDate = validityDate;
        }

        public String getReceiptDesc() {
            return receiptDesc;
        }

        public void setReceiptDesc(String receiptDesc) {
            this.receiptDesc = receiptDesc;
        }
    }

}
