package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class NameValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String nombre = regis.getNombre();

        if (nombre.isEmpty()) {
            errores.add("El nombre no puede estar vacio");
        }
        if (nombre.length() > 30 && !nombre.isEmpty()) {
            errores.add("El nombre no puede tener más de 30 caracteres");
        }

        return errores;
    }

}
