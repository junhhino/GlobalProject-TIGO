/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "P_TRANSACCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PTransacciones.findAll", query = "SELECT p FROM PTransacciones p"),
    @NamedQuery(name = "PTransacciones.findByIdTransaccion", query = "SELECT p FROM PTransacciones p WHERE p.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "PTransacciones.findByExternalTransactionId", query = "SELECT p FROM PTransacciones p WHERE p.externalTransactionId = :externalTransactionId"),
    @NamedQuery(name = "PTransacciones.findByCodigoProceso", query = "SELECT p FROM PTransacciones p WHERE p.codigoProceso = :codigoProceso"),
    @NamedQuery(name = "PTransacciones.findByFechaHoraAlta", query = "SELECT p FROM PTransacciones p WHERE p.fechaHoraAlta = :fechaHoraAlta"),
    @NamedQuery(name = "PTransacciones.findByFechaHoraInit", query = "SELECT p FROM PTransacciones p WHERE p.fechaHoraInit = :fechaHoraInit"),
    @NamedQuery(name = "PTransacciones.findByFechaHoraFin", query = "SELECT p FROM PTransacciones p WHERE p.fechaHoraFin = :fechaHoraFin")})
public class PTransacciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P_TRANSACCION_ID_SEQ")
    @SequenceGenerator(name = "P_TRANSACCION_ID_SEQ", sequenceName = "P_TRANSACCION_ID_SEQ", allocationSize = 1)
    @Column(name = "ID_TRANSACCION")
    private BigInteger idTransaccion;
    @Basic(optional = false)
    @Column(name = "EXTERNAL_TRANSACTION_ID")
    private BigInteger externalTransactionId;
    @Basic(optional = false)
    @Column(name = "CODIGO_PROCESO")
    private BigInteger codigoProceso;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransaccion", fetch = FetchType.LAZY)
    private List<PTransaccionesCuentas> pTransaccionesCuentasList;
    @JoinColumn(name = "TIPO_INBOUND_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PTiposInbound tipoInboundId;
    @JoinColumn(name = "ESTADO_PROCESO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PEstadosProceso estadoProcesoId;
    @JoinColumn(name = "ARCHIVO_FTP_ID", referencedColumnName = "ID")
    @ManyToOne
    private PArchivosFtp archivoFtpId;

    public PTransacciones() {
    }

    public PTransacciones(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public PTransacciones(BigInteger idTransaccion, BigInteger externalTransactionId, BigInteger codigoProceso, Date fechaHoraAlta) {
        this.idTransaccion = idTransaccion;
        this.externalTransactionId = externalTransactionId;
        this.codigoProceso = codigoProceso;
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public BigInteger getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(BigInteger externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public BigInteger getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(BigInteger codigoProceso) {
        this.codigoProceso = codigoProceso;
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

    @XmlTransient
    public List<PTransaccionesCuentas> getPTransaccionesCuentasList() {
        return pTransaccionesCuentasList;
    }

    public void setPTransaccionesCuentasList(List<PTransaccionesCuentas> pTransaccionesCuentasList) {
        this.pTransaccionesCuentasList = pTransaccionesCuentasList;
    }

    public PTiposInbound getTipoInboundId() {
        return tipoInboundId;
    }

    public void setTipoInboundId(PTiposInbound tipoInboundId) {
        this.tipoInboundId = tipoInboundId;
    }

    public PEstadosProceso getEstadoProcesoId() {
        return estadoProcesoId;
    }

    public void setEstadoProcesoId(PEstadosProceso estadoProcesoId) {
        this.estadoProcesoId = estadoProcesoId;
    }

    public PArchivosFtp getArchivoFtpId() {
        return archivoFtpId;
    }

    public void setArchivoFtpId(PArchivosFtp archivoFtpId) {
        this.archivoFtpId = archivoFtpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PTransacciones)) {
            return false;
        }
        PTransacciones other = (PTransacciones) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PTransacciones[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
