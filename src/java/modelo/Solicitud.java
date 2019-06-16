/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitud.findByTitulo", query = "SELECT s FROM Solicitud s WHERE s.titulo = :titulo")
    , @NamedQuery(name = "Solicitud.findByFSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fSolicitud = :fSolicitud")
    , @NamedQuery(name = "Solicitud.findByOrigen", query = "SELECT s FROM Solicitud s WHERE s.origen = :origen")
    , @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")
    , @NamedQuery(name = "Solicitud.findByPrioridadSolicitante", query = "SELECT s FROM Solicitud s WHERE s.prioridadSolicitante = :prioridadSolicitante")
    , @NamedQuery(name = "Solicitud.findByPrioridadRealizacion", query = "SELECT s FROM Solicitud s WHERE s.prioridadRealizacion = :prioridadRealizacion")
    , @NamedQuery(name = "Solicitud.findByFUltimaActualizacion", query = "SELECT s FROM Solicitud s WHERE s.fUltimaActualizacion = :fUltimaActualizacion")
    , @NamedQuery(name = "Solicitud.findByReleasee", query = "SELECT s FROM Solicitud s WHERE s.releasee = :releasee")
    , @NamedQuery(name = "Solicitud.findByEsfuerzo", query = "SELECT s FROM Solicitud s WHERE s.esfuerzo = :esfuerzo")
    , @NamedQuery(name = "Solicitud.findByDescripcion", query = "SELECT s FROM Solicitud s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Solicitud.findByComentarios", query = "SELECT s FROM Solicitud s WHERE s.comentarios = :comentarios")
    , @NamedQuery(name = "Solicitud.findByTipo", query = "SELECT s FROM Solicitud s WHERE s.tipo = :tipo")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Size(max = 20)
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "F_Solicitud")
    @Temporal(TemporalType.DATE)
    private Date fSolicitud;
    @Size(max = 20)
    @Column(name = "Origen")
    private String origen;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;
    @Size(max = 10)
    @Column(name = "Prioridad_Solicitante")
    private String prioridadSolicitante;
    @Size(max = 10)
    @Column(name = "Prioridad_Realizacion")
    private String prioridadRealizacion;
    @Column(name = "F_Ultima_Actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fUltimaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Releasee")
    private double releasee;
    @Size(max = 10)
    @Column(name = "Esfuerzo")
    private String esfuerzo;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "Comentarios")
    private String comentarios;
    @Size(max = 10)
    @Column(name = "Tipo")
    private String tipo;
    @JoinColumn(name = "Requisito_idRequisito", referencedColumnName = "idRequisito")
    @ManyToOne(optional = false)
    private Requisito requisitoidRequisito;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, double releasee) {
        this.idSolicitud = idSolicitud;
        this.releasee = releasee;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFSolicitud() {
        return fSolicitud;
    }

    public void setFSolicitud(Date fSolicitud) {
        this.fSolicitud = fSolicitud;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridadSolicitante() {
        return prioridadSolicitante;
    }

    public void setPrioridadSolicitante(String prioridadSolicitante) {
        this.prioridadSolicitante = prioridadSolicitante;
    }

    public String getPrioridadRealizacion() {
        return prioridadRealizacion;
    }

    public void setPrioridadRealizacion(String prioridadRealizacion) {
        this.prioridadRealizacion = prioridadRealizacion;
    }

    public Date getFUltimaActualizacion() {
        return fUltimaActualizacion;
    }

    public void setFUltimaActualizacion(Date fUltimaActualizacion) {
        this.fUltimaActualizacion = fUltimaActualizacion;
    }

    public double getReleasee() {
        return releasee;
    }

    public void setReleasee(double releasee) {
        this.releasee = releasee;
    }

    public String getEsfuerzo() {
        return esfuerzo;
    }

    public void setEsfuerzo(String esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Requisito getRequisitoidRequisito() {
        return requisitoidRequisito;
    }

    public void setRequisitoidRequisito(Requisito requisitoidRequisito) {
        this.requisitoidRequisito = requisitoidRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
