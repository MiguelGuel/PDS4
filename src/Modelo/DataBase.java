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
            PreparedStatement ps = connection.prepareStatement("select * from clientes order by clienteid");
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
            PreparedStatement ps = connection.prepareStatement("select emp.nombre, emp.apellido,emp.fecha_nac, jefe.nombre as nombre_del_jefe, jefe.apellido as ape_del_jefe, emp.extension\n"
                    + "from empleados emp \n"
                    + "left join empleados jefe\n"
                    + "on jefe.empleadoid = emp.reporta_a\n"
                    + "order by emp.empleadoid;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1).trim();
                String apellido = rs.getString(2).trim();
                Date fecha = rs.getDate(3);
                String nombrej = rs.getString(4);
                String apej = rs.getString(5);
                int ext = rs.getInt(6);
                sb.append("Nombre: " + nombre + "\n");
                sb.append("Apellido: " + apellido + "\n");
                sb.append("Fecha de nacimiento: " + fecha + "\n");
                sb.append("Nombre Jefe: " + nombrej + "\n");
                sb.append("Apellido Jefe: " + apej + "\n");
                sb.append("Extensión: " + ext + "\n");
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
                    + "from ordenes join empleados on (ordenes.empleadoid = empleados.empleadoid) join clientes on (clientes.clienteid = ordenes.clienteid)\n"
                    + "order by ordenes.ordenid");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1).trim();
                String apellido = rs.getString(2).trim();
                String nombrecia = rs.getString(3);
                Date fecha = rs.getDate(4);
                int desc = rs.getInt(5);
                sb.append("Empleado que realizó la orden: " + nombre + " " + apellido + "\n");
                sb.append("Cliente: " + nombrecia + "\n");
                sb.append("Fecha de orden: " + fecha + "\n");
                sb.append("Descuento aplicado: " + desc + "%\n");
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
                    + "from proveedores join productos on(proveedores.proveedorid = productos.proveedorid) join categorias on (categorias.categoriaid = productos.categoriaid)\n"
                    + "order by proveedores.proveedorid");
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
            PreparedStatement ps = connection.prepareStatement("select clienteid from clientes order by clienteid", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt(1) + 1;
            String query = "INSERT INTO clientes(\n"
                    + "	clienteid, cedula_ruc, nombrecia, nombrecontacto, direccioncli, fax, email, celular, fijo)\n"
                    + "	VALUES(" + ultimo + ",'" + cedula + "','" + nombre + "','" + contacto + "','" + direccion + "','" + fax + "','" + email + "','" + cel + "','" + fijo + "')";
            System.out.println(query);
            PreparedStatement ps1 = connection.prepareStatement(query);

            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarCategoria(String cate) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT categoriaid FROM categorias order by categoriaid", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt(1) + 100;
            System.out.println(ultimo);
            String query = "INSERT INTO categorias(\n"
                    + "	categoriaid, nombrecat)\n"
                    + "	VALUES (" + ultimo + ",'" + cate.toUpperCase() + "');";
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarProveedor(String nombre, String cont, String cel, String fijo) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from proveedores order by proveedorid", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt("proveedorid") + 10;
            String query = "INSERT INTO proveedores(\n"
                    + "	proveedorid, nombreprov, contacto, celuprov, fijoprov)\n"
                    + "	VALUES (" + ultimo + ",'" + nombre.toUpperCase() + "','" + cont.toUpperCase() + "'," + cel + "," + fijo + ");";
            System.out.println(query);
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet llenarEmpleados() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select empleadoid, nombre,apellido from empleados order by empleadoid" );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet llenarClientes() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select clienteid,nombrecia from clientes order by clienteid" );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet llenarProveedores() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select proveedorid, nombreprov from proveedores order by proveedorid");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet llenarCategorias() {
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from categorias order by categoriaid");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void agregarEmpleado(String nombre, String ape, String fecha, int jefe, int ext) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select empleadoid from empleados order by empleadoid", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt(1) + 1;
            String query = "INSERT INTO empleados(\n"
                    + "	empleadoid, nombre, apellido, fecha_nac, reporta_a, extension)\n"
                    + "	VALUES (" + ultimo + ",'" + nombre + "','" + ape + "','" + fecha + "'," + jefe + "," + ext + ");";
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void agregarOrden(int idEm, int idCli, String fecha, int desc) {
        try {
            PreparedStatement ps = connection.prepareStatement("select ordenid from ordenes order by ordenid", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt(1) + 1;
            String query = "INSERT INTO ordenes(\n"
                    + "	ordenid, empleadoid, clienteid, fechaorden, descuento)\n"
                    + "	VALUES (" + ultimo + "," + idEm + "," + idCli + ",'" + fecha + "'," + desc + ");";
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarProducto(int provid, int catid, String desc, int precio, int exist) {
        try {
            PreparedStatement ps = connection.prepareStatement("select productoid from productos order by productoid", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int ultimo = rs.getInt(1) + 1;
            String query = "INSERT INTO productos(\n"
                    + "	productoid, proveedorid, categoriaid, descripcion, preciounit, existencia)\n"
                    + "	VALUES (" + ultimo + "," + provid + "," + catid + ",'" + desc + "'," + precio + "," + exist + ");";
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarCategoria(String cat) {
        String query = "DELETE FROM categorias\n"
                + "WHERE categoriaid = " + cat + ";";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
