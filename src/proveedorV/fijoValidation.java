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
public class fijoValidation implements ValidatorPr{

    @Override
    public List<String> validatePr(proveedor pro) {
         List<String> errores = new ArrayList<String>();
         String fijo = pro.getFijo();
         if (fijo.isEmpty()) {
            errores.add("El número fijo no puede quedar vacío");
        }
         if (fijo.length() != 10) {
            errores.add("El número fijo debe tener 10 digitos");
        }
         return errores;
    }
    
}
