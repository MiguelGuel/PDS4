package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class ContactoValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String contacto = regis.getContacto();

        if (contacto.isEmpty()) {
            errores.add("El contacto no puede estar vacio");
        }
        if (contacto.length() > 50 && !contacto.isEmpty()) {
            errores.add("El contacto no puede tener más de 50 caracteres");
        }

        return errores;
    }

}
