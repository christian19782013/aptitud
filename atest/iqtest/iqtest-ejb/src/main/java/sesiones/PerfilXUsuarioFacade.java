/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tablas.PerfilXUsuario;

/**
 *
 * @author christian
 */
@Stateless
public class PerfilXUsuarioFacade extends AbstractFacade<PerfilXUsuario> {

    @PersistenceContext(unitName = "ec.ruiztello_iqtest-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilXUsuarioFacade() {
        super(PerfilXUsuario.class);
    }
    
}
