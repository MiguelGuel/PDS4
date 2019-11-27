package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class CelValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String cel = regis.getCel();

        if (cel.isEmpty()) {
            errores.add("El celular no puede estar vacío");
        }
        if (cel.length() != 10 && !cel.isEmpty()) {
            errores.add("El celular debe ser de 10 digitos");
        }

        return errores;
    }

}
