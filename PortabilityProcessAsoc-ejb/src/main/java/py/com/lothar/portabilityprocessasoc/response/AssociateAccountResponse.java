/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocessasoc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import py.com.lothar.portabilityprocessasoc.dto.AdditionalParameters;

/**
 *
 * @author fran
 */

/**
 * <p>Clase Java para basicResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="associateAccountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoProceso" type="{http://www.w3.org/2001/XMLSchema}Integer" minOccurs="0"/>
 *         &lt;element name="eventcode" type="{http://www.w3.org/2001/XMLSchema}Integer" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}Integer" minOccurs="0"/>
 *         &lt;element name="additionalParameters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociateAccountResponse")
public class AssociateAccountResponse {
    
    @XmlElement(name = "idTransaccion")
    protected Integer idTransaccion;
    
    @XmlElement(name = "codigoProceso")
    protected Integer codigoProceso;
    
    @XmlElement(name = "descripcion")
    protected String descripcion;
    
    @XmlElement(name = "addditionalParameters")
    protected AdditionalParameters addditionalParameters;

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(Integer codigoProceso) {
        this.codigoProceso = codigoProceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public AdditionalParameters getAddditionalParameters() {
        return addditionalParameters;
    }

    public void setAddditionalParameters(AdditionalParameters addditionalParameters) {
        this.addditionalParameters = addditionalParameters;
    }

    
    
}
