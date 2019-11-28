/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadoV;

import clases.empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class apellidoValidation implements ValidatorE{

    @Override
    public List<String> validatePro(empleado emp) {
        List<String> errores = new ArrayList<String>();
        String apellido = emp.getApe();
        if (apellido.isEmpty()) {
            errores.add("El apellido no puede estar vacío");
        }
        if (apellido.length() > 30 && !apellido.isEmpty()) {
            errores.add("El apellido no debe ser mayor a 30 caracteres");
        }
        
        return errores;
    }
    
}
