/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author LENOVO
 */
public class producto {
    String proveedor, categoria, descripcion, precio, existencia;

    public producto(String proveedor, String categoria, String descripcion, String precio, String existencia) {
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getExistencia() {
        return existencia;
    }
    
}
