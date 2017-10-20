
package com.tigo.xmlns.portability.portabilityprocess.v1.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MsisdnInformationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MsisdnInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msisdnInfo" type="{http://xmlns.tigo.com/Portability/PortabilityProcess/V1/schema}MsisdnInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsisdnInformationType", propOrder = {
    "msisdnInfo"
})
public class MsisdnInformationType {

    @XmlElement(required = true)
    protected List<MsisdnInfo> msisdnInfo;

    /**
     * Gets the value of the msisdnInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msisdnInfo property.
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
     * {@link MsisdnInfo }
     * 
     * 
     */
    public List<MsisdnInfo> getMsisdnInfo() {
        if (msisdnInfo == null) {
            msisdnInfo = new ArrayList<MsisdnInfo>();
        }
        return this.msisdnInfo;
    }

}
