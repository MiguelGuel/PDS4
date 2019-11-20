/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataBase;
import Modelo.factory;
import Modelo.modelo;
import Vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class controlador implements ActionListener {

    private Vista view;
    private modelo model;
    public controlador(Vista view, modelo model) {
        this.view = view;
        this.model = model;
        view.next.addActionListener(this);
        

    }

    public void iniciar() {
        view.setTitle("Proveedores");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Continuar":
                if (view.postgre.isSelected()) {
                    model.setBase("PostgreSQL");
                } else if (view.mysql.isSelected()) {
                    model.setBase("MySQL");
                }
                System.out.println(model.getBase());
                break;
                
            default:
                throw new AssertionError();
        }
    }
}
