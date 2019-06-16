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
@Table(name = "desarrollador_junior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesarrolladorJunior.findAll", query = "SELECT d FROM DesarrolladorJunior d")
    , @NamedQuery(name = "DesarrolladorJunior.findByIdDesarrolladorJunior", query = "SELECT d FROM DesarrolladorJunior d WHERE d.idDesarrolladorJunior = :idDesarrolladorJunior")
    , @NamedQuery(name = "DesarrolladorJunior.findByHorasDia", query = "SELECT d FROM DesarrolladorJunior d WHERE d.horasDia = :horasDia")})
public class DesarrolladorJunior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDesarrollador_Junior")
    private Integer idDesarrolladorJunior;
    @Column(name = "Horas_Dia")
    private Integer horasDia;
    @JoinColumn(name = "Ingeniero_Cedula", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Ingeniero ingenieroCedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desarrolladorJunior")
    private List<DesarrolladorJuniorHasProyectoSoftware> desarrolladorJuniorHasProyectoSoftwareList;

    public DesarrolladorJunior() {
    }

    public DesarrolladorJunior(Integer idDesarrolladorJunior) {
        this.idDesarrolladorJunior = idDesarrolladorJunior;
    }

    public Integer getIdDesarrolladorJunior() {
        return idDesarrolladorJunior;
    }

    public void setIdDesarrolladorJunior(Integer idDesarrolladorJunior) {
        this.idDesarrolladorJunior = idDesarrolladorJunior;
    }

    public Integer getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(Integer horasDia) {
        this.horasDia = horasDia;
    }

    public Ingeniero getIngenieroCedula() {
        return ingenieroCedula;
    }

    public void setIngenieroCedula(Ingeniero ingenieroCedula) {
        this.ingenieroCedula = ingenieroCedula;
    }

    @XmlTransient
    public List<DesarrolladorJuniorHasProyectoSoftware> getDesarrolladorJuniorHasProyectoSoftwareList() {
        return desarrolladorJuniorHasProyectoSoftwareList;
    }

    public void setDesarrolladorJuniorHasProyectoSoftwareList(List<DesarrolladorJuniorHasProyectoSoftware> desarrolladorJuniorHasProyectoSoftwareList) {
        this.desarrolladorJuniorHasProyectoSoftwareList = desarrolladorJuniorHasProyectoSoftwareList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesarrolladorJunior != null ? idDesarrolladorJunior.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesarrolladorJunior)) {
            return false;
        }
        DesarrolladorJunior other = (DesarrolladorJunior) object;
        if ((this.idDesarrolladorJunior == null && other.idDesarrolladorJunior != null) || (this.idDesarrolladorJunior != null && !this.idDesarrolladorJunior.equals(other.idDesarrolladorJunior))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DesarrolladorJunior[ idDesarrolladorJunior=" + idDesarrolladorJunior + " ]";
    }
    
}
