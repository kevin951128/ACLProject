/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.JefeDesarrollo;

/**
 *
 * @author Kevin
 */
@Stateless
public class JefeDesarrolloFacade extends AbstractFacade<JefeDesarrollo> implements JefeDesarrolloFacadeLocal {

    @PersistenceContext(unitName = "ACLProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JefeDesarrolloFacade() {
        super(JefeDesarrollo.class);
    }
    
}
