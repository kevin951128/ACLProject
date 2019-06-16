/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GestorBd;

/**
 *
 * @author Kevin
 */
@Local
public interface GestorBdFacadeLocal {

    void create(GestorBd gestorBd);

    void edit(GestorBd gestorBd);

    void remove(GestorBd gestorBd);

    GestorBd find(Object id);

    List<GestorBd> findAll();

    List<GestorBd> findRange(int[] range);

    int count();
    
}
