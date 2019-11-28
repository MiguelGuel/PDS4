package detallesV;

import clases.detalles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class cantidadValidation implements ValidatorD{

    @Override
    public List<String> validateD(detalles deta) {
        List<String> errores = new ArrayList<String>();
        String cantidad = deta.getCantidad();
        if (cantidad.isEmpty()) {
            errores.add("Se requiere añadir una cantidad");
        }
        return errores;
    }
    
}
