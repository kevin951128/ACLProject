/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "desarrollador_junior_has_proyecto_software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesarrolladorJuniorHasProyectoSoftware.findAll", query = "SELECT d FROM DesarrolladorJuniorHasProyectoSoftware d")
    , @NamedQuery(name = "DesarrolladorJuniorHasProyectoSoftware.findByDesarrolladorJunioridDesarrolladorJunior", query = "SELECT d FROM DesarrolladorJuniorHasProyectoSoftware d WHERE d.desarrolladorJuniorHasProyectoSoftwarePK.desarrolladorJunioridDesarrolladorJunior = :desarrolladorJunioridDesarrolladorJunior")
    , @NamedQuery(name = "DesarrolladorJuniorHasProyectoSoftware.findByProyectoSoftwareidProyectoSoftware", query = "SELECT d FROM DesarrolladorJuniorHasProyectoSoftware d WHERE d.desarrolladorJuniorHasProyectoSoftwarePK.proyectoSoftwareidProyectoSoftware = :proyectoSoftwareidProyectoSoftware")
    , @NamedQuery(name = "DesarrolladorJuniorHasProyectoSoftware.findByFInicio", query = "SELECT d FROM DesarrolladorJuniorHasProyectoSoftware d WHERE d.fInicio = :fInicio")
    , @NamedQuery(name = "DesarrolladorJuniorHasProyectoSoftware.findByFFin", query = "SELECT d FROM DesarrolladorJuniorHasProyectoSoftware d WHERE d.fFin = :fFin")})
public class DesarrolladorJuniorHasProyectoSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DesarrolladorJuniorHasProyectoSoftwarePK desarrolladorJuniorHasProyectoSoftwarePK;
    @Column(name = "F_Inicio")
    @Temporal(TemporalType.DATE)
    private Date fInicio;
    @Column(name = "F_Fin")
    @Temporal(TemporalType.DATE)
    private Date fFin;
    @JoinColumn(name = "Desarrollador_Junior_idDesarrollador_Junior", referencedColumnName = "idDesarrollador_Junior", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DesarrolladorJunior desarrolladorJunior;
    @JoinColumn(name = "Proyecto_Software_idProyecto_Software", referencedColumnName = "idProyecto_Software", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProyectoSoftware proyectoSoftware;

    public DesarrolladorJuniorHasProyectoSoftware() {
    }

    public DesarrolladorJuniorHasProyectoSoftware(DesarrolladorJuniorHasProyectoSoftwarePK desarrolladorJuniorHasProyectoSoftwarePK) {
        this.desarrolladorJuniorHasProyectoSoftwarePK = desarrolladorJuniorHasProyectoSoftwarePK;
    }

    public DesarrolladorJuniorHasProyectoSoftware(int desarrolladorJunioridDesarrolladorJunior, int proyectoSoftwareidProyectoSoftware) {
        this.desarrolladorJuniorHasProyectoSoftwarePK = new DesarrolladorJuniorHasProyectoSoftwarePK(desarrolladorJunioridDesarrolladorJunior, proyectoSoftwareidProyectoSoftware);
    }

    public DesarrolladorJuniorHasProyectoSoftwarePK getDesarrolladorJuniorHasProyectoSoftwarePK() {
        return desarrolladorJuniorHasProyectoSoftwarePK;
    }

    public void setDesarrolladorJuniorHasProyectoSoftwarePK(DesarrolladorJuniorHasProyectoSoftwarePK desarrolladorJuniorHasProyectoSoftwarePK) {
        this.desarrolladorJuniorHasProyectoSoftwarePK = desarrolladorJuniorHasProyectoSoftwarePK;
    }

    public Date getFInicio() {
        return fInicio;
    }

    public void setFInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getFFin() {
        return fFin;
    }

    public void setFFin(Date fFin) {
        this.fFin = fFin;
    }

    public DesarrolladorJunior getDesarrolladorJunior() {
        return desarrolladorJunior;
    }

    public void setDesarrolladorJunior(DesarrolladorJunior desarrolladorJunior) {
        this.desarrolladorJunior = desarrolladorJunior;
    }

    public ProyectoSoftware getProyectoSoftware() {
        return proyectoSoftware;
    }

    public void setProyectoSoftware(ProyectoSoftware proyectoSoftware) {
        this.proyectoSoftware = proyectoSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desarrolladorJuniorHasProyectoSoftwarePK != null ? desarrolladorJuniorHasProyectoSoftwarePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesarrolladorJuniorHasProyectoSoftware)) {
            return false;
        }
        DesarrolladorJuniorHasProyectoSoftware other = (DesarrolladorJuniorHasProyectoSoftware) object;
        if ((this.desarrolladorJuniorHasProyectoSoftwarePK == null && other.desarrolladorJuniorHasProyectoSoftwarePK != null) || (this.desarrolladorJuniorHasProyectoSoftwarePK != null && !this.desarrolladorJuniorHasProyectoSoftwarePK.equals(other.desarrolladorJuniorHasProyectoSoftwarePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DesarrolladorJuniorHasProyectoSoftware[ desarrolladorJuniorHasProyectoSoftwarePK=" + desarrolladorJuniorHasProyectoSoftwarePK + " ]";
    }
    
}
