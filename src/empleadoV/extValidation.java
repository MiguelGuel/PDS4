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
public class extValidation implements ValidatorE{

    @Override
    public List<String> validatePro(empleado emp) {
        List<String> errores = new ArrayList<String>();
        String extension = emp.getExt();
        if (extension.isEmpty()) {
            errores.add("Se debe introducir una extensión");
        }
        return errores;
        
    }
    
}
