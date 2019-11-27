package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class FaxValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String fax = regis.getFax();

        if (fax.isEmpty()) {
            errores.add("El fax no puede estar vacio");
        }
        if (fax.length() != 12 && !fax.isEmpty()) {
            errores.add("el fax no puede tener más de 12 caracteres");
        }

        return errores;
    }

}
