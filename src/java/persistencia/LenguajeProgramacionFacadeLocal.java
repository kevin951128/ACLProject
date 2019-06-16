/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.LenguajeProgramacion;

/**
 *
 * @author Kevin
 */
@Local
public interface LenguajeProgramacionFacadeLocal {

    void create(LenguajeProgramacion lenguajeProgramacion);

    void edit(LenguajeProgramacion lenguajeProgramacion);

    void remove(LenguajeProgramacion lenguajeProgramacion);

    LenguajeProgramacion find(Object id);

    List<LenguajeProgramacion> findAll();

    List<LenguajeProgramacion> findRange(int[] range);

    int count();
    
}
