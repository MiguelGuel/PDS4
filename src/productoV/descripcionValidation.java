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
public class descripcionValidation implements ValidatorP {

    @Override
    public List<String> validatePro(producto pro) {
        List<String> errores = new ArrayList<String>();
        String descripcion = pro.getDescripcion();
        if (descripcion.isEmpty()) {
            errores.add("La descripcion no puede estar vacía");
        }
        if (descripcion.length() > 50 && !descripcion.isEmpty()) {
            errores.add("La descripcion no puede ser mayor a 50 caracteres");
        }
        return errores;
    }

}
