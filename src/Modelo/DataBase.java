/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public abstract class DataBase {

    Connection connection;

    public abstract boolean Open();

    public abstract ResultSet Query(String queryString) throws SQLException;

    public abstract boolean Close();

    public abstract ResultSet QueryRecorrible(String queryString) throws SQLException;

    public abstract void Insert(String query) throws SQLException;

    public String buscarCategorias(String query) {
        StringBuilder sb = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cate = rs.getString(1);
                sb.append(cate + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();

    }

    public String buscarProveedores(String query) {
        StringBuilder sb = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String contacto = rs.getString(3);
                String celular = rs.getString(4);
                String fijo = rs.getString(5);
                sb.append("Nombre de proveedor: " + nombre + "\n");
                sb.append("Contacto: " + contacto + "\n");
                sb.append("Celular: " + celular + "\n");
                sb.append("Teléfono fijo: " + fijo + "\n");
                sb.append("------------\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sb.toString();
    }

    public String buscarClientes() {
        StringBuilder sb = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from clientes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cedula = rs.getString(2);
                String nombre = rs.getString(3);
                String nombrecon = rs.getString(4);
                String direccion = rs.getString(5);
                String fax = rs.getString(6);
                String email = rs.getString(7);
                String cel = rs.getString(8);
                String fijo = rs.getString(9);
                sb.append("Cédula: " + cedula + "\n");
                sb.append("Nombre: " + nombre + "\n");
                sb.append("Contacto: " + nombrecon + "\n");
                sb.append("Dirección: " + direccion + "\n");
                sb.append("Fax: " + fax + "\n");
                sb.append("Email: " + email + "\n");
                sb.append("Celular: " + cel + "\n");
                sb.append("Teléfono fijo: " + fijo + "\n");
                sb.append("----------\n");

            }
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sb.toString();
    }

    public String buscarEmpleados() {
        StringBuilder sb = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from empleados");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                Date fecha = rs.getDate(4);
                int jefe = rs.getInt(5);
                int ext = rs.getInt(6);
                sb.append("Nombre: " + nombre + "\n");
                sb.append("Apellido: " + apellido + "\n");
                sb.append("Fecha de nacimiento: " + fecha + "\n");
                sb.append("Jefe: " + jefe + "\n");
                sb.append("Extensión: " + "\n");
                sb.append("-------------\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    public String buscarOrdenes() {
        StringBuilder sb = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement("select empleados.nombre, empleados.apellido, clientes.nombrecia, ordenes.fechaorden, ordenes.descuento\n"
                    + "from ordenes join empleados on (ordenes.empleadoid = empleados.empleadoid) join clientes on (clientes.clienteid = ordenes.clienteid)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                String apellido = rs.getString(2);
                String nombrecia = rs.getString(3);
                Date fecha = rs.getDate(4);
                int desc = rs.getInt(5);
                sb.append("Empleado que realizó la orden: " + nombre + apellido + "\n");
                sb.append("Cliente: " + nombrecia + "\n");
                sb.append("Fecha de orden: " + fecha + "\n");
                sb.append("Descuento aplicado: " + desc + "\n");
                sb.append("-----------\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    public String buscarProductos() {
        StringBuilder sb = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement("select proveedores.nombreprov, categorias.nombrecat, productos.descripcion, productos.preciounit\n"
                    + "from proveedores join productos on(proveedores.proveedorid = productos.proveedorid) join categorias on (categorias.categoriaid = productos.categoriaid)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String prove = rs.getString(1);
                String cate = rs.getString(2);
                String desc = rs.getString(3);
                Double precio = rs.getDouble(4);
                sb.append("Proveedor: " + prove + "\n");
                sb.append("Categoría: " + cate + "\n");
                sb.append("Descripción: " + desc + "\n");
                sb.append("Precio: " + precio + "\n");
                sb.append("-------------\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    public void agregarCliente(String cedula, String nombre, String contacto, String direccion, String fax, String email, String cel, String fijo) {
        try {
            PreparedStatement ps = connection.prepareStatement("select clienteid from clientes", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt(1) + 1;
            String query = "INSERT INTO clientes(\n"
                    + "	clienteid, cedula_ruc, nombrecia, nombrecontacto, direccioncli, fax, email, celular, fijo)\n"
                    + "	VALUES("+ultimo+",'"+cedula+"','"+nombre+"','"+contacto+"','"+direccion+"','"+fax+"','"+email+"','"+cel+"','"+fijo+"')";
            System.out.println(query);
            PreparedStatement ps1 = connection.prepareStatement(query);
            
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarCategoria(String cate){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT categoriaid FROM categorias", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt("categoriaid") + 100;
            String query = "INSERT INTO public.categorias(\n"
                    + "	categoriaid, nombrecat)\n"
                    + "	VALUES ("+ultimo+",'"+cate.toUpperCase()+"');";
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
