/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxymodel;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public interface proxyInterface{
    public void init()throws Exception;

    public void update(String tablename,String criteria, String target, String criteriavalue, String targetvalue) throws Exception;
    
    public ArrayList getTablas() throws Exception;
    
    public ArrayList getColumnas(String tablename) throws Exception;
    public String getBase()throws Exception;

    public void setBase(String base)throws Exception;

   
    public String buscarCategorias(String query)throws Exception;
    public String buscarProveedores()throws Exception;
    public String buscarClientes()throws Exception;
        
    public String buscarEmpleados()throws Exception;
        
    public String buscarOrdendes()throws Exception;
        
    public String buscarProductos()throws Exception;

    public void agregarCliente(String cedula, String nombre, String contacto, String direccion, String fax, String email, String celular, String fijo)throws Exception;

    public void agregarCategoria(String cate)throws Exception;

    public void agregarProveedor(String nombre, String cont, String cel, String fijo)throws Exception;

    public ArrayList llenarEmpleados()throws Exception;

    public ArrayList llenarClientes()throws Exception;

    public ArrayList llenarProveedores()throws Exception;

    public ArrayList llenarCategorias()throws Exception;

    public void agregarEmpleado(String nombre, String ape, String fecha, int id, int ext)throws Exception;

    public void agregarOrden(int id, int idc, String fecha, int desc)throws Exception;

    public void agregarProducto(int provid, int catid, String desc, int precio, int exist)throws Exception;

    public void elimincarCategoria(String cat)throws Exception;
    
}
