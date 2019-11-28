/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedorV;

import clases.proveedor;
import java.util.ArrayList;
import java.util.List;
import productoV.ValidatorP;


/**
 *
 * @author LENOVO
 */
public class proveedorValidator implements ValidatorPr{
    private final List<ValidatorPr> validators;

    public proveedorValidator(List<ValidatorPr> validators) {
        this.validators = validators;
    }

    @Override
    public List<String> validatePr(proveedor pro) {
          List<String> errores = new ArrayList<String>();
        for (ValidatorPr validator: validators) {
            errores.addAll(validator.validatePr(pro));
        }
        return errores;
    }
    
}
