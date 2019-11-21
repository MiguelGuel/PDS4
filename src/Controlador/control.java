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
        men.verC.addActionListener(this);
        men.agregarC.addActionListener(this);
        men.eliminarC.addActionListener(this);
        men.verPro.addActionListener(this);
        men.verCli.addActionListener(this);
        men.verEm.addActionListener(this);
        men.verOr.addActionListener(this);
        men.verProd.addActionListener(this);
        men.agregarCl.addActionListener(this);
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
            default:
                throw new AssertionError();
        }

    }

}
