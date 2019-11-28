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
public class celularValidation implements ValidatorPr{

    @Override
    public List<String> validatePr(proveedor pro) {
         List<String> errores = new ArrayList<String>();
         String cel = pro.getCel();
         if (cel.isEmpty()) {
            errores.add("El celular no puede quedar vacío");
        }
         if (cel.length() != 10) {
            errores.add("El número de celular debe tener 10 digitos");
        }
         return errores;
    }
    
}
