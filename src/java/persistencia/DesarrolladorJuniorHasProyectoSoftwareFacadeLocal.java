/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.DesarrolladorJuniorHasProyectoSoftware;

/**
 *
 * @author Kevin
 */
@Local
public interface DesarrolladorJuniorHasProyectoSoftwareFacadeLocal {

    void create(DesarrolladorJuniorHasProyectoSoftware desarrolladorJuniorHasProyectoSoftware);

    void edit(DesarrolladorJuniorHasProyectoSoftware desarrolladorJuniorHasProyectoSoftware);

    void remove(DesarrolladorJuniorHasProyectoSoftware desarrolladorJuniorHasProyectoSoftware);

    DesarrolladorJuniorHasProyectoSoftware find(Object id);

    List<DesarrolladorJuniorHasProyectoSoftware> findAll();

    List<DesarrolladorJuniorHasProyectoSoftware> findRange(int[] range);

    int count();
    
}
