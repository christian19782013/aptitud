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
 * @author christian
 */
@Entity
@Table(name = "ORGANIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizacion.findAll", query = "SELECT o FROM Organizacion o"),
    @NamedQuery(name = "Organizacion.findByIdOrganizacion", query = "SELECT o FROM Organizacion o WHERE o.idOrganizacion = :idOrganizacion"),
    @NamedQuery(name = "Organizacion.findByRazonSocial", query = "SELECT o FROM Organizacion o WHERE o.razonSocial = :razonSocial"),
    @NamedQuery(name = "Organizacion.findByRuc", query = "SELECT o FROM Organizacion o WHERE o.ruc = :ruc"),
    @NamedQuery(name = "Organizacion.findByDireccion", query = "SELECT o FROM Organizacion o WHERE o.direccion = :direccion"),
    @NamedQuery(name = "Organizacion.findByTelefono", query = "SELECT o FROM Organizacion o WHERE o.telefono = :telefono"),
    @NamedQuery(name = "Organizacion.findByMail", query = "SELECT o FROM Organizacion o WHERE o.mail = :mail"),
    @NamedQuery(name = "Organizacion.findBySitioWeb", query = "SELECT o FROM Organizacion o WHERE o.sitioWeb = :sitioWeb")})
public class Organizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORGANIZACION")
    private BigDecimal idOrganizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 40)
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 2000)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 200)
    @Column(name = "MAIL")
    private String mail;
    @Size(max = 1000)
    @Column(name = "SITIO_WEB")
    private String sitioWeb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizacion")
    private List<UsuarioXOrganizacion> usuarioXOrganizacionList;

    public Organizacion() {
    }

    public Organizacion(BigDecimal idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Organizacion(BigDecimal idOrganizacion, String razonSocial) {
        this.idOrganizacion = idOrganizacion;
        this.razonSocial = razonSocial;
    }

    public BigDecimal getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(BigDecimal idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    @XmlTransient
    public List<UsuarioXOrganizacion> getUsuarioXOrganizacionList() {
        return usuarioXOrganizacionList;
    }

    public void setUsuarioXOrganizacionList(List<UsuarioXOrganizacion> usuarioXOrganizacionList) {
        this.usuarioXOrganizacionList = usuarioXOrganizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganizacion != null ? idOrganizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizacion)) {
            return false;
        }
        Organizacion other = (Organizacion) object;
        if ((this.idOrganizacion == null && other.idOrganizacion != null) || (this.idOrganizacion != null && !this.idOrganizacion.equals(other.idOrganizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.ruiztello.entidades.Organizacion[ idOrganizacion=" + idOrganizacion + " ]";
    }
    
}
