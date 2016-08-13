/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personales;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sesiones.CatalogosFacade;
import tablas.Catalogos;
import tablas.Catalogos_;
import tablas.Usuario;
import tablas.Usuario_;

/**
 *
 * @author christian
 */
@Stateless
@LocalBean
public class ReglasNegocio1 {

    @EJB
    private CatalogosFacade catalogosFacade;

    @PersistenceContext(unitName = "ec.ruiztello_iqtest-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }


    public List<Usuario> findPorCedula(String par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> root = cq.from(Usuario.class);
        cq.where(cb.equal(root.get(Usuario_.dni), par.toUpperCase().trim()));
        List resultList = em.createQuery(cq).setMaxResults(20).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

    public List<Catalogos> findGenero() {
        Catalogos c = new Catalogos();
        c = catalogosFacade.find(new BigDecimal("1"));
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Catalogos> cq = cb.createQuery(Catalogos.class);
        Root<Catalogos> root = cq.from(Catalogos.class);
        cq.where(cb.equal(root.get(Catalogos_.catalogos), c));
        List resultList = em.createQuery(cq).setMaxResults(20).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

}
