/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class modelo {

    private String base;
    factory fabrica = new factory();
    //DataBase db = fabrica.baseD("PostgreSQL");
   // DataBase mysql = fabrica.baseD("MySQL");
     DataBase db;       
     
    public modelo(String dbName) {
        db = fabrica.baseD(dbName);
        db.Open();
        //mysql.Open();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

   
    public String buscarCategorias(String query) {
        String resultado = db.buscarCategorias(query);
        return resultado;
    }
    public String buscarProveedores(){
       String resultado = db.buscarProveedores("select * from proveedores order by proveedorid");
        return resultado;
        
    }
        public String buscarClientes(){
       String resultado = db.buscarClientes();
        return resultado;
        
    }
        
        public String buscarEmpleados(){
            String resultado = db.buscarEmpleados();
            return resultado;
        }
        
        public String buscarOrdenes(){
            String resultado = db.buscarOrdenes();
            return resultado;
        }
        public String buscarDetalles(){
            String resultado = db.buscarDetalles();
            return resultado;
        }
        public String buscarProductos(){
            String resultado = db.buscarProductos();
            return resultado;
        }
        
        public void agregarCliente(String cedula,String nombre,String contacto,String direccion,String fax,String email,String celular,String fijo){
            db.agregarCliente(cedula, nombre, contacto, direccion, fax, email, celular, fijo);
        }
        
        public void agregarCategoria(String cate){
            db.agregarCategoria(cate);
        }
        
        public void agregarProveedor(String nombre, String cont, String cel, String fijo){
            db.agregarProveedor(nombre, cont, cel, fijo);
        }
        
        public ResultSet llenarEmpleados(){
            ResultSet rs = db.llenarEmpleados();
            return rs;
        }
        
        public ResultSet llenarClientes(){
            ResultSet rs = db.llenarClientes();
            return rs;
        }
        
        public ResultSet llenarProveedores(){
            ResultSet rs = db.llenarProveedores();
            return rs;
        }
        
        public ResultSet llenarCategorias(){
            ResultSet rs = db.llenarCategorias();
            return rs;
        }
        public ResultSet llenarOrdenes(){
            ResultSet rs = db.llenarOrdenes();
            return rs;
        }
        public ResultSet llenarProductos(){
            ResultSet rs = db.llenarProductos();
            return rs;
        }
        public void agregarEmpleado(String nombre, String ape, String fecha, String id, String ext){
            db.agregarEmpleado(nombre,ape,fecha,id,ext);
        }
        
        public void agregarOrden(String id, String idc, String fecha, String desc){
            db.agregarOrden(id, idc, fecha, desc);
        }
        
        public void agregarProducto(String provid, String catid, String desc, String precio, String exist){
            db.agregarProducto(provid, catid, desc, precio, exist);
        }
        
        public void agregarDetalles(String idorden, String idetalle, String productoid, String cantidad){
            db.agregarDetalles(idorden, idetalle, productoid, cantidad);
        }
        
        public void elimincarCategoria(String cat){
            db.eliminarCategoria(cat);
        }
    /*public String buscarCategoriasMy(String query) {
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = mysql.Query(query);
            while (rs.next()) {
                String cate = rs.getString(1);
                sb.append(cate + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();

    }*/

    /*
    public void agregarCatPost(String categoria) {
        try {
            ResultSet rs = post.QueryRecorrible("SELECT categoriaid FROM categorias");
            rs.last();
            int ultimo = rs.getInt("categoriaid") + 100;
            String query = "INSERT INTO public.categorias(\n"
                    + "	categoriaid, nombrecat)\n"
                    + "	VALUES ("+ultimo+",'"+categoria.toUpperCase()+"');";
            post.Insert(query);
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String buscarProveedores(){
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = post.Query("select * from proveedores");
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String contacto = rs.getString(3);
                String celular = rs.getString(4);
                String fijo = rs.getString(5);
                sb.append("Nombre de proveedor: " +nombre+"\n");
                sb.append("Contacto: " + contacto+"\n");
                sb.append("Celular: " + celular+"\n");
                sb.append("Teléfono fijo: "+fijo+"\n");
                sb.append("------------\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sb.toString();  
    }
    public String buscarClientes(){
        StringBuilder sb = new StringBuilder();
        try {
            ResultSet rs = post.Query("select * from clientes");
            while (rs.next()) {
                String cedula = rs.getString(2);
                String nombre = rs.getString(3);
                String nombrecon = rs.getString(4);
                String direccion = rs.getString(5);
                String fax = rs.getString(6);
                String email = rs.getString(7);
                String cel = rs.getString(8);
                String fijo = rs.getString(9);
                sb.append("Cédula: " + cedula+"\n");
                sb.append("Nombre: "+nombre+"\n");
                sb.append("Contacto: "+nombrecon+"\n");
                sb.append("Dirección: "+ direccion+"\n");
                sb.append("Fax: " + fax + "\n");
                sb.append("Email: " +email + "\n");
                sb.append("Celular: " + cel + "\n");
                sb.append("Teléfono fijo: " + fijo + "\n");
                sb.append("----------\n");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sb.toString();   
    }*/

}
