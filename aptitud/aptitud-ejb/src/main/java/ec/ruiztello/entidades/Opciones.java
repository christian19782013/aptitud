/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "OPCIONES")
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o")})
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OPCIONES")
    private BigDecimal idOpciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRIPCION_OPCIONES")
    private String descripcionOpciones;
    @Lob
    @Column(name = "IMAGEN_OPCIONES")
    private Serializable imagenOpciones;
    @Size(max = 1000)
    @Column(name = "URL_OPCIONES")
    private String urlOpciones;
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO")
    @ManyToOne(optional = false)
    private Modulo modulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opciones")
    private List<Menu> menuList;

    public Opciones() {
    }

    public Opciones(BigDecimal idOpciones) {
        this.idOpciones = idOpciones;
    }

    public Opciones(BigDecimal idOpciones, String descripcionOpciones) {
        this.idOpciones = idOpciones;
        this.descripcionOpciones = descripcionOpciones;
    }

    public BigDecimal getIdOpciones() {
        return idOpciones;
    }

    public void setIdOpciones(BigDecimal idOpciones) {
        this.idOpciones = idOpciones;
    }

    public String getDescripcionOpciones() {
        return descripcionOpciones;
    }

    public void setDescripcionOpciones(String descripcionOpciones) {
        this.descripcionOpciones = descripcionOpciones;
    }

    public Serializable getImagenOpciones() {
        return imagenOpciones;
    }

    public void setImagenOpciones(Serializable imagenOpciones) {
        this.imagenOpciones = imagenOpciones;
    }

    public String getUrlOpciones() {
        return urlOpciones;
    }

    public void setUrlOpciones(String urlOpciones) {
        this.urlOpciones = urlOpciones;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpciones != null ? idOpciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.idOpciones == null && other.idOpciones != null) || (this.idOpciones != null && !this.idOpciones.equals(other.idOpciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.Opciones[ idOpciones=" + idOpciones + " ]";
    }
    
}
