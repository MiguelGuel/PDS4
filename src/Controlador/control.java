/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import clases.datos;
import Modelo.modelo;
import Vista.menu;
import categoriaV.ValidatorC;
import categoriaV.categoriaValidator;
import clases.categoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validator.CedulaValidation;
import validator.CelValidation;
import validator.ContactoValidation;
import validator.DireccionValidation;
import validator.FaxValidation;
import validator.FijoValidation;
import validator.MailValidation;
import validator.NameValidation;
import validator.Validator;
import validator.clienteValidator;
import validator.compositeValidator;
import categoriaV.nombreValidation;
import clases.empleado;
import clases.producto;
import clases.proveedor;
import empleadoV.ValidatorE;
import empleadoV.apellidoValidation;
import empleadoV.empleadoValidator;
import empleadoV.extValidation;
import empleadoV.fechaeValidation;
import empleadoV.nombreeValidation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import productoV.ValidatorP;
import productoV.categoriaValidation;
import productoV.descripcionValidation;
import productoV.existenciaValidation;
import productoV.precioValidation;
import productoV.productoValidator;
import productoV.proveedorValidation;
import proveedorV.ValidatorPr;
import proveedorV.celularValidation;
import proveedorV.contactoValidation;
import proveedorV.fijoValidation;
import proveedorV.nombrePValidation;
import proveedorV.proveedorValidator;

/**
 *
 * @author LENOVO
 */
public class control implements ActionListener {

    private menu men;
    private modelo model;
    clienteValidator cv;
    categoriaValidator catV;
    productoValidator proV;
    proveedorValidator proVa;
    empleadoValidator ev;
    List<String> listathree = new ArrayList<>();

    public control(menu men, modelo model) {
        this.men = men;
        this.model = model;
        men.datechooserOr.setMaxSelectableDate(comprobarEdad());
        men.datechooserOr.setDate(comprobarEdad());
        men.dateEm.setMaxSelectableDate(comprobarEdad());
        men.dateEm.setMaxSelectableDate(comprobarEdad());
        List<Validator> listaCliente = new ArrayList<>();
        //Empiezan validator para cliente
        listaCliente.add(new CedulaValidation());
        listaCliente.add(new CelValidation());
        listaCliente.add(new ContactoValidation());
        listaCliente.add(new DireccionValidation());
        listaCliente.add(new FaxValidation());
        listaCliente.add(new FijoValidation());
        listaCliente.add(new MailValidation());
        listaCliente.add(new NameValidation());
        //Termina validator para cliente
        //Empieza validator para categoria
        List<ValidatorC> listaCate = new ArrayList<>();
        listaCate.add(new nombreValidation());
        //Termina validator para categoria
        //Empieza validator para producto
        List<ValidatorP> listaPro = new ArrayList<>();
        listaPro.add(new proveedorValidation());
        listaPro.add(new categoriaValidation());
        listaPro.add(new descripcionValidation());
        listaPro.add(new precioValidation());
        listaPro.add(new existenciaValidation());
        //Termina validator para producto
        //inicia validator para proveedor
        List<ValidatorPr> listaProv = new ArrayList<>();
        listaProv.add(new nombrePValidation());
        listaProv.add(new contactoValidation());
        listaProv.add(new celularValidation());
        listaProv.add(new fijoValidation());
        //termina validator para proveedor
        //inicia validator para empleado
        List<ValidatorE> listaE = new ArrayList<>();
        listaE.add(new nombreeValidation());
        listaE.add(new apellidoValidation());
        listaE.add(new fechaeValidation());
        listaE.add(new extValidation());
        //termina validator para empleado
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
        men.eliCli.addActionListener(this);

        cv = new clienteValidator(listaCliente);
        catV = new categoriaValidator(listaCate);
        proV = new productoValidator(listaPro);
        proVa = new proveedorValidator(listaProv);
        ev = new empleadoValidator(listaE);
    }

