/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author extiem
 */
@Entity
@Table(name = "P_VALID_CUENTAS_ESTADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PValidCuentasEstados.findAll", query = "SELECT p FROM PValidCuentasEstados p"),
    @NamedQuery(name = "PValidCuentasEstados.findById", query = "SELECT p FROM PValidCuentasEstados p WHERE p.id = :id"),
    @NamedQuery(name = "PValidCuentasEstados.findByEstado", query = "SELECT p FROM PValidCuentasEstados p WHERE p.estado = :estado"),
    @NamedQuery(name = "PValidCuentasEstados.findByTipo", query = "SELECT p FROM PValidCuentasEstados p WHERE p.tipo = :tipo")})
public class PValidCuentasEstados implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P_VALID_CUENTA_ESTADO_ID_SEQ")
    @SequenceGenerator(name = "P_VALID_CUENTA_ESTADO_ID_SEQ", sequenceName = "P_VALID_CUENTA_ESTADO_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "VALIDACIONES_CUENTAS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PValidacionesCuentas validacionesCuentasId;

    public PValidCuentasEstados() {
    }

    public PValidCuentasEstados(BigDecimal id) {
        this.id = id;
    }

    public PValidCuentasEstados(BigDecimal id, String estado, String tipo) {
        this.id = id;
        this.estado = estado;
        this.tipo = tipo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PValidacionesCuentas getValidacionesCuentasId() {
        return validacionesCuentasId;
    }

    public void setValidacionesCuentasId(PValidacionesCuentas validacionesCuentasId) {
        this.validacionesCuentasId = validacionesCuentasId;
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
        if (!(object instanceof PValidCuentasEstados)) {
            return false;
        }
        PValidCuentasEstados other = (PValidCuentasEstados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PValidCuentasEstados[ id=" + id + " ]";
    }
    
}
