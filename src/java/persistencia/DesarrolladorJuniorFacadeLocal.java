/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.DesarrolladorJunior;

/**
 *
 * @author Kevin
 */
@Local
public interface DesarrolladorJuniorFacadeLocal {

    void create(DesarrolladorJunior desarrolladorJunior);

    void edit(DesarrolladorJunior desarrolladorJunior);

    void remove(DesarrolladorJunior desarrolladorJunior);

    DesarrolladorJunior find(Object id);

    List<DesarrolladorJunior> findAll();

    List<DesarrolladorJunior> findRange(int[] range);

    int count();
    
}
