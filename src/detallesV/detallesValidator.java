/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detallesV;

import clases.detalles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class detallesValidator implements ValidatorD {

    private final List<ValidatorD> validators;

    public detallesValidator(List<ValidatorD> validators) {
        this.validators = validators;
    }

    @Override
    public List<String> validateD(detalles deta) {
        List<String> errores = new ArrayList<String>();
        for (ValidatorD validator: validators) {
            errores.addAll(validator.validateD(deta));
        }
        return errores;
    }

}
