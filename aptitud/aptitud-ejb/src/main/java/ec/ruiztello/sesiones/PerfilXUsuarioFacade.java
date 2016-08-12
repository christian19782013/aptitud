/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.sesiones;

import ec.ruiztello.entidades.PerfilXUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian
 */
@Stateless
public class PerfilXUsuarioFacade extends AbstractFacade<PerfilXUsuario> {

    @PersistenceContext(unitName = "ec.ruiztello_aptitud-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilXUsuarioFacade() {
        super(PerfilXUsuario.class);
    }
    
}
