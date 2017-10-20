/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.activacionprepago.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import py.com.lothar.activacionprepago.dto.AdditionalParameters;
/**
 *
 * @author Fran
 */
/**
 * <p>Clase Java para basicResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="activationprepagoresponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idtransaccion" type="{http://www.w3.org/2001/XMLSchema}Integer" minOccurs="0"/>
 *         &lt;element name="nrocuenta" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
 *         &lt;element name="codrespuesta" type="{http://www.w3.org/2001/XMLSchema}Integer" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
 *         &lt;element name="additionalParameters" type="{http://www.w3.org/2001/XMLSchema}AdditionalParameters" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activationprepagoresponse")
public class ActivationPrepagoResponse {
   
    @XmlElement (name = "codRespuesta")
    private Integer codRespuesta;
    
    @XmlElement (name = "descriocion")
    private String descripcion;
    
    @XmlElement (name = "nrocliente")
    private Integer nroCliente  ;
    
    @XmlElement(name = "additionalparameters")
    protected AdditionalParameters additionalParameters;  
    
    public ActivationPrepagoResponse(){
        
    }

    public Integer getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(Integer codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(Integer nroCliente) {
        this.nroCliente = nroCliente;
    }

    public AdditionalParameters getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(AdditionalParameters additionalParameters) {
        this.additionalParameters = additionalParameters;
    }
    
}
