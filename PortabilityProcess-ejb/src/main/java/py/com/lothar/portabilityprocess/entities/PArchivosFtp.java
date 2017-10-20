/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocess.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author extiem
 */
@Entity
@Table(name = "P_ARCHIVOS_FTP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PArchivosFtp.findAll", query = "SELECT p FROM PArchivosFtp p"),
    @NamedQuery(name = "PArchivosFtp.findById", query = "SELECT p FROM PArchivosFtp p WHERE p.id = :id"),
    @NamedQuery(name = "PArchivosFtp.findByNombre", query = "SELECT p FROM PArchivosFtp p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PArchivosFtp.findByDirectorioEntrada", query = "SELECT p FROM PArchivosFtp p WHERE p.directorioEntrada = :directorioEntrada"),
    @NamedQuery(name = "PArchivosFtp.findByDirectorioSalida", query = "SELECT p FROM PArchivosFtp p WHERE p.directorioSalida = :directorioSalida")})
public class PArchivosFtp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P_ARCHIVOS_FTP_ID_SEQ")
    @SequenceGenerator(name = "P_ARCHIVOS_FTP_ID_SEQ", sequenceName = "P_ARCHIVOS_FTP_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DIRECTORIO_ENTRADA")
    private String directorioEntrada;
    @Column(name = "DIRECTORIO_SALIDA")
    private String directorioSalida;
    @OneToMany(mappedBy = "archivoFtpId")
    private List<PTransacciones> pTransaccionesList;
    @OneToMany(mappedBy = "archivoFtpId")
    private List<PValidaciones> pValidacionesList;

    public PArchivosFtp() {
    }

    public PArchivosFtp(Long id) {
        this.id = id;
    }

    public PArchivosFtp(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirectorioEntrada() {
        return directorioEntrada;
    }

    public void setDirectorioEntrada(String directorioEntrada) {
        this.directorioEntrada = directorioEntrada;
    }

    public String getDirectorioSalida() {
        return directorioSalida;
    }

    public void setDirectorioSalida(String directorioSalida) {
        this.directorioSalida = directorioSalida;
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
        if (!(object instanceof PArchivosFtp)) {
            return false;
        }
        PArchivosFtp other = (PArchivosFtp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.lothar.portabilityprocess.entities.PArchivosFtp[ id=" + id + " ]";
    }
    
}
