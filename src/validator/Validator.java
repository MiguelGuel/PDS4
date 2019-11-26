package validator;

import clases.categoria;
import clases.datos;
import java.util.List;

public interface Validator {
    List<String> validate (datos regis);
    //List<String> validateCate (categoria cat);
}
