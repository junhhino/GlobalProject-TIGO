/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author extiem
 */
@Entity
@Table(name = "P_TIPOS_INBOUND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PTiposInbound.findAll", query = "SELECT p FROM PTiposInbound p"),
    @NamedQuery(name = "PTiposInbound.findById", query = "SELECT p FROM PTiposInbound p WHERE p.id = :id"),
    @NamedQuery(name = "PTiposInbound.findByTipo", query = "SELECT p FROM PTiposInbound p WHERE UPPER(p.tipo) = :tipo"),
    @NamedQuery(name = "PTiposInbound.findByDescripcion", query = "SELECT p FROM PTiposInbound p WHERE p.descripcion = :descripcion")})
public class PTiposInbound implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String WEB_SERVICE = "WS";
    public static final String FTP         = "FTP";
    public static final String SFTP        = "SFTP";
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInboundId")
    private List<PTransacciones> pTransaccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInboundId")
    private List<PValidaciones> pValidacionesList;

    public PTiposInbound() {
    }

    public PTiposInbound(Short id) {
        this.id = id;
    }

    public PTiposInbound(Short id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PTransacciones> getPTransaccionesList() {
        return pTransaccionesList;
    }

    public void setPTransaccionesList(List<PTransacciones> pTransaccionesList) {
        this.pTransaccionesList = pTransaccionesList;
    }

    @XmlTransient
    public List<PValidaciones> getPValidacionesList() {
        return pValidacionesList;
    }

    public void setPValidacionesList(List<PValidaciones> pValidacionesList) {
        this.pValidacionesList = pValidacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PTiposInbound)) {
            return false;
        }
        PTiposInbound other = (PTiposInbound) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PTiposInbound[ id=" + id + " ]";
    }
    
}
