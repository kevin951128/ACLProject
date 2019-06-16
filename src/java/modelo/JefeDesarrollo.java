/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "jefe_desarrollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JefeDesarrollo.findAll", query = "SELECT j FROM JefeDesarrollo j")
    , @NamedQuery(name = "JefeDesarrollo.findByIdJefeDesarrollo", query = "SELECT j FROM JefeDesarrollo j WHERE j.idJefeDesarrollo = :idJefeDesarrollo")
    , @NamedQuery(name = "JefeDesarrollo.findByPresupuesto", query = "SELECT j FROM JefeDesarrollo j WHERE j.presupuesto = :presupuesto")})
public class JefeDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJefe_Desarrollo")
    private Integer idJefeDesarrollo;
    @Column(name = "Presupuesto")
    private Integer presupuesto;
    @JoinColumn(name = "Ingeniero_Cedula", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Ingeniero ingenieroCedula;
    @JoinColumn(name = "Desarrollador_Senior_idDesarrollador_Senior", referencedColumnName = "idDesarrollador_Senior")
    @ManyToOne(optional = false)
    private DesarrolladorSenior desarrolladorSenioridDesarrolladorSenior;

    public JefeDesarrollo() {
    }

    public JefeDesarrollo(Integer idJefeDesarrollo) {
        this.idJefeDesarrollo = idJefeDesarrollo;
    }

    public Integer getIdJefeDesarrollo() {
        return idJefeDesarrollo;
    }

    public void setIdJefeDesarrollo(Integer idJefeDesarrollo) {
        this.idJefeDesarrollo = idJefeDesarrollo;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Ingeniero getIngenieroCedula() {
        return ingenieroCedula;
    }

    public void setIngenieroCedula(Ingeniero ingenieroCedula) {
        this.ingenieroCedula = ingenieroCedula;
    }

    public DesarrolladorSenior getDesarrolladorSenioridDesarrolladorSenior() {
        return desarrolladorSenioridDesarrolladorSenior;
    }

    public void setDesarrolladorSenioridDesarrolladorSenior(DesarrolladorSenior desarrolladorSenioridDesarrolladorSenior) {
        this.desarrolladorSenioridDesarrolladorSenior = desarrolladorSenioridDesarrolladorSenior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJefeDesarrollo != null ? idJefeDesarrollo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JefeDesarrollo)) {
            return false;
        }
        JefeDesarrollo other = (JefeDesarrollo) object;
        if ((this.idJefeDesarrollo == null && other.idJefeDesarrollo != null) || (this.idJefeDesarrollo != null && !this.idJefeDesarrollo.equals(other.idJefeDesarrollo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.JefeDesarrollo[ idJefeDesarrollo=" + idJefeDesarrollo + " ]";
    }
    
}
