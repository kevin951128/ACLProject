/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kevin
 */
@Embeddable
public class DesarrolladorJuniorHasProyectoSoftwarePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Desarrollador_Junior_idDesarrollador_Junior")
    private int desarrolladorJunioridDesarrolladorJunior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Proyecto_Software_idProyecto_Software")
    private int proyectoSoftwareidProyectoSoftware;

    public DesarrolladorJuniorHasProyectoSoftwarePK() {
    }

    public DesarrolladorJuniorHasProyectoSoftwarePK(int desarrolladorJunioridDesarrolladorJunior, int proyectoSoftwareidProyectoSoftware) {
        this.desarrolladorJunioridDesarrolladorJunior = desarrolladorJunioridDesarrolladorJunior;
        this.proyectoSoftwareidProyectoSoftware = proyectoSoftwareidProyectoSoftware;
    }

    public int getDesarrolladorJunioridDesarrolladorJunior() {
        return desarrolladorJunioridDesarrolladorJunior;
    }

    public void setDesarrolladorJunioridDesarrolladorJunior(int desarrolladorJunioridDesarrolladorJunior) {
        this.desarrolladorJunioridDesarrolladorJunior = desarrolladorJunioridDesarrolladorJunior;
    }

    public int getProyectoSoftwareidProyectoSoftware() {
        return proyectoSoftwareidProyectoSoftware;
    }

    public void setProyectoSoftwareidProyectoSoftware(int proyectoSoftwareidProyectoSoftware) {
        this.proyectoSoftwareidProyectoSoftware = proyectoSoftwareidProyectoSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) desarrolladorJunioridDesarrolladorJunior;
        hash += (int) proyectoSoftwareidProyectoSoftware;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesarrolladorJuniorHasProyectoSoftwarePK)) {
            return false;
        }
        DesarrolladorJuniorHasProyectoSoftwarePK other = (DesarrolladorJuniorHasProyectoSoftwarePK) object;
        if (this.desarrolladorJunioridDesarrolladorJunior != other.desarrolladorJunioridDesarrolladorJunior) {
            return false;
        }
        if (this.proyectoSoftwareidProyectoSoftware != other.proyectoSoftwareidProyectoSoftware) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DesarrolladorJuniorHasProyectoSoftwarePK[ desarrolladorJunioridDesarrolladorJunior=" + desarrolladorJunioridDesarrolladorJunior + ", proyectoSoftwareidProyectoSoftware=" + proyectoSoftwareidProyectoSoftware + " ]";
    }
    
}
