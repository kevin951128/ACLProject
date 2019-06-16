/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "requisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r")
    , @NamedQuery(name = "Requisito.findByIdRequisito", query = "SELECT r FROM Requisito r WHERE r.idRequisito = :idRequisito")
    , @NamedQuery(name = "Requisito.findByDescripcion", query = "SELECT r FROM Requisito r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Requisito.findByTipo", query = "SELECT r FROM Requisito r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "Requisito.findByEstado", query = "SELECT r FROM Requisito r WHERE r.estado = :estado")})
public class Requisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRequisito")
    private Integer idRequisito;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 10)
    @Column(name = "Tipo")
    private String tipo;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitoidRequisito")
    private List<ProyectoSoftware> proyectoSoftwareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitoidRequisito")
    private List<Solicitud> solicitudList;

    public Requisito() {
    }

    public Requisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ProyectoSoftware> getProyectoSoftwareList() {
        return proyectoSoftwareList;
    }

    public void setProyectoSoftwareList(List<ProyectoSoftware> proyectoSoftwareList) {
        this.proyectoSoftwareList = proyectoSoftwareList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisito != null ? idRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.idRequisito == null && other.idRequisito != null) || (this.idRequisito != null && !this.idRequisito.equals(other.idRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Requisito[ idRequisito=" + idRequisito + " ]";
    }
    
}
