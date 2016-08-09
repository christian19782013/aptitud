/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.aptitud_catalogos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "MODULO")
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MODULO")
    private BigDecimal idModulo;
    @Size(max = 100)
    @Column(name = "NOMBRE_MODULO")
    private String nombreModulo;
    @Lob
    @Column(name = "IMAGEN")
    private Serializable imagen;
    @Size(max = 1000)
    @Column(name = "URL_MODULO")
    private String urlModulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private List<Opciones> opcionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
    private List<Perfil> perfilList;

    public Modulo() {
    }

    public Modulo(BigDecimal idModulo) {
        this.idModulo = idModulo;
    }

    public BigDecimal getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(BigDecimal idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }

    public String getUrlModulo() {
        return urlModulo;
    }

    public void setUrlModulo(String urlModulo) {
        this.urlModulo = urlModulo;
    }

    public List<Opciones> getOpcionesList() {
        return opcionesList;
    }

    public void setOpcionesList(List<Opciones> opcionesList) {
        this.opcionesList = opcionesList;
    }

    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.aptitud_catalogos.Modulo[ idModulo=" + idModulo + " ]";
    }
    
}
