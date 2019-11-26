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
public class clienteValidator implements Validator {

    @Override
    public List<String> validate(datos regis) {
        List<String> errores = new ArrayList<String>();
        String cedula = regis.getCedula();
        String nombre = regis.getNombre();
        String contacto = regis.getContacto();
        String dire = regis.getDire();
        String fax = regis.getFax();
        String mail = regis.getMail();
        String cel = regis.getCel();
        String fijo = regis.getFijo();

        if (cedula.length() != 10 && !cedula.isEmpty()) {
            errores.add("La cedula debe tener una longitud de 10");
        }
        if (cedula.isEmpty()) {
            errores.add("La cedula no puede estar vacia");
        }
        if (nombre.isEmpty()) {
            errores.add("El nombre no puede estar vacio");
        }
        if (nombre.length()> 30 && !nombre.isEmpty()) {
            errores.add("El nombre no puede tener más de 30 caracteres");
        }
        if (contacto.isEmpty()) {
            errores.add("El contacto no puede estar vacio");
        }
        if (contacto.length()>50 && !contacto.isEmpty()) {
            errores.add("El contacto no puede tener más de 50 caracteres");
        }
        if (dire.isEmpty()) {
            errores.add("La direccion no puede estar vacia");
        }
        if (dire.length() > 50 && !dire.isEmpty()) {
            errores.add("La direccion no puede tener más de 50 caracteres");
        }
        if (fax.isEmpty()) {
            errores.add("El fax no puede estar vacio");
        }
        if (fax.length() != 12 && !fax.isEmpty()) {
            errores.add("el fax no puede tener más de 12 caracteres");
        }
        if (mail.isEmpty()) {
            errores.add("El email no puede estar vacío");
        }
        if (mail.length()> 50 && !mail.isEmpty()) {
            errores.add("El email no puede ser mayor a 50 caracteres");
        }
        if (cel.isEmpty()) {
            errores.add("El celular no puede estar vacío");
        }
        if (cel.length() != 10 && !cel.isEmpty()) {
            errores.add("El celular debe ser de 10 digitos");
        }
        if (fijo.isEmpty()) {
            errores.add("El número fijo no puede estar vacío");
        }
        if (fijo.length()!=10 && !fijo.isEmpty()) {
            errores.add("El número fijo debe tener 10 digitos");
        }

        return errores;
    }

//    @Override
//    public List<String> validateCate(categoria cat) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
