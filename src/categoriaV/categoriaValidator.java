/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoriaV;

import clases.categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class categoriaValidator implements ValidatorC{
    private final List<ValidatorC> validators;

    public categoriaValidator(List<ValidatorC> validators) {
        this.validators = validators;
    }
    @Override
    public List<String> validateCate(categoria cat) {
        List<String> errores = new ArrayList<String>();
        for (ValidatorC validator: validators) {
            errores.addAll(validator.validateCate(cat));
        }
        return errores;
    }
    
}
