/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import clases.categoria;
import clases.datos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class compositeValidator implements Validator{
    private final List<Validator> validators;

    public compositeValidator(List<Validator> validators) {
        this.validators = validators;
    }

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        for (Validator validator: validators) {
            errores.addAll(validator.validate(regis));
        }
        return errores;
    }

//    @Override
//    public List<String> validateCate(categoria cat) {
//        List<String> errores = new ArrayList<String>();
//        for (Validator validator: validators) {
//            errores.addAll(validator.validateCate(cat));
//        }
//        return errores;
//    }
}
