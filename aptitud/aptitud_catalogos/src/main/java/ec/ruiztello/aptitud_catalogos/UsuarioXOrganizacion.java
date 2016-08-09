/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.aptitud_catalogos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "USUARIO_X_ORGANIZACION")
@NamedQueries({
    @NamedQuery(name = "UsuarioXOrganizacion.findAll", query = "SELECT u FROM UsuarioXOrganizacion u")})
public class UsuarioXOrganizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USU_ORG")
    private BigDecimal idUsuOrg;
    @JoinColumn(name = "ID_ORGANIZACION", referencedColumnName = "ID_ORGANIZACION")
    @ManyToOne(optional = false)
    private Organizacion organizacion;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioXOrganizacion() {
    }

    public UsuarioXOrganizacion(BigDecimal idUsuOrg) {
        this.idUsuOrg = idUsuOrg;
    }

    public BigDecimal getIdUsuOrg() {
        return idUsuOrg;
    }

    public void setIdUsuOrg(BigDecimal idUsuOrg) {
        this.idUsuOrg = idUsuOrg;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuOrg != null ? idUsuOrg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioXOrganizacion)) {
            return false;
        }
        UsuarioXOrganizacion other = (UsuarioXOrganizacion) object;
        if ((this.idUsuOrg == null && other.idUsuOrg != null) || (this.idUsuOrg != null && !this.idUsuOrg.equals(other.idUsuOrg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.aptitud_catalogos.UsuarioXOrganizacion[ idUsuOrg=" + idUsuOrg + " ]";
    }
    
}
