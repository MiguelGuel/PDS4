package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class MailValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String mail = regis.getMail();

        if (mail.isEmpty()) {
            errores.add("El email no puede estar vacío");
        }
        if (mail.length() > 50 && !mail.isEmpty()) {
            errores.add("El email no puede ser mayor a 50 caracteres");
        }

        return errores;
    }

}
