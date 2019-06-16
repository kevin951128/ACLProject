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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "capacitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c")
    , @NamedQuery(name = "Capacitacion.findByIdCapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.idCapacitacion = :idCapacitacion")
    , @NamedQuery(name = "Capacitacion.findByNombre", query = "SELECT c FROM Capacitacion c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Capacitacion.findByLugar", query = "SELECT c FROM Capacitacion c WHERE c.lugar = :lugar")
    , @NamedQuery(name = "Capacitacion.findByFInicio", query = "SELECT c FROM Capacitacion c WHERE c.fInicio = :fInicio")
    , @NamedQuery(name = "Capacitacion.findByFFinal", query = "SELECT c FROM Capacitacion c WHERE c.fFinal = :fFinal")})
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCapacitacion")
    private Integer idCapacitacion;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "Lugar")
    private String lugar;
    @Column(name = "F_Inicio")
    @Temporal(TemporalType.DATE)
    private Date fInicio;
    @Column(name = "F_Final")
    @Temporal(TemporalType.DATE)
    private Date fFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacionidCapacitacion")
    private List<Ingeniero> ingenieroList;

    public Capacitacion() {
    }

    public Capacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFInicio() {
        return fInicio;
    }

    public void setFInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getFFinal() {
        return fFinal;
    }

    public void setFFinal(Date fFinal) {
        this.fFinal = fFinal;
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
        hash += (idCapacitacion != null ? idCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.idCapacitacion == null && other.idCapacitacion != null) || (this.idCapacitacion != null && !this.idCapacitacion.equals(other.idCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Capacitacion[ idCapacitacion=" + idCapacitacion + " ]";
    }
    
}
