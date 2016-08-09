/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.sessiobBeans;

import ec.ruiztello.entidades.Perfil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian
 */
@Stateless
public class PerfilFacade extends AbstractFacade<Perfil> {

    @PersistenceContext(unitName = "ec.ruiztello_aptitud-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilFacade() {
        super(Perfil.class);
    }
    
}
