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
@Table(name = "PERFIL_X_USUARIO")
@NamedQueries({
    @NamedQuery(name = "PerfilXUsuario.findAll", query = "SELECT p FROM PerfilXUsuario p")})
public class PerfilXUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERF_USU")
    private BigDecimal idPerfUsu;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public PerfilXUsuario() {
    }

    public PerfilXUsuario(BigDecimal idPerfUsu) {
        this.idPerfUsu = idPerfUsu;
    }

    public BigDecimal getIdPerfUsu() {
        return idPerfUsu;
    }

    public void setIdPerfUsu(BigDecimal idPerfUsu) {
        this.idPerfUsu = idPerfUsu;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
        hash += (idPerfUsu != null ? idPerfUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilXUsuario)) {
            return false;
        }
        PerfilXUsuario other = (PerfilXUsuario) object;
        if ((this.idPerfUsu == null && other.idPerfUsu != null) || (this.idPerfUsu != null && !this.idPerfUsu.equals(other.idPerfUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.aptitud_catalogos.PerfilXUsuario[ idPerfUsu=" + idPerfUsu + " ]";
    }
    
}
