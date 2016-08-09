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

@Named("perfilXUsuarioController")
@SessionScoped
public class PerfilXUsuarioController implements Serializable {

    @EJB
    private ec.ruiztello.aptitud_catalogos.PerfilXUsuarioFacade ejbFacade;
    private List<PerfilXUsuario> items = null;
    private PerfilXUsuario selected;

    public PerfilXUsuarioController() {
    }

    public PerfilXUsuario getSelected() {
        return selected;
    }

    public void setSelected(PerfilXUsuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PerfilXUsuarioFacade getFacade() {
        return ejbFacade;
    }

    public PerfilXUsuario prepareCreate() {
        selected = new PerfilXUsuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle01").getString("PerfilXUsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle01").getString("PerfilXUsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle01").getString("PerfilXUsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PerfilXUsuario> getItems() {
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

    public PerfilXUsuario getPerfilXUsuario(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<PerfilXUsuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PerfilXUsuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PerfilXUsuario.class)
    public static class PerfilXUsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PerfilXUsuarioController controller = (PerfilXUsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "perfilXUsuarioController");
            return controller.getPerfilXUsuario(getKey(value));
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
            if (object instanceof PerfilXUsuario) {
                PerfilXUsuario o = (PerfilXUsuario) object;
                return getStringKey(o.getIdPerfUsu());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PerfilXUsuario.class.getName()});
                return null;
            }
        }

    }

}
