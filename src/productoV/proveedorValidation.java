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
public class proveedorValidation implements ValidatorP {

    @Override
    public List<String> validatePro(producto pro) {
        List<String> errores = new ArrayList<String>();
        String proveedor = pro.getProveedor();
        if (proveedor.isEmpty()) {
            errores.add("El proveedor no puede estar vacío");
        }

        return errores;
    }

}
