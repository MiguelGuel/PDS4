/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoriaV;

import clases.categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class nombreValidation implements ValidatorC{

    @Override
    public List<String> validateCate(categoria cat) {
        List<String> errores = new ArrayList<String>();
        String nombre = cat.getNombre();
        if (nombre.isEmpty()) {
            errores.add("El nombre no puede estar vacío");
        }
        if (nombre.length() > 50 && !nombre.isEmpty()) {
            errores.add("El nombre no puede exceder los 50 caracteres");
        }
        return errores;
    }
    
}
