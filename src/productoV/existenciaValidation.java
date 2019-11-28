/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productoV;

import clases.producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class existenciaValidation implements ValidatorP{

    @Override
    public List<String> validatePro(producto pro) {
       List<String> errores = new ArrayList<String>();
       String existencia = pro.getExistencia();
       
        if (existencia.isEmpty()) {
            errores.add("La existencia no puede ir vacía");
        }
        if (existencia.contains("-")) {
            errores.add("La existencia no puede ser negativa");
        }
        if (existencia.contains("abcdefghijklmnopqrstuvwxyz")) {
            errores.add("La existencia debe ser solo números");
        }
       return errores;
    }
    
}
