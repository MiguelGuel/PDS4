/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedorV;

import clases.proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class nombrePValidation implements ValidatorPr{

    @Override
    public List<String> validatePr(proveedor pro) {
         List<String> errores = new ArrayList<String>();
         String nombre = pro.getNombre();
         if (nombre.isEmpty()) {
            errores.add("El nombre del proveedor no puede quedar vacío");
        }
         if (nombre.length() > 50 && !nombre.isEmpty()) {
            errores.add("El nombre del proveedor no puede ser mayor a 50 caracteres");
        }
         return errores;
    }
    
}
