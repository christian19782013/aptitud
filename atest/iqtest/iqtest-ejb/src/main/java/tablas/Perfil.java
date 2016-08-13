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
import javax.validation.constraints.Size;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "PERFIL")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL")
    private BigDecimal idPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_PERFIL")
    private String nombrePerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "DESCRIPCION_PERFIL")
    private String descripcionPerfil;
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO")
    @ManyToOne(optional = false)
    private Modulo modulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Menu> menuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilXUsuario> perfilXUsuarioList;

    public Perfil() {
    }

    public Perfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(BigDecimal idPerfil, String nombrePerfil, String descripcionPerfil) {
        this.idPerfil = idPerfil;
        this.nombrePerfil = nombrePerfil;
        this.descripcionPerfil = descripcionPerfil;
    }

    public BigDecimal getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
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

    public List<PerfilXUsuario> getPerfilXUsuarioList() {
        return perfilXUsuarioList;
    }

    public void setPerfilXUsuarioList(List<PerfilXUsuario> perfilXUsuarioList) {
        this.perfilXUsuarioList = perfilXUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
