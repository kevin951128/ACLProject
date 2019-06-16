/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.DesarrolladorSenior;

/**
 *
 * @author Kevin
 */
@Local
public interface DesarrolladorSeniorFacadeLocal {

    void create(DesarrolladorSenior desarrolladorSenior);

    void edit(DesarrolladorSenior desarrolladorSenior);

    void remove(DesarrolladorSenior desarrolladorSenior);

    DesarrolladorSenior find(Object id);

    List<DesarrolladorSenior> findAll();

    List<DesarrolladorSenior> findRange(int[] range);

    int count();
    
}
