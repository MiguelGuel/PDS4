/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import clases.categoria;
import clases.datos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class categoriaValidator implements Validator{

    @Override
    public List<String> validate(datos regis) {
        return null;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<String> validateCate(categoria cat) {
//        List<String> errores = new ArrayList<>();
//        String nombre = cat.getNombre();
//        if (nombre.isEmpty()) {
//            errores.add("El nombre no puede estar vacio");
//        }
//        if (nombre.length() > 50 && !nombre.isEmpty()) {
//            errores.add("El nombre no puede ser mayor de 50 caracteres");
//        }
//        return errores;
//    }
    
}
