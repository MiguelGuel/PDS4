/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productoV;

import categoriaV.ValidatorC;
import clases.producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class productoValidator implements ValidatorP{
    private final List<ValidatorP> validators;

    public productoValidator(List<ValidatorP> validators) {
        this.validators = validators;
    }

    @Override
    public List<String> validatePro(producto pro) {
        List<String> errores = new ArrayList<String>();
        for (ValidatorP validator: validators) {
            errores.addAll(validator.validatePro(pro));
        }
        return errores;
    }
    
    
}
