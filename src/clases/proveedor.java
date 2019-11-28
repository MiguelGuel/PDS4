
package clases;

public class proveedor {
    String nombre, contacto, cel, fijo;

    public proveedor(String nombre, String contacto, String cel, String fijo) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.cel = cel;
        this.fijo = fijo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCel() {
        return cel;
    }

    public String getFijo() {
        return fijo;
    }
    
}
