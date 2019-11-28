/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadoV;

import clases.empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class empleadoValidator implements ValidatorE{
    private final List<ValidatorE> validators;

    public empleadoValidator(List<ValidatorE> validators) {
        this.validators = validators;
    }
    @Override
    public List<String> validatePro(empleado emp) {
         List<String> errores = new ArrayList<String>();
        for (ValidatorE validator: validators) {
            errores.addAll(validator.validatePro(emp));
        }
        return errores;
    }
    
}
