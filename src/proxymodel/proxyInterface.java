/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxymodel;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
public interface proxyInterface{
    public void init(String dbName)throws SQLException;

    public String getBase()throws SQLException;

    public void setBase(String base)throws SQLException;

   
    public String buscarCategorias(String query)throws SQLException;
    public String buscarProveedores()throws SQLException;
    public String buscarClientes()throws SQLException;
        
    public String buscarEmpleados()throws SQLException;
        
    public String buscarOrdendes()throws SQLException;
        
    public String buscarProductos()throws SQLException;

    public void agregarCliente(String cedula, String nombre, String contacto, String direccion, String fax, String email, String celular, String fijo)throws SQLException;

    public void agregarCategoria(String cate)throws SQLException;

    public void agregarProveedor(String nombre, String cont, String cel, String fijo)throws SQLException;

    public ResultSet llenarEmpleados()throws SQLException;

    public ResultSet llenarClientes()throws SQLException;

    public ResultSet llenarProveedores()throws SQLException;

    public ResultSet llenarCategorias()throws SQLException;

    public void agregarEmpleado(String nombre, String ape, String fecha, int id, int ext)throws SQLException;

    public void agregarOrden(int id, int idc, String fecha, int desc)throws SQLException;

    public void agregarProducto(int provid, int catid, String desc, int precio, int exist)throws SQLException;

    public void elimincarCategoria(String cat)throws SQLException;
    
}
