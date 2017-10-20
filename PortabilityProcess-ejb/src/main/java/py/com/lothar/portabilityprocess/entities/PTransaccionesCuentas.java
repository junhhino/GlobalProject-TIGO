/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.config.CacheIsolationType;


/**
 *
 * @author extiem
 */
@Entity
@Cache(isolation = CacheIsolationType.PROTECTED, alwaysRefresh = true, type = CacheType.NONE)
@Table(name = "P_TRANSACCIONES_CUENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PTransaccionesCuentas.findAll", query = "SELECT p FROM PTransaccionesCuentas p"),
    @NamedQuery(name = "PTransaccionesCuentas.findById", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.id = :id"),
    @NamedQuery(name = "PTransaccionesCuentas.findByNroCuenta", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.nroCuenta = :nroCuenta"),
    @NamedQuery(name = "PTransaccionesCuentas.findByFechaHoraAlta", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.fechaHoraAlta = :fechaHoraAlta"),
    @NamedQuery(name = "PTransaccionesCuentas.findByFechaHoraInit", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.fechaHoraInit = :fechaHoraInit"),
    @NamedQuery(name = "PTransaccionesCuentas.findByFechaHoraFin", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.fechaHoraFin = :fechaHoraFin"),
    @NamedQuery(name = "PTransaccionesCuentas.findByCodRespuesta", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "PTransaccionesCuentas.findByMensajeRespuesta", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.mensajeRespuesta = :mensajeRespuesta"),
    @NamedQuery(name = "PTransaccionesCuentas.findByRespEstado", query = "SELECT p FROM PTransaccionesCuentas p WHERE p.respEstado = :respEstado")})
public class PTransaccionesCuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P_TRANSACCION_CUENTAS_ID_SEQ")
    @SequenceGenerator(name = "P_TRANSACCION_CUENTAS_ID_SEQ", sequenceName = "P_TRANSACCION_CUENTAS_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private BigInteger id;
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
    @Column(name = "RESP_ESTADO")
    private String respEstado;
    @JoinColumn(name = "ID_TRANSACCION", referencedColumnName = "ID_TRANSACCION")
    @ManyToOne(optional = false)
    private PTransacciones idTransaccion;
    @JoinColumn(name = "ESTADO_PROCESO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PEstadosProceso estadoProcesoId;

    public PTransaccionesCuentas() {
    }

    public PTransaccionesCuentas(BigInteger id) {
        this.id = id;
    }

    public PTransaccionesCuentas(BigInteger id, String nroCuenta, Date fechaHoraAlta) {
        this.id = id;
        this.nroCuenta = nroCuenta;
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public String getRespEstado() {
        return respEstado;
    }

    public void setRespEstado(String respEstado) {
        this.respEstado = respEstado;
    }

    public PTransacciones getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(PTransacciones idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public PEstadosProceso getEstadoProcesoId() {
        return estadoProcesoId;
    }

    public void setEstadoProcesoId(PEstadosProceso estadoProcesoId) {
        this.estadoProcesoId = estadoProcesoId;
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
        if (!(object instanceof PTransaccionesCuentas)) {
            return false;
        }
        PTransaccionesCuentas other = (PTransaccionesCuentas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PTransaccionesCuentas[ id=" + id + " ]";
    }

}
