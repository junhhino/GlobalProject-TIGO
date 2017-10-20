package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para PendingInvoicesType complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="PendingInvoicesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msisdnInfo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "PendingInvoicesType", propOrder = {
    "msisdnInfo"
})
public class PendingInvoicesType {

    @XmlElement(required = true)
    protected List<PendingInvoicesType.MsisdnInfo> msisdnInfo;

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
     * {@link PendingInvoicesType.MsisdnInfo }
     *
     *
     * @return
     */
    public List<PendingInvoicesType.MsisdnInfo> getMsisdnInfo() {
        if (msisdnInfo == null) {
            msisdnInfo = new ArrayList<PendingInvoicesType.MsisdnInfo>();
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
        "pendingInvoices"
    })
    public static class MsisdnInfo {

        @XmlElement(required = true)
        protected String msisdn;
        @XmlElement(required = true)
        protected BigInteger pendingInvoices;

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

    }

}
