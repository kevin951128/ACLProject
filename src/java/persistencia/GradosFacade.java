/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Grados;

/**
 *
 * @author Kevin
 */
@Stateless
public class GradosFacade extends AbstractFacade<Grados> implements GradosFacadeLocal {

    @PersistenceContext(unitName = "ACLProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradosFacade() {
        super(Grados.class);
    }
    
}
