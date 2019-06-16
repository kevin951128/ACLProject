/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.FaseProyecto;

/**
 *
 * @author Kevin
 */
@Stateless
public class FaseProyectoFacade extends AbstractFacade<FaseProyecto> implements FaseProyectoFacadeLocal {

    @PersistenceContext(unitName = "ACLProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FaseProyectoFacade() {
        super(FaseProyecto.class);
    }
    
}
