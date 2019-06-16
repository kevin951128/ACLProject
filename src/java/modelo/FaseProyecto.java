/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "fase_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaseProyecto.findAll", query = "SELECT f FROM FaseProyecto f")
    , @NamedQuery(name = "FaseProyecto.findByIdFaseProyecto", query = "SELECT f FROM FaseProyecto f WHERE f.idFaseProyecto = :idFaseProyecto")
    , @NamedQuery(name = "FaseProyecto.findByFInicio", query = "SELECT f FROM FaseProyecto f WHERE f.fInicio = :fInicio")
    , @NamedQuery(name = "FaseProyecto.findByTipo", query = "SELECT f FROM FaseProyecto f WHERE f.tipo = :tipo")})
public class FaseProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFase_Proyecto")
    private Integer idFaseProyecto;
    @Column(name = "F_Inicio")
    @Temporal(TemporalType.DATE)
    private Date fInicio;
    @Size(max = 10)
    @Column(name = "Tipo")
    private String tipo;
    @JoinTable(name = "fase_proyecto_has_proyecto_software", joinColumns = {
        @JoinColumn(name = "Fase_Proyecto_idFase_Proyecto", referencedColumnName = "idFase_Proyecto")}, inverseJoinColumns = {
        @JoinColumn(name = "Proyecto_Software_idProyecto_Software", referencedColumnName = "idProyecto_Software")})
    @ManyToMany
    private List<ProyectoSoftware> proyectoSoftwareList;

    public FaseProyecto() {
    }

    public FaseProyecto(Integer idFaseProyecto) {
        this.idFaseProyecto = idFaseProyecto;
    }

    public Integer getIdFaseProyecto() {
        return idFaseProyecto;
    }

    public void setIdFaseProyecto(Integer idFaseProyecto) {
        this.idFaseProyecto = idFaseProyecto;
    }

    public Date getFInicio() {
        return fInicio;
    }

    public void setFInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<ProyectoSoftware> getProyectoSoftwareList() {
        return proyectoSoftwareList;
    }

    public void setProyectoSoftwareList(List<ProyectoSoftware> proyectoSoftwareList) {
        this.proyectoSoftwareList = proyectoSoftwareList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFaseProyecto != null ? idFaseProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaseProyecto)) {
            return false;
        }
        FaseProyecto other = (FaseProyecto) object;
        if ((this.idFaseProyecto == null && other.idFaseProyecto != null) || (this.idFaseProyecto != null && !this.idFaseProyecto.equals(other.idFaseProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FaseProyecto[ idFaseProyecto=" + idFaseProyecto + " ]";
    }
    
}
