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
public class datos {
    String cedula, nombre,contacto,dire,fax,mail,cel,fijo;

    public datos(String cedula, String nombre, String contacto, String dire, String fax, String mail, String cel, String fijo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contacto = contacto;
        this.dire = dire;
        this.fax = fax;
        this.mail = mail;
        this.cel = cel;
        this.fijo = fijo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getDire() {
        return dire;
    }

    public String getFax() {
        return fax;
    }


    public String getMail() {
        return mail;
    }

    public String getCel() {
        return cel;
    }

    public String getFijo() {
        return fijo;
    }
    
}
