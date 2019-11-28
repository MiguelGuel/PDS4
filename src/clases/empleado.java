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
public class empleado {
    String nombre,ape,fecha,id,ext;

    public empleado(String nombre, String ape, String fecha, String id, String ext) {
        this.nombre = nombre;
        this.ape = ape;
        this.fecha = fecha;
        this.id = id;
        this.ext = ext;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApe() {
        return ape;
    }

    public String getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public String getExt() {
        return ext;
    }
    
}
