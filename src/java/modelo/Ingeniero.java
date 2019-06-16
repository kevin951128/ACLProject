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
@Table(name = "ingeniero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingeniero.findAll", query = "SELECT i FROM Ingeniero i")
    , @NamedQuery(name = "Ingeniero.findByCedula", query = "SELECT i FROM Ingeniero i WHERE i.cedula = :cedula")
    , @NamedQuery(name = "Ingeniero.findByNombre", query = "SELECT i FROM Ingeniero i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Ingeniero.findByApellido", query = "SELECT i FROM Ingeniero i WHERE i.apellido = :apellido")
    , @NamedQuery(name = "Ingeniero.findByCorreo", query = "SELECT i FROM Ingeniero i WHERE i.correo = :correo")
    , @NamedQuery(name = "Ingeniero.findByTelFijo", query = "SELECT i FROM Ingeniero i WHERE i.telFijo = :telFijo")
    , @NamedQuery(name = "Ingeniero.findByTelMovil", query = "SELECT i FROM Ingeniero i WHERE i.telMovil = :telMovil")
    , @NamedQuery(name = "Ingeniero.findByDireccion", query = "SELECT i FROM Ingeniero i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Ingeniero.findByFNacimiento", query = "SELECT i FROM Ingeniero i WHERE i.fNacimiento = :fNacimiento")
    , @NamedQuery(name = "Ingeniero.findByEdad", query = "SELECT i FROM Ingeniero i WHERE i.edad = :edad")
    , @NamedQuery(name = "Ingeniero.findBySexo", query = "SELECT i FROM Ingeniero i WHERE i.sexo = :sexo")
    , @NamedQuery(name = "Ingeniero.findByFIngreso", query = "SELECT i FROM Ingeniero i WHERE i.fIngreso = :fIngreso")
    , @NamedQuery(name = "Ingeniero.findByAntiguedad", query = "SELECT i FROM Ingeniero i WHERE i.antiguedad = :antiguedad")})
public class Ingeniero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "Apellido")
    private String apellido;
    @Size(max = 25)
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Tel_Fijo")
    private Integer telFijo;
    @Column(name = "Tel_Movil")
    private Integer telMovil;
    @Size(max = 20)
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "F_Nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fNacimiento;
    @Column(name = "Edad")
    private Integer edad;
    @Size(max = 10)
    @Column(name = "Sexo")
    private String sexo;
    @Column(name = "F_Ingreso")
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
    @Column(name = "Antiguedad")
    private Integer antiguedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenieroCedula")
    private List<DesarrolladorJunior> desarrolladorJuniorList;
    @JoinColumn(name = "Grados_idGrados", referencedColumnName = "idGrados")
    @ManyToOne(optional = false)
    private Grados gradosidGrados;
    @JoinColumn(name = "Capacitacion_idCapacitacion", referencedColumnName = "idCapacitacion")
    @ManyToOne(optional = false)
    private Capacitacion capacitacionidCapacitacion;
    @JoinColumn(name = "Sistema_Operativo_idSistema_Operativo", referencedColumnName = "idSistema_Operativo")
    @ManyToOne(optional = false)
    private SistemaOperativo sistemaOperativoidSistemaOperativo;
    @JoinColumn(name = "Gestor_BD_idGestor_BD", referencedColumnName = "idGestor_BD")
    @ManyToOne(optional = false)
    private GestorBd gestorBDidGestorBD;
    @JoinColumn(name = "Lenguaje_Programacion_idLenguaje_Programacion", referencedColumnName = "idLenguaje_Programacion")
    @ManyToOne(optional = false)
    private LenguajeProgramacion lenguajeProgramacionidLenguajeProgramacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenieroCedula")
    private List<JefeDesarrollo> jefeDesarrolloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingenieroCedula")
    private List<DesarrolladorSenior> desarrolladorSeniorList;

    public Ingeniero() {
    }

    public Ingeniero(Integer cedula) {
        this.cedula = cedula;
    }

    public Ingeniero(Integer cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(Integer telFijo) {
        this.telFijo = telFijo;
    }

    public Integer getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(Integer telMovil) {
        this.telMovil = telMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    @XmlTransient
    public List<DesarrolladorJunior> getDesarrolladorJuniorList() {
        return desarrolladorJuniorList;
    }

    public void setDesarrolladorJuniorList(List<DesarrolladorJunior> desarrolladorJuniorList) {
        this.desarrolladorJuniorList = desarrolladorJuniorList;
    }

    public Grados getGradosidGrados() {
        return gradosidGrados;
    }

    public void setGradosidGrados(Grados gradosidGrados) {
        this.gradosidGrados = gradosidGrados;
    }

    public Capacitacion getCapacitacionidCapacitacion() {
        return capacitacionidCapacitacion;
    }

    public void setCapacitacionidCapacitacion(Capacitacion capacitacionidCapacitacion) {
        this.capacitacionidCapacitacion = capacitacionidCapacitacion;
    }

    public SistemaOperativo getSistemaOperativoidSistemaOperativo() {
        return sistemaOperativoidSistemaOperativo;
    }

    public void setSistemaOperativoidSistemaOperativo(SistemaOperativo sistemaOperativoidSistemaOperativo) {
        this.sistemaOperativoidSistemaOperativo = sistemaOperativoidSistemaOperativo;
    }

    public GestorBd getGestorBDidGestorBD() {
        return gestorBDidGestorBD;
    }

    public void setGestorBDidGestorBD(GestorBd gestorBDidGestorBD) {
        this.gestorBDidGestorBD = gestorBDidGestorBD;
    }

    public LenguajeProgramacion getLenguajeProgramacionidLenguajeProgramacion() {
        return lenguajeProgramacionidLenguajeProgramacion;
    }

    public void setLenguajeProgramacionidLenguajeProgramacion(LenguajeProgramacion lenguajeProgramacionidLenguajeProgramacion) {
        this.lenguajeProgramacionidLenguajeProgramacion = lenguajeProgramacionidLenguajeProgramacion;
    }

    @XmlTransient
    public List<JefeDesarrollo> getJefeDesarrolloList() {
        return jefeDesarrolloList;
    }

    public void setJefeDesarrolloList(List<JefeDesarrollo> jefeDesarrolloList) {
        this.jefeDesarrolloList = jefeDesarrolloList;
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
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingeniero)) {
            return false;
        }
        Ingeniero other = (Ingeniero) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingeniero[ cedula=" + cedula + " ]";
    }
    
}
