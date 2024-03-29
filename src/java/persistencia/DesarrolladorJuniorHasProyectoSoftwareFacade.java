/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.DesarrolladorJuniorHasProyectoSoftware;

/**
 *
 * @author Kevin
 */
@Stateless
public class DesarrolladorJuniorHasProyectoSoftwareFacade extends AbstractFacade<DesarrolladorJuniorHasProyectoSoftware> implements DesarrolladorJuniorHasProyectoSoftwareFacadeLocal {

    @PersistenceContext(unitName = "ACLProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DesarrolladorJuniorHasProyectoSoftwareFacade() {
        super(DesarrolladorJuniorHasProyectoSoftware.class);
    }
    
}
