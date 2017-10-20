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
@Table(name = "P_VALIDACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PValidaciones.findAll", query = "SELECT p FROM PValidaciones p"),
    @NamedQuery(name = "PValidaciones.findByValidacionId", query = "SELECT p FROM PValidaciones p WHERE p.validacionId = :validacionId"),
    @NamedQuery(name = "PValidaciones.findByExternalTransactionId", query = "SELECT p FROM PValidaciones p WHERE p.externalTransactionId = :externalTransactionId"),
    @NamedQuery(name = "PValidaciones.findByFechaHoraAlta", query = "SELECT p FROM PValidaciones p WHERE p.fechaHoraAlta = :fechaHoraAlta"),
    @NamedQuery(name = "PValidaciones.findByFechaHoraInit", query = "SELECT p FROM PValidaciones p WHERE p.fechaHoraInit = :fechaHoraInit"),
    @NamedQuery(name = "PValidaciones.findByFechaHoraFin", query = "SELECT p FROM PValidaciones p WHERE p.fechaHoraFin = :fechaHoraFin"),
    @NamedQuery(name = "PValidaciones.findByPjTipoDocumento", query = "SELECT p FROM PValidaciones p WHERE p.pjTipoDocumento = :pjTipoDocumento"),
    @NamedQuery(name = "PValidaciones.findByPjNumeroDocumento", query = "SELECT p FROM PValidaciones p WHERE p.pjNumeroDocumento = :pjNumeroDocumento"),
    @NamedQuery(name = "PValidaciones.findByPfTipoDocumento", query = "SELECT p FROM PValidaciones p WHERE p.pfTipoDocumento = :pfTipoDocumento"),
    @NamedQuery(name = "PValidaciones.findByPfNumeroDocumento", query = "SELECT p FROM PValidaciones p WHERE p.pfNumeroDocumento = :pfNumeroDocumento"),
    @NamedQuery(name = "PValidaciones.findByPfExtension", query = "SELECT p FROM PValidaciones p WHERE p.pfExtension = :pfExtension")})
public class PValidaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P_VALIDACION_ID_SEQ")
    @SequenceGenerator(name = "P_VALIDACION_ID_SEQ", sequenceName = "P_VALIDACION_ID_SEQ", allocationSize = 1)
    @Column(name = "VALIDACION_ID")
    private BigInteger validacionId;
    @Basic(optional = false)
    @Column(name = "EXTERNAL_TRANSACTION_ID")
    private BigInteger externalTransactionId;
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
    @Column(name = "PJ_TIPO_DOCUMENTO")
    private BigInteger pjTipoDocumento;
    @Column(name = "PJ_NUMERO_DOCUMENTO")
    private String pjNumeroDocumento;
    @Column(name = "PF_TIPO_DOCUMENTO")
    private BigInteger pfTipoDocumento;
    @Column(name = "PF_NUMERO_DOCUMENTO")
    private String pfNumeroDocumento;
    @Column(name = "PF_EXTENSION")
    private String pfExtension;
    @Column(name = "CODIGO_PROCESO")
    private BigInteger codProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "validacionId", fetch = FetchType.LAZY)
    private List<PValidacionesCuentas> pValidacionesCuentasList;
    @JoinColumn(name = "TIPO_INBOUND_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PTiposInbound tipoInboundId;
    @JoinColumn(name = "ESTADO_PROCESO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PEstadosProceso estadoProcesoId;
    @JoinColumn(name = "ARCHIVO_FTP_ID", referencedColumnName = "ID")
    @ManyToOne
    private PArchivosFtp archivoFtpId;

    public PValidaciones() {
    }

    public PValidaciones(BigInteger validacionId) {
        this.validacionId = validacionId;
    }

    public PValidaciones(BigInteger validacionId, BigInteger externalTransactionId, Date fechaHoraAlta) {
        this.validacionId = validacionId;
        this.externalTransactionId = externalTransactionId;
        this.fechaHoraAlta = fechaHoraAlta;
    }

    public BigInteger getValidacionId() {
        return validacionId;
    }

    public void setValidacionId(BigInteger validacionId) {
        this.validacionId = validacionId;
    }

    public BigInteger getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(BigInteger externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
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

    public BigInteger getPjTipoDocumento() {
        return pjTipoDocumento;
    }

    public void setPjTipoDocumento(BigInteger pjTipoDocumento) {
        this.pjTipoDocumento = pjTipoDocumento;
    }

    public String getPjNumeroDocumento() {
        return pjNumeroDocumento;
    }

    public void setPjNumeroDocumento(String pjNumeroDocumento) {
        this.pjNumeroDocumento = pjNumeroDocumento;
    }

    public BigInteger getPfTipoDocumento() {
        return pfTipoDocumento;
    }

    public void setPfTipoDocumento(BigInteger pfTipoDocumento) {
        this.pfTipoDocumento = pfTipoDocumento;
    }

    public String getPfNumeroDocumento() {
        return pfNumeroDocumento;
    }

    public void setPfNumeroDocumento(String pfNumeroDocumento) {
        this.pfNumeroDocumento = pfNumeroDocumento;
    }

    public String getPfExtension() {
        return pfExtension;
    }

    public void setPfExtension(String pfExtension) {
        this.pfExtension = pfExtension;
    }

    public BigInteger getCodProceso() {
        return codProceso;
    }

    public void setCodProceso(BigInteger codProceso) {
        this.codProceso = codProceso;
    }

    @XmlTransient
    public List<PValidacionesCuentas> getPValidacionesCuentasList() {
        return pValidacionesCuentasList;
    }

    public void setPValidacionesCuentasList(List<PValidacionesCuentas> pValidacionesCuentasList) {
        this.pValidacionesCuentasList = pValidacionesCuentasList;
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
        hash += (validacionId != null ? validacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PValidaciones)) {
            return false;
        }
        PValidaciones other = (PValidaciones) object;
        if ((this.validacionId == null && other.validacionId != null) || (this.validacionId != null && !this.validacionId.equals(other.validacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PValidaciones[ validacionId=" + validacionId + " ]";
    }

}
