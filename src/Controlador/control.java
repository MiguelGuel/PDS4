/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import proxymodel.proxyInterface;
import Vista.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class control implements ActionListener {

    private menu men;
    private proxyInterface model;

    public control(menu men, proxyInterface model) {
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
        try {
            men.comboEm.removeAllItems();
            men.comboEmOr.removeAllItems();
            ArrayList<String> info=model.llenarEmpleados();
            for (int i = 0; i < info.size(); i++) {
                men.comboEm.addItem(info.get(i));
                men.comboEmOr.addItem(info.get(i));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    public void llenarClientes(){
        try {
            men.comboClieOr.removeAllItems();
            ArrayList<String> info=model.llenarClientes();
            for (int i = 0; i < info.size(); i++) {
                men.comboClieOr.addItem(info.get(i));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarProveedores(){
        try {
            men.provP.removeAllItems();
            ArrayList<String> info=model.llenarProveedores();
            for (int i = 0; i < info.size(); i++) {
                men.provP.addItem(info.get(i));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarCategorias(){
        try {
            men.catP.removeAllItems();
            men.categoria.removeAllItems();
            ArrayList<String> info = model.llenarCategorias();
            for (int i = 0; i < info.size(); i++) {
                men.catP.addItem(info.get(i));
                men.categoria.addItem(info.get(i));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void iniciar() {
        men.setTitle("Proveedores");
        men.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
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
                    llenarCategorias();
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
                    
                case "Eliminar categoria":
                    String datoscat = (String) men.categoria.getSelectedItem();
                    System.out.println(datoscat);
                    String datcat[] = datoscat.split("-");
                    String categ = datcat[0];
                    System.out.println(categ);
                    model.elimincarCategoria(categ);
                    llenarCategorias();
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
