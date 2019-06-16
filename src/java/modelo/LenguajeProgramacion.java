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
@Table(name = "lenguaje_programacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LenguajeProgramacion.findAll", query = "SELECT l FROM LenguajeProgramacion l")
    , @NamedQuery(name = "LenguajeProgramacion.findByIdLenguajeProgramacion", query = "SELECT l FROM LenguajeProgramacion l WHERE l.idLenguajeProgramacion = :idLenguajeProgramacion")
    , @NamedQuery(name = "LenguajeProgramacion.findByNombre", query = "SELECT l FROM LenguajeProgramacion l WHERE l.nombre = :nombre")})
public class LenguajeProgramacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLenguaje_Programacion")
    private Integer idLenguajeProgramacion;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @JoinTable(name = "lenguaje_programacion_has_proyecto_software", joinColumns = {
        @JoinColumn(name = "Lenguaje_Programacion_idLenguaje_Programacion", referencedColumnName = "idLenguaje_Programacion")}, inverseJoinColumns = {
        @JoinColumn(name = "Proyecto_Software_idProyecto_Software", referencedColumnName = "idProyecto_Software")})
    @ManyToMany
    private List<ProyectoSoftware> proyectoSoftwareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lenguajeProgramacionidLenguajeProgramacion")
    private List<Ingeniero> ingenieroList;

    public LenguajeProgramacion() {
    }

    public LenguajeProgramacion(Integer idLenguajeProgramacion) {
        this.idLenguajeProgramacion = idLenguajeProgramacion;
    }

    public Integer getIdLenguajeProgramacion() {
        return idLenguajeProgramacion;
    }

    public void setIdLenguajeProgramacion(Integer idLenguajeProgramacion) {
        this.idLenguajeProgramacion = idLenguajeProgramacion;
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
        hash += (idLenguajeProgramacion != null ? idLenguajeProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LenguajeProgramacion)) {
            return false;
        }
        LenguajeProgramacion other = (LenguajeProgramacion) object;
        if ((this.idLenguajeProgramacion == null && other.idLenguajeProgramacion != null) || (this.idLenguajeProgramacion != null && !this.idLenguajeProgramacion.equals(other.idLenguajeProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LenguajeProgramacion[ idLenguajeProgramacion=" + idLenguajeProgramacion + " ]";
    }
    
}
