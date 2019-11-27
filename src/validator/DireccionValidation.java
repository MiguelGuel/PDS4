package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class DireccionValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String dire = regis.getDire();

        if (dire.isEmpty()) {
            errores.add("La direccion no puede estar vacia");
        }
        if (dire.length() > 50 && !dire.isEmpty()) {
            errores.add("La direccion no puede tener más de 50 caracteres");
        }
        
        return errores;
    }

}
