/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "CATALOGOS")
@NamedQueries({
    @NamedQuery(name = "Catalogos.findAll", query = "SELECT c FROM Catalogos c")})
public class Catalogos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATALOGO")
    private BigDecimal idCatalogo;
    @Size(max = 2000)
    @Column(name = "DESCRIPCION_CATALOGO")
    private String descripcionCatalogo;
    @OneToMany(mappedBy = "catalogos")
    private List<Catalogos> catalogosList;
    @JoinColumn(name = "ID_CATALOGO_FK", referencedColumnName = "ID_CATALOGO")
    @ManyToOne
    private Catalogos catalogos;
    @OneToMany(mappedBy = "catalogos")
    private List<Usuario> usuarioList;

    public Catalogos() {
    }

    public Catalogos(BigDecimal idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public BigDecimal getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(BigDecimal idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getDescripcionCatalogo() {
        return descripcionCatalogo;
    }

    public void setDescripcionCatalogo(String descripcionCatalogo) {
        this.descripcionCatalogo = descripcionCatalogo;
    }

    public List<Catalogos> getCatalogosList() {
        return catalogosList;
    }

    public void setCatalogosList(List<Catalogos> catalogosList) {
        this.catalogosList = catalogosList;
    }

    public Catalogos getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(Catalogos catalogos) {
        this.catalogos = catalogos;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatalogo != null ? idCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogos)) {
            return false;
        }
        Catalogos other = (Catalogos) object;
        if ((this.idCatalogo == null && other.idCatalogo != null) || (this.idCatalogo != null && !this.idCatalogo.equals(other.idCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.Catalogos[ idCatalogo=" + idCatalogo + " ]";
    }
    
}
