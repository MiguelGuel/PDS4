/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprogra;

import Controlador.control;
import Controlador.controlador;
import Modelo.modelo;
import Vista.Vista;
import Vista.menu;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Finalprogra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String base = JOptionPane.showInputDialog("¿Qué base de datos desea usar?");
        modelo mod = new modelo(base);
        mod.setBase(base);
        //Vista vis = new Vista();
        menu men = new menu();
        //controlador ctrl = new controlador(vis,mod);
        control ctr = new control(men, mod);
        //ctrl.iniciar();
        ctr.iniciar();
        //vis.setVisible(true);
        men.setVisible(true);
    }
    

}
