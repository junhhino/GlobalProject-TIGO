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
@Table(name = "P_ESTADOS_PROCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PEstadosProceso.findAll", query = "SELECT p FROM PEstadosProceso p"),
    @NamedQuery(name = "PEstadosProceso.findById", query = "SELECT p FROM PEstadosProceso p WHERE p.id = :id"),
    @NamedQuery(name = "PEstadosProceso.findByValor", query = "SELECT p FROM PEstadosProceso p WHERE UPPER(p.valor) = :valor"),
    @NamedQuery(name = "PEstadosProceso.findByDescripcion", query = "SELECT p FROM PEstadosProceso p WHERE p.descripcion = :descripcion")})
public class PEstadosProceso implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String CARGANDO = "CARGANDO";
    public static final String PENDIENTE = "PENDIENTE";
    public static final String PROCESANDO = "PROCESANDO";
    public static final String FINALIZADO = "FINALIZADO";
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProcesoId")
    private List<PValidacionesCuentas> pValidacionesCuentasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProcesoId")
    private List<PTransaccionesCuentas> pTransaccionesCuentasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProcesoId")
    private List<PTransacciones> pTransaccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProcesoId")
    private List<PValidaciones> pValidacionesList;

    public PEstadosProceso() {
    }

    public PEstadosProceso(Short id) {
        this.id = id;
    }

    public PEstadosProceso(Short id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PValidacionesCuentas> getPValidacionesCuentasList() {
        return pValidacionesCuentasList;
    }

    public void setPValidacionesCuentasList(List<PValidacionesCuentas> pValidacionesCuentasList) {
        this.pValidacionesCuentasList = pValidacionesCuentasList;
    }

    @XmlTransient
    public List<PTransaccionesCuentas> getPTransaccionesCuentasList() {
        return pTransaccionesCuentasList;
    }

    public void setPTransaccionesCuentasList(List<PTransaccionesCuentas> pTransaccionesCuentasList) {
        this.pTransaccionesCuentasList = pTransaccionesCuentasList;
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
        if (!(object instanceof PEstadosProceso)) {
            return false;
        }
        PEstadosProceso other = (PEstadosProceso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PEstadosProceso[ id=" + id + " ]";
    }
    
}
