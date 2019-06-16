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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "proyecto_software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoSoftware.findAll", query = "SELECT p FROM ProyectoSoftware p")
    , @NamedQuery(name = "ProyectoSoftware.findByIdProyectoSoftware", query = "SELECT p FROM ProyectoSoftware p WHERE p.idProyectoSoftware = :idProyectoSoftware")
    , @NamedQuery(name = "ProyectoSoftware.findByAreaAplicacion", query = "SELECT p FROM ProyectoSoftware p WHERE p.areaAplicacion = :areaAplicacion")
    , @NamedQuery(name = "ProyectoSoftware.findByFRegistro", query = "SELECT p FROM ProyectoSoftware p WHERE p.fRegistro = :fRegistro")
    , @NamedQuery(name = "ProyectoSoftware.findByFAsignacion", query = "SELECT p FROM ProyectoSoftware p WHERE p.fAsignacion = :fAsignacion")
    , @NamedQuery(name = "ProyectoSoftware.findByFPrevistaLiberacion", query = "SELECT p FROM ProyectoSoftware p WHERE p.fPrevistaLiberacion = :fPrevistaLiberacion")
    , @NamedQuery(name = "ProyectoSoftware.findByVersion", query = "SELECT p FROM ProyectoSoftware p WHERE p.version = :version")
    , @NamedQuery(name = "ProyectoSoftware.findByCosto", query = "SELECT p FROM ProyectoSoftware p WHERE p.costo = :costo")})
public class ProyectoSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProyecto_Software")
    private Integer idProyectoSoftware;
    @Size(max = 20)
    @Column(name = "Area_Aplicacion")
    private String areaAplicacion;
    @Column(name = "F_Registro")
    @Temporal(TemporalType.DATE)
    private Date fRegistro;
    @Column(name = "F_Asignacion")
    @Temporal(TemporalType.DATE)
    private Date fAsignacion;
    @Column(name = "F_Prevista_Liberacion")
    @Temporal(TemporalType.DATE)
    private Date fPrevistaLiberacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Version")
    private Double version;
    @Column(name = "Costo")
    private Integer costo;
    @ManyToMany(mappedBy = "proyectoSoftwareList")
    private List<FaseProyecto> faseProyectoList;
    @ManyToMany(mappedBy = "proyectoSoftwareList")
    private List<GestorBd> gestorBdList;
    @ManyToMany(mappedBy = "proyectoSoftwareList")
    private List<LenguajeProgramacion> lenguajeProgramacionList;
    @ManyToMany(mappedBy = "proyectoSoftwareList")
    private List<SistemaOperativo> sistemaOperativoList;
    @JoinColumn(name = "Requisito_idRequisito", referencedColumnName = "idRequisito")
    @ManyToOne(optional = false)
    private Requisito requisitoidRequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectoSoftware")
    private List<DesarrolladorJuniorHasProyectoSoftware> desarrolladorJuniorHasProyectoSoftwareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectoSoftwareidProyectoSoftware")
    private List<DesarrolladorSenior> desarrolladorSeniorList;

    public ProyectoSoftware() {
    }

    public ProyectoSoftware(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public Integer getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public String getAreaAplicacion() {
        return areaAplicacion;
    }

    public void setAreaAplicacion(String areaAplicacion) {
        this.areaAplicacion = areaAplicacion;
    }

    public Date getFRegistro() {
        return fRegistro;
    }

    public void setFRegistro(Date fRegistro) {
        this.fRegistro = fRegistro;
    }

    public Date getFAsignacion() {
        return fAsignacion;
    }

    public void setFAsignacion(Date fAsignacion) {
        this.fAsignacion = fAsignacion;
    }

    public Date getFPrevistaLiberacion() {
        return fPrevistaLiberacion;
    }

    public void setFPrevistaLiberacion(Date fPrevistaLiberacion) {
        this.fPrevistaLiberacion = fPrevistaLiberacion;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<FaseProyecto> getFaseProyectoList() {
        return faseProyectoList;
    }

    public void setFaseProyectoList(List<FaseProyecto> faseProyectoList) {
        this.faseProyectoList = faseProyectoList;
    }

    @XmlTransient
    public List<GestorBd> getGestorBdList() {
        return gestorBdList;
    }

    public void setGestorBdList(List<GestorBd> gestorBdList) {
        this.gestorBdList = gestorBdList;
    }

    @XmlTransient
    public List<LenguajeProgramacion> getLenguajeProgramacionList() {
        return lenguajeProgramacionList;
    }

    public void setLenguajeProgramacionList(List<LenguajeProgramacion> lenguajeProgramacionList) {
        this.lenguajeProgramacionList = lenguajeProgramacionList;
    }

    @XmlTransient
    public List<SistemaOperativo> getSistemaOperativoList() {
        return sistemaOperativoList;
    }

    public void setSistemaOperativoList(List<SistemaOperativo> sistemaOperativoList) {
        this.sistemaOperativoList = sistemaOperativoList;
    }

    public Requisito getRequisitoidRequisito() {
        return requisitoidRequisito;
    }

    public void setRequisitoidRequisito(Requisito requisitoidRequisito) {
        this.requisitoidRequisito = requisitoidRequisito;
    }

    @XmlTransient
    public List<DesarrolladorJuniorHasProyectoSoftware> getDesarrolladorJuniorHasProyectoSoftwareList() {
        return desarrolladorJuniorHasProyectoSoftwareList;
    }

    public void setDesarrolladorJuniorHasProyectoSoftwareList(List<DesarrolladorJuniorHasProyectoSoftware> desarrolladorJuniorHasProyectoSoftwareList) {
        this.desarrolladorJuniorHasProyectoSoftwareList = desarrolladorJuniorHasProyectoSoftwareList;
    }

    @XmlTransient
    public List<DesarrolladorSenior> getDesarrolladorSeniorList() {
        return desarrolladorSeniorList;
    }

    public void setDesarrolladorSeniorList(List<DesarrolladorSenior> desarrolladorSeniorList) {
        this.desarrolladorSeniorList = desarrolladorSeniorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoSoftware != null ? idProyectoSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoSoftware)) {
            return false;
        }
        ProyectoSoftware other = (ProyectoSoftware) object;
        if ((this.idProyectoSoftware == null && other.idProyectoSoftware != null) || (this.idProyectoSoftware != null && !this.idProyectoSoftware.equals(other.idProyectoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectoSoftware[ idProyectoSoftware=" + idProyectoSoftware + " ]";
    }
    
}
