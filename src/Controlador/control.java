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
            default:
                throw new AssertionError();
        }

    }

}
