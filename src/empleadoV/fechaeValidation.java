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
public class fechaeValidation implements ValidatorE{

    @Override
    public List<String> validatePro(empleado emp) {
      List<String> errores = new ArrayList<String>();
        String fecha = emp.getFecha();
        if (fecha.isEmpty()) {
            errores.add("Se debe introducir una fecha de nacimiento");
        }
      
      return errores;
    }
    
}
