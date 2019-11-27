package validator;

import clases.datos;
import java.util.ArrayList;
import java.util.List;

public class FijoValidation implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String fijo = regis.getFijo();

        if (fijo.isEmpty()) {
            errores.add("El número fijo no puede estar vacío");
        }
        if (fijo.length() != 10 && !fijo.isEmpty()) {
            errores.add("El número fijo debe tener 10 digitos");
        }

        return errores;

    }

}
