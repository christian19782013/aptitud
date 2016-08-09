/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ruiztello.aptitud_catalogos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian
 */
@Stateless
public class OpcionesFacade extends AbstractFacade<Opciones> {

    @PersistenceContext(unitName = "ec.ruiztello_aptitud_catalogos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionesFacade() {
        super(Opciones.class);
    }
    
}
