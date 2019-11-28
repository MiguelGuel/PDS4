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
public class contactoValidation implements ValidatorPr{

    @Override
    public List<String> validatePr(proveedor pro) {
      List<String> errores = new ArrayList<String>();
         String contacto = pro.getContacto();
         if (contacto.isEmpty()) {
            errores.add("El nombre del contacto no puede quedar vacío");
        }
         if (contacto.length() > 50 && !contacto.isEmpty()) {
            errores.add("El nombre del contacto no puede ser mayor a 50 caracteres");
        }
         return errores;
    }
    
}
