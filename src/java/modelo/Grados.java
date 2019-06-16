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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "grados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grados.findAll", query = "SELECT g FROM Grados g")
    , @NamedQuery(name = "Grados.findByIdGrados", query = "SELECT g FROM Grados g WHERE g.idGrados = :idGrados")
    , @NamedQuery(name = "Grados.findByInstitucion", query = "SELECT g FROM Grados g WHERE g.institucion = :institucion")
    , @NamedQuery(name = "Grados.findByAno", query = "SELECT g FROM Grados g WHERE g.ano = :ano")
    , @NamedQuery(name = "Grados.findByTitulo", query = "SELECT g FROM Grados g WHERE g.titulo = :titulo")
    , @NamedQuery(name = "Grados.findByTipo", query = "SELECT g FROM Grados g WHERE g.tipo = :tipo")})
public class Grados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGrados")
    private Integer idGrados;
    @Size(max = 20)
    @Column(name = "Institucion")
    private String institucion;
    @Size(max = 20)
    @Column(name = "Ano")
    private String ano;
    @Size(max = 20)
    @Column(name = "Titulo")
    private String titulo;
    @Size(max = 10)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradosidGrados")
    private List<Ingeniero> ingenieroList;

    public Grados() {
    }

    public Grados(Integer idGrados) {
        this.idGrados = idGrados;
    }

    public Integer getIdGrados() {
        return idGrados;
    }

    public void setIdGrados(Integer idGrados) {
        this.idGrados = idGrados;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idGrados != null ? idGrados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grados)) {
            return false;
        }
        Grados other = (Grados) object;
        if ((this.idGrados == null && other.idGrados != null) || (this.idGrados != null && !this.idGrados.equals(other.idGrados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Grados[ idGrados=" + idGrados + " ]";
    }
    
}
