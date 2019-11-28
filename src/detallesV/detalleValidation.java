/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detallesV;

import clases.detalles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class detalleValidation implements ValidatorD{

    @Override
    public List<String> validateD(detalles deta) {
        List<String> errores = new ArrayList<String>();
        String detalles = deta.getDetalleid();
        if (detalles.isEmpty()) {
            errores.add("Es necesario agregar el id de detalle");
        }
        
        return errores;
    }
    
}
