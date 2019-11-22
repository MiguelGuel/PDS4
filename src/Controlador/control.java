/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.modelo;
import Vista.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class control implements ActionListener {

    private menu men;
    private modelo model;

    public control(menu men, modelo model) {
        this.men = men;
        this.model = model;
        llenarEmpleados();
        llenarClientes();
        llenarProveedores();
        llenarCategorias();
        men.verC.addActionListener(this);
        men.agregarC.addActionListener(this);
        men.eliminarC.addActionListener(this);
        men.verPro.addActionListener(this);
        men.verCli.addActionListener(this);
        men.verEm.addActionListener(this);
        men.verOr.addActionListener(this);
        men.verProd.addActionListener(this);
        men.agregarCl.addActionListener(this);
        men.agrePro.addActionListener(this);
        men.agreEm.addActionListener(this);
        men.agreOr.addActionListener(this);
        men.agrep.addActionListener(this);
    }
    public void llenarEmpleados(){
        ResultSet rs = model.llenarEmpleados();
        try {
            while (rs.next()) {
                men.comboEm.addItem(rs.getInt(1)+"-"+rs.getString(2).trim() + " " + rs.getString(3).trim());
                men.comboEmOr.addItem(rs.getInt(1)+"-"+rs.getString(2).trim() + " " + rs.getString(3).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void llenarClientes(){
        ResultSet rs = model.llenarClientes();
        try {
            while (rs.next()) {
                men.comboClieOr.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarProveedores(){
        ResultSet rs = model.llenarProveedores();
        try {
            while (rs.next()) {
                men.provP.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarCategorias(){
        ResultSet rs = model.llenarCategorias();
        try {
            while (rs.next()) {
              men.catP.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void iniciar() {
        men.setTitle("Proveedores");
        men.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Ver categorias":
                String datos = model.buscarCategorias("SELECT nombrecat FROM categorias");
                men.text.setText("Categorías: \n\n" + datos);
                break;

            case "Ver proveedores":
                String datosp = model.buscarProveedores();
                men.textPro.setText(datosp);
                break;

            case "Ver clientes":
                String datospr = model.buscarClientes();
                men.textCli.setText(datospr);
                break;

            case "Ver empleados":
                String datosem = model.buscarEmpleados();
                men.textEm.setText(datosem);
                break;
            
            case "Ver ordenes":
                String datosor = model.buscarOrdendes();
                men.textOr.setText(datosor);
                break;
            case "Ver productos":
                String datospro = model.buscarProductos();
                men.textProd.setText(datospro);
                break;
                
            case "Agregar cliente":
                String nombre = men.nombre.getText();
                String cedula = men.ced.getText();
                String contacto = men.contacto.getText();
                String dire = men.dire.getText();
                String fax = men.fax.getText();
                String mail = men.mail.getText();
                String cel = men.cel.getText();
                String fijo = men.fijo.getText();
                model.agregarCliente(cedula,nombre.toUpperCase(),contacto.toUpperCase(),dire.toUpperCase(),fax,mail,cel,fijo);
                men.nombre.setText("");
                men.ced.setText("");
                men.contacto.setText("");
                men.dire.setText("");
                men.fax.setText("");
                men.mail.setText("");
                men.cel.setText("");
                men.fijo.setText("");
                break;
                
            case "Agregar categoria":
                String cate = men.cate.getText();
                model.agregarCategoria(cate);
                men.cate.setText("");
                break;
                
            case "Agregar proveedor":
                String nombrepr = men.nomPro.getText();
                String contactopr = men.conPro.getText();
                String celpro = men.celPro.getText();
                String fijopro = men.fijoPro.getText();
                model.agregarProveedor(nombrepr, contactopr, celpro, fijopro);
                break;
                
            case "Agregar empleado":
                String nombreem = men.nombreEm.getText();
                String apellidoem = men.apeEm.getText();
                java.util.Date fecha = men.dateEm.getDate();
                String jefe = (String) men.comboEm.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String fecha1 = format.format(fecha);
                String[] datosj = jefe.split("-");
                int id = Integer.parseInt(datosj[0]);
                int ext = Integer.parseInt(men.extEm.getText());
                model.agregarEmpleado(nombreem.toUpperCase(),apellidoem.toUpperCase(),fecha1, id,ext);
                men.nombreEm.setText("");
                men.apeEm.setText("");
                men.comboEm.setSelectedIndex(1);
                men.extEm.setText("");
                break;
                
            case "Agregar orden":
                String emp = (String) men.comboEmOr.getSelectedItem();
                String datosemp[] = emp.split("-");
                int idemp = Integer.parseInt(datosemp[0]);
                
                String cli = (String) men.comboClieOr.getSelectedItem();
                String dacli[] = cli.split("-");
                int idecli = Integer.parseInt(dacli[0]);
                
                java.util.Date fechaOr = men.datechooserOr.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                
                int desc = Integer.parseInt(men.descOR.getText());
                
                String fecha2 = formato.format(fechaOr);
                
                model.agregarOrden(idemp, idecli, fecha2, desc);
                men.descOR.setText("");
                break;
                
            case "Agregar producto":
                String pro = (String) men.provP.getSelectedItem();
                String dapro[] = pro.split("-");
                int idpro = Integer.parseInt(dapro[0]);
                
                String cat = (String) men.catP.getSelectedItem();
                String dacat[] = cat.split("-");
                int idcat = Integer.parseInt(dacat[0]);
                
                String descripcion = men.descr.getText();
                int precio = Integer.parseInt(men.precio.getText());
                int existencia = Integer.parseInt(men.exist.getText());
                
                model.agregarProducto(idpro, idcat, descripcion.toUpperCase(), precio, existencia);
                men.descr.setText("");
                men.precio.setText("");
                men.exist.setText("");
                break;
            default:
                throw new AssertionError();
        }

    }

}
