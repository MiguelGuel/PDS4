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
public class detalles {
    String ordenid, detalleid, productoid, cantidad;

    public String getOrdenid() {
        return ordenid;
    }

    public String getDetalleid() {
        return detalleid;
    }

    public String getProductoid() {
        return productoid;
    }

    public String getCantidad() {
        return cantidad;
    }

    public detalles(String ordenid, String detalleid, String productoid, String cantidad) {
        this.ordenid = ordenid;
        this.detalleid = detalleid;
        this.productoid = productoid;
        this.cantidad = cantidad;
    }
}
