/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprogra;

import Controlador.control;
import Controlador.controlador;
import Vista.Vista;
import Vista.menu;
import javax.swing.JOptionPane;
import proxymodel.proxyInterface;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.registry.*;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class Finalprogra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String base = JOptionPane.showInputDialog("¿Qué base de datos desea usar?");
            Registry reg=LocateRegistry.getRegistry("localhost", 9000);
            proxyInterface mod=  (proxyInterface) reg.lookup("server");
            mod.setBase(base);
            mod.init();
            //Vista vis = new Vista();
            menu men = new menu();
            //controlador ctrl = new controlador(vis,mod);
            control ctr = new control(men, mod);
            //ctrl.iniciar();
            ctr.iniciar();
            //vis.setVisible(true);
            men.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Finalprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Finalprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Finalprogra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Finalprogra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
