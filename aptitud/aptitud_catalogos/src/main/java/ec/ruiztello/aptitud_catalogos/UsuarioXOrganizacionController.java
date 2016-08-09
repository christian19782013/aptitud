package ec.ruiztello.aptitud_catalogos;

import ec.ruiztello.aptitud_catalogos.util.JsfUtil;
import ec.ruiztello.aptitud_catalogos.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("usuarioXOrganizacionController")
@SessionScoped
public class UsuarioXOrganizacionController implements Serializable {

    @EJB
    private ec.ruiztello.aptitud_catalogos.UsuarioXOrganizacionFacade ejbFacade;
    private List<UsuarioXOrganizacion> items = null;
    private UsuarioXOrganizacion selected;

    public UsuarioXOrganizacionController() {
    }

    public UsuarioXOrganizacion getSelected() {
        return selected;
    }

    public void setSelected(UsuarioXOrganizacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioXOrganizacionFacade getFacade() {
        return ejbFacade;
    }

    public UsuarioXOrganizacion prepareCreate() {
        selected = new UsuarioXOrganizacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle01").getString("UsuarioXOrganizacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle01").getString("UsuarioXOrganizacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle01").getString("UsuarioXOrganizacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<UsuarioXOrganizacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle01").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle01").getString("PersistenceErrorOccured"));
            }
        }
    }

    public UsuarioXOrganizacion getUsuarioXOrganizacion(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<UsuarioXOrganizacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<UsuarioXOrganizacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = UsuarioXOrganizacion.class)
    public static class UsuarioXOrganizacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioXOrganizacionController controller = (UsuarioXOrganizacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioXOrganizacionController");
            return controller.getUsuarioXOrganizacion(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof UsuarioXOrganizacion) {
                UsuarioXOrganizacion o = (UsuarioXOrganizacion) object;
                return getStringKey(o.getIdUsuOrg());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), UsuarioXOrganizacion.class.getName()});
                return null;
            }
        }

    }

}