    public Date comprobarEdad() {
        Date date1 = new Date();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        int endindex = date.length();
        String tempdate = date.substring(0, 4);
        int year = Integer.parseInt(tempdate);
        year -= 18;
        String newdate = year + date.substring(4, endindex);
        try {
            date1 = new SimpleDateFormat("yyyy/MM/dd").parse(newdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return date1;
    }

    public void llenarEmpleados() {
        men.comboEm.removeAllItems();
        men.comboEmOr.removeAllItems();
        ResultSet rs = model.llenarEmpleados();
        try {
            while (rs.next()) {
                men.comboEm.addItem(rs.getInt(1) + "-" + rs.getString(2).trim() + " " + rs.getString(3).trim());
                men.comboEmOr.addItem(rs.getInt(1) + "-" + rs.getString(2).trim() + " " + rs.getString(3).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llenarClientes() {
        men.comboClieOr.removeAllItems();
        men.clientes.removeAllItems();
        ResultSet rs = model.llenarClientes();
        try {
            while (rs.next()) {
                men.comboClieOr.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
                men.clientes.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarProveedores() {
        men.provP.removeAllItems();
        ResultSet rs = model.llenarProveedores();
        try {
            while (rs.next()) {
                men.provP.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCategorias() {
        men.catP.removeAllItems();
        men.categoria.removeAllItems();
        ResultSet rs = model.llenarCategorias();
        try {
            while (rs.next()) {
                men.catP.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
                men.categoria.addItem(rs.getInt(1) + "-" + rs.getString(2).trim());
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
        StringBuilder stb = new StringBuilder();
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
                listathree = cv.validate(new datos(cedula, nombre, contacto, dire, fax, mail, cel, fijo));
                for (String v : listathree) {
                    System.out.println(v);
                    stb.append("- " + v + "\n");
                }
                if (stb.length() == 0) {
                    model.agregarCliente(cedula, nombre.toUpperCase(), contacto.toUpperCase(), dire.toUpperCase(), fax, mail, cel, fijo);
                    men.nombre.setText("");
                    men.ced.setText("");
                    men.contacto.setText("");
                    men.dire.setText("");
                    men.fax.setText("");
                    men.mail.setText("");
                    men.cel.setText("");
                    men.fijo.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, stb.toString());
                }

                break;

            case "Agregar categoria":
                String cate = men.cate.getText();
                listathree = catV.validateCate(new categoria(cate));
                for (String v : listathree) {
                    System.out.println(v);
                    stb.append("- " + v + "\n");
                }
                if (stb.length() == 0) {
                    model.agregarCategoria(cate);
                    llenarCategorias();
                    men.cate.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, stb.toString());
                }

                break;

            case "Agregar proveedor":
                String nombrepr = men.nomPro.getText();
                String contactopr = men.conPro.getText();
                String celpro = men.celPro.getText();
                String fijopro = men.fijoPro.getText();
                listathree = proVa.validatePr(new proveedor(nombrepr, contactopr, celpro, fijopro));
                for (String v : listathree) {
                    System.out.println(v);
                    stb.append("- " + v + "\n");
                }
                if (stb.length() == 0) {
                    model.agregarProveedor(nombrepr, contactopr, celpro, fijopro);
                    llenarProveedores();
                    men.nomPro.setText("");
                    men.conPro.setText("");
                    men.celPro.setText("");
                    men.fijoPro.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, stb.toString());
                }

                break;

            case "Agregar empleado":
                String nombreem = men.nombreEm.getText();
                String apellidoem = men.apeEm.getText();
                java.util.Date fecha = men.dateEm.getDate();
                String jefe = (String) men.comboEm.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String fecha1 = format.format(fecha);
                String[] datosj = jefe.split("-");
                String id = datosj[0];
                String ext = men.extEm.getText();

                listathree = ev.validatePro(new empleado(nombreem, apellidoem, fecha1, id, ext));
                for (String v : listathree) {
                    System.out.println(v);
                    stb.append("- " + v + "\n");
                }
                if (stb.length() == 0) {
                    model.agregarEmpleado(nombreem.toUpperCase(), apellidoem.toUpperCase(), fecha1, id, ext);
                    men.nombreEm.setText("");
                    men.apeEm.setText("");
                    men.comboEm.setSelectedIndex(1);
                    men.extEm.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, stb.toString());
                }

                break;

            case "Agregar orden":
                String emp = (String) men.comboEmOr.getSelectedItem();
                String datosemp[] = emp.split("-");
                String idemp = datosemp[0];

                String cli = (String) men.comboClieOr.getSelectedItem();
                String dacli[] = cli.split("-");
                String idecli = dacli[0];

                java.util.Date fechaOr = men.datechooserOr.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                String desc = men.descOR.getText();

                String fecha2 = formato.format(fechaOr);

                model.agregarOrden(idemp, idecli, fecha2, desc);
                men.descOR.setText("");
                break;

            case "Agregar producto":
                String pro = (String) men.provP.getSelectedItem();
                String dapro[] = pro.split("-");
                String idpro = dapro[0];

                String cat = (String) men.catP.getSelectedItem();
                String dacat[] = cat.split("-");
                String idcat = dacat[0];

                String descripcion = men.descr.getText();
                String precio = men.precio.getText();
                String existencia = men.exist.getText();

                listathree = proV.validatePro(new producto(idpro, idcat, descripcion, precio, existencia));
                for (String v : listathree) {
                    System.out.println(v);
                    stb.append("- " + v + "\n");
                }
                if (stb.length() == 0) {
                    model.agregarProducto(idpro, idcat, descripcion.toUpperCase(), precio, existencia);
                    men.descr.setText("");
                    men.precio.setText("");
                    men.exist.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, stb.toString());
                }

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

    }

}
