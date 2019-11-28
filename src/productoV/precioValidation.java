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
public class precioValidation implements ValidatorP {

    @Override
    public List<String> validatePro(producto pro) {
        List<String> errores = new ArrayList<String>();
        String precio = pro.getPrecio();
        if (precio.isEmpty()) {
            errores.add("El precio es obligatorio");
        }
        if (precio.contains("abcdefghijklmnopqrstuvwxyz")) {
            errores.add("El precio debe contener solo números");
        }
        return errores;
    }

}
