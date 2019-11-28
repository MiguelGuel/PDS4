/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenV;

import clases.orden;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ordenValidator implements ValidatorO {

    private final List<ValidatorO> validators;

    public ordenValidator(List<ValidatorO> validators) {
        this.validators = validators;
    }

    @Override
    public List<String> validatePro(orden or) {
        List<String> errores = new ArrayList<String>();
        for (ValidatorO validator: validators) {
            errores.addAll(validator.validatePro(or));
        }
        return errores;
    }

}
