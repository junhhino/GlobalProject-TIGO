/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.config.CacheIsolationType;

/**
 *
 * @author extiem
 */
@Entity
@Cache(isolation = CacheIsolationType.PROTECTED, alwaysRefresh = true, type = CacheType.NONE)
@Table(name = "P_VALIDACIONES_CUENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PValidacionesCuentas.findAll", query = "SELECT p FROM PValidacionesCuentas p")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findById", query = "SELECT p FROM PValidacionesCuentas p WHERE p.id = :id")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByNroCuenta", query = "SELECT p FROM PValidacionesCuentas p WHERE p.nroCuenta = :nroCuenta")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByFechaHoraAlta", query = "SELECT p FROM PValidacionesCuentas p WHERE p.fechaHoraAlta = :fechaHoraAlta")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByFechaHoraInit", query = "SELECT p FROM PValidacionesCuentas p WHERE p.fechaHoraInit = :fechaHoraInit")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByFechaHoraFin", query = "SELECT p FROM PValidacionesCuentas p WHERE p.fechaHoraFin = :fechaHoraFin")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByCodRespuesta", query = "SELECT p FROM PValidacionesCuentas p WHERE p.codRespuesta = :codRespuesta")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByMensajeRespuesta", query = "SELECT p FROM PValidacionesCuentas p WHERE p.mensajeRespuesta = :mensajeRespuesta")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByExistencia", query = "SELECT p FROM PValidacionesCuentas p WHERE p.existencia = :existencia")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByTitular", query = "SELECT p FROM PValidacionesCuentas p WHERE p.titular = :titular")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByComodato", query = "SELECT p FROM PValidacionesCuentas p WHERE p.comodato = :comodato")
    ,
    @NamedQuery(name = "PValidacionesCuentas.findByFechaHabilitacion", query = "SELECT p FROM PValidacionesCuentas p WHERE p.fechaHabilitacion = :fechaHabilitacion")})
public class PValidacionesCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P_VALIDACION_CUENTA_ID_SEQ")
    @SequenceGenerator(name = "P_VALIDACION_CUENTA_ID_SEQ", sequenceName = "P_VALIDACION_CUENTA_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NRO_CUENTA")
    private String nroCuenta;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraAlta;
    @Column(name = "FECHA_HORA_INIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInit;
    @Column(name = "FECHA_HORA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFin;
    @Column(name = "COD_RESPUESTA")
    private String codRespuesta;
    @Column(name = "MENSAJE_RESPUESTA")
    private String mensajeRespuesta;
    @Column(name = "EXISTENCIA")
    private String existencia;
    @Column(name = "TITULAR")
    private String titular;
    @Column(name = "COMODATO")
    private String comodato;
    @Column(name = "FECHA_HABILITACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHabilitacion;
    @Column(name = "PENDIENTES")
    private BigInteger pendientes;
    @Column(name = "ESTADOS")
    private String estados;
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @Column(name = "DESC_COMP")
    private String descComp;
    @JoinColumn(name = "VALIDACION_ID", referencedColumnName = "VALIDACION_ID")
    @ManyToOne(optional = false)
    private PValidaciones validacionId;
    @JoinColumn(name = "ESTADO_PROCESO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PEstadosProceso estadoProcesoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "validacionesCuentasId")
    private List<PValidCuentasEstados> pValidCuentasEstadosList;

    public PValidacionesCuentas() {
    }

    public PValidacionesCuentas(BigDecimal id) {
        this.id = id;
    }

    public PValidacionesCuentas(BigDecimal id, String nroCuenta, Date fechaHoraAlta) {
        this.id = id;
        this.nroCuenta = nroCuenta;
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Date getFechaHoraAlta() {
        return fechaHoraAlta;
    }

    public void setFechaHoraAlta(Date fechaHoraAlta) {
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public Date getFechaHoraInit() {
        return fechaHoraInit;
    }

    public void setFechaHoraInit(Date fechaHoraInit) {
        this.fechaHoraInit = fechaHoraInit;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getComodato() {
        return comodato;
    }

    public void setComodato(String comodato) {
        this.comodato = comodato;
    }

    public Date getFechaHabilitacion() {
        return fechaHabilitacion;
    }

    public void setFechaHabilitacion(Date fechaHabilitacion) {
        this.fechaHabilitacion = fechaHabilitacion;
    }

    public PValidaciones getValidacionId() {
        return validacionId;
    }

    public void setValidacionId(PValidaciones validacionId) {
        this.validacionId = validacionId;
    }

    public PEstadosProceso getEstadoProcesoId() {
        return estadoProcesoId;
    }

    public void setEstadoProcesoId(PEstadosProceso estadoProcesoId) {
        this.estadoProcesoId = estadoProcesoId;
    }

    public BigInteger getPendientes() {
        return pendientes;
    }

    public void setPendientes(BigInteger pendientes) {
        this.pendientes = pendientes;
    }

    public String getEstados() {
        return estados;
    }

    public void setEstados(String estados) {
        this.estados = estados;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getDescComp() {
        return descComp;
    }

    public void setDescComp(String descComp) {
        this.descComp = descComp;
    }

    @XmlTransient
    public List<PValidCuentasEstados> getPValidCuentasEstadosList() {
        return pValidCuentasEstadosList;
    }

    public void setPValidCuentasEstadosList(List<PValidCuentasEstados> pValidCuentasEstadosList) {
        this.pValidCuentasEstadosList = pValidCuentasEstadosList;
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
        if (!(object instanceof PValidacionesCuentas)) {
            return false;
        }
        PValidacionesCuentas other = (PValidacionesCuentas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PValidacionesCuentas[ id=" + id + " ]";
    }

}
