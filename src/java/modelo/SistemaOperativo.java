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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "sistema_operativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaOperativo.findAll", query = "SELECT s FROM SistemaOperativo s")
    , @NamedQuery(name = "SistemaOperativo.findByIdSistemaOperativo", query = "SELECT s FROM SistemaOperativo s WHERE s.idSistemaOperativo = :idSistemaOperativo")
    , @NamedQuery(name = "SistemaOperativo.findByNombre", query = "SELECT s FROM SistemaOperativo s WHERE s.nombre = :nombre")})
public class SistemaOperativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSistema_Operativo")
    private Integer idSistemaOperativo;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @JoinTable(name = "sistema_operativo_has_proyecto_software", joinColumns = {
        @JoinColumn(name = "Sistema_Operativo_idSistema_Operativo", referencedColumnName = "idSistema_Operativo")}, inverseJoinColumns = {
        @JoinColumn(name = "Proyecto_Software_idProyecto_Software", referencedColumnName = "idProyecto_Software")})
    @ManyToMany
    private List<ProyectoSoftware> proyectoSoftwareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemaOperativoidSistemaOperativo")
    private List<Ingeniero> ingenieroList;

    public SistemaOperativo() {
    }

    public SistemaOperativo(Integer idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    public Integer getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(Integer idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<ProyectoSoftware> getProyectoSoftwareList() {
        return proyectoSoftwareList;
    }

    public void setProyectoSoftwareList(List<ProyectoSoftware> proyectoSoftwareList) {
        this.proyectoSoftwareList = proyectoSoftwareList;
    }

    @XmlTransient
    public List<Ingeniero> getIngenieroList() {
        return ingenieroList;
    }

    public void setIngenieroList(List<Ingeniero> ingenieroList) {
        this.ingenieroList = ingenieroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistemaOperativo != null ? idSistemaOperativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaOperativo)) {
            return false;
        }
        SistemaOperativo other = (SistemaOperativo) object;
        if ((this.idSistemaOperativo == null && other.idSistemaOperativo != null) || (this.idSistemaOperativo != null && !this.idSistemaOperativo.equals(other.idSistemaOperativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SistemaOperativo[ idSistemaOperativo=" + idSistemaOperativo + " ]";
    }
    
}
