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
public class categoriaValidation implements ValidatorP {

    @Override
    public List<String> validatePro(producto pro) {
        List<String> errores = new ArrayList<String>();
        String categoria = pro.getCategoria();
        if (categoria.isEmpty()) {
            errores.add("La categoria no puede estar vacía");
        }
        return errores;
    }

}
