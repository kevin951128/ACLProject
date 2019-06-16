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
@Table(name = "gestor_bd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestorBd.findAll", query = "SELECT g FROM GestorBd g")
    , @NamedQuery(name = "GestorBd.findByIdGestorBD", query = "SELECT g FROM GestorBd g WHERE g.idGestorBD = :idGestorBD")
    , @NamedQuery(name = "GestorBd.findByNombre", query = "SELECT g FROM GestorBd g WHERE g.nombre = :nombre")})
public class GestorBd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGestor_BD")
    private Integer idGestorBD;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @JoinTable(name = "gestor_bd_has_proyecto_software", joinColumns = {
        @JoinColumn(name = "Gestor_BD_idGestor_BD", referencedColumnName = "idGestor_BD")}, inverseJoinColumns = {
        @JoinColumn(name = "Proyecto_Software_idProyecto_Software", referencedColumnName = "idProyecto_Software")})
    @ManyToMany
    private List<ProyectoSoftware> proyectoSoftwareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gestorBDidGestorBD")
    private List<Ingeniero> ingenieroList;

    public GestorBd() {
    }

    public GestorBd(Integer idGestorBD) {
        this.idGestorBD = idGestorBD;
    }

    public Integer getIdGestorBD() {
        return idGestorBD;
    }

    public void setIdGestorBD(Integer idGestorBD) {
        this.idGestorBD = idGestorBD;
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
        hash += (idGestorBD != null ? idGestorBD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestorBd)) {
            return false;
        }
        GestorBd other = (GestorBd) object;
        if ((this.idGestorBD == null && other.idGestorBD != null) || (this.idGestorBD != null && !this.idGestorBD.equals(other.idGestorBD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GestorBd[ idGestorBD=" + idGestorBD + " ]";
    }
    
}
