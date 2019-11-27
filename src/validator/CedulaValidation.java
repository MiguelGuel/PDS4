package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class CedulaValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String cedula = regis.getCedula();

        if (cedula.length() != 10 && !cedula.isEmpty()) {
            errores.add("La cedula debe tener una longitud de 10");
        }
        if (cedula.isEmpty()) {
            errores.add("La cedula no puede estar vacia");
        }

        return errores;
    }

}
