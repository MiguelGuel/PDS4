/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedorV;

import clases.producto;
import clases.proveedor;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface ValidatorPr {
    List<String> validatePr (proveedor pro);
}
