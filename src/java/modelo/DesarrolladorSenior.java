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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "desarrollador_senior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesarrolladorSenior.findAll", query = "SELECT d FROM DesarrolladorSenior d")
    , @NamedQuery(name = "DesarrolladorSenior.findByIdDesarrolladorSenior", query = "SELECT d FROM DesarrolladorSenior d WHERE d.idDesarrolladorSenior = :idDesarrolladorSenior")
    , @NamedQuery(name = "DesarrolladorSenior.findByCantidadProyectos", query = "SELECT d FROM DesarrolladorSenior d WHERE d.cantidadProyectos = :cantidadProyectos")})
public class DesarrolladorSenior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDesarrollador_Senior")
    private Integer idDesarrolladorSenior;
    @Column(name = "Cantidad_Proyectos")
    private Integer cantidadProyectos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desarrolladorSenioridDesarrolladorSenior")
    private List<JefeDesarrollo> jefeDesarrolloList;
    @JoinColumn(name = "Ingeniero_Cedula", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Ingeniero ingenieroCedula;
    @JoinColumn(name = "Proyecto_Software_idProyecto_Software", referencedColumnName = "idProyecto_Software")
    @ManyToOne(optional = false)
    private ProyectoSoftware proyectoSoftwareidProyectoSoftware;

    public DesarrolladorSenior() {
    }

    public DesarrolladorSenior(Integer idDesarrolladorSenior) {
        this.idDesarrolladorSenior = idDesarrolladorSenior;
    }

    public Integer getIdDesarrolladorSenior() {
        return idDesarrolladorSenior;
    }

    public void setIdDesarrolladorSenior(Integer idDesarrolladorSenior) {
        this.idDesarrolladorSenior = idDesarrolladorSenior;
    }

    public Integer getCantidadProyectos() {
        return cantidadProyectos;
    }

    public void setCantidadProyectos(Integer cantidadProyectos) {
        this.cantidadProyectos = cantidadProyectos;
    }

    @XmlTransient
    public List<JefeDesarrollo> getJefeDesarrolloList() {
        return jefeDesarrolloList;
    }

    public void setJefeDesarrolloList(List<JefeDesarrollo> jefeDesarrolloList) {
        this.jefeDesarrolloList = jefeDesarrolloList;
    }

    public Ingeniero getIngenieroCedula() {
        return ingenieroCedula;
    }

    public void setIngenieroCedula(Ingeniero ingenieroCedula) {
        this.ingenieroCedula = ingenieroCedula;
    }

    public ProyectoSoftware getProyectoSoftwareidProyectoSoftware() {
        return proyectoSoftwareidProyectoSoftware;
    }

    public void setProyectoSoftwareidProyectoSoftware(ProyectoSoftware proyectoSoftwareidProyectoSoftware) {
        this.proyectoSoftwareidProyectoSoftware = proyectoSoftwareidProyectoSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesarrolladorSenior != null ? idDesarrolladorSenior.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesarrolladorSenior)) {
            return false;
        }
        DesarrolladorSenior other = (DesarrolladorSenior) object;
        if ((this.idDesarrolladorSenior == null && other.idDesarrolladorSenior != null) || (this.idDesarrolladorSenior != null && !this.idDesarrolladorSenior.equals(other.idDesarrolladorSenior))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DesarrolladorSenior[ idDesarrolladorSenior=" + idDesarrolladorSenior + " ]";
    }
    
}
