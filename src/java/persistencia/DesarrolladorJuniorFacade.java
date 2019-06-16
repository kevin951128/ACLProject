/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.DesarrolladorJunior;

/**
 *
 * @author Kevin
 */
@Stateless
public class DesarrolladorJuniorFacade extends AbstractFacade<DesarrolladorJunior> implements DesarrolladorJuniorFacadeLocal {

    @PersistenceContext(unitName = "ACLProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DesarrolladorJuniorFacade() {
        super(DesarrolladorJunior.class);
    }
    
}
