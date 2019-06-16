/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.JefeDesarrollo;

/**
 *
 * @author Kevin
 */
@Local
public interface JefeDesarrolloFacadeLocal {

    void create(JefeDesarrollo jefeDesarrollo);

    void edit(JefeDesarrollo jefeDesarrollo);

    void remove(JefeDesarrollo jefeDesarrollo);

    JefeDesarrollo find(Object id);

    List<JefeDesarrollo> findAll();

    List<JefeDesarrollo> findRange(int[] range);

    int count();
    
}
