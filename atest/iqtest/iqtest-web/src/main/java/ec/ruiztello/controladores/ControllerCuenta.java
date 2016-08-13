/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.controladores;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import personales.ReglasNegocio1;
import sesiones.CatalogosFacade;
import sesiones.UsuarioFacade;
import tablas.Catalogos;
import tablas.Usuario;

/**
 *
 * @author christian
 */
@Named(value = "controllerCuenta")
@ViewScoped
public class ControllerCuenta implements Serializable {

    @EJB
    private ReglasNegocio1 reglasNegocio1;

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private CatalogosFacade catalogosFacade;

    private List<Catalogos> catalogoses = new ArrayList<>();

    public List<Usuario> findPorCedula(String par) {
        return reglasNegocio1.findPorCedula(par);
    }

    private String clave2 = "";

    /**
     * Creates a new instance of ControllerCuenta
     */
    public ControllerCuenta() {
        usua.setFechaCreacion(new Date());
    }

    private Usuario usua = new Usuario();

//    private static final Logger LOG = Logger.getLogger(UsuarioController.class.getName());
    public void buttonActionLimpiar(ActionEvent actionEvent) {
        usua = new Usuario();

    }

    public void buttonAction(ActionEvent actionEvent) {

        List<Usuario> usuarios;
        usuarios = new ArrayList<>();

        usuarios = findPorCedula(usua.getDni());

        usua.setApellidos(usua.getApellidos().toUpperCase().trim());
        usua.setNombres(usua.getNombres().toUpperCase().trim());
        usua.setDni(usua.getDni().toUpperCase().trim());
        usua.setEmail(usua.getEmail().trim());
        usua.setFechaCreacion(new Date());

        if (!usuarios.isEmpty()) {

            addMessage(java.util.ResourceBundle.getBundle("newproperties").getString("existe"));
        } else //se debe validar que el ingreso de la clave sea la misma dos veces
         if (clave2.equalsIgnoreCase(usua.getClave()) == true) {
                usua.setIdUsuario(BigDecimal.ZERO);

                usuarioFacade.create(getUsua());
                setUsua(new Usuario());
                addMessage(java.util.ResourceBundle.getBundle("newproperties").getString("USU_OK"));
            } else {

                addMessage(java.util.ResourceBundle.getBundle("newproperties").getString("clave"));
            }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the usua
     */
    public Usuario getUsua() {
        return usua;
    }

    /**
     * @param usua the usua to set
     */
    public void setUsua(Usuario usua) {
        this.usua = usua;
    }

    /**
     * @return the clave2
     */
    public String getClave2() {
        return clave2;
    }

    /**
     * @param clave2 the clave2 to set
     */
    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    /**
     * @return the catalogoses
     */
    public List<Catalogos> getCatalogoses() {
        catalogoses = reglasNegocio1.findGenero();
        return catalogoses;
    }

}
