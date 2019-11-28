/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proxymodel.proxyInterface;

/**
 *
 * @author LENOVO
 */
public class controlador implements ActionListener {

    private Vista view;
    private proxyInterface model;
    public controlador(Vista view, proxyInterface model) {
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
            try {
                model.setBase("PostgreSQL");
            } catch (SQLException ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                } else if (view.mysql.isSelected()) {
            try {
                model.setBase("MySQL");
            } catch (SQLException ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            {
                try {
                    System.out.println(model.getBase());
                } catch (SQLException ex) {
                    Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                break;

                
            default:
                throw new AssertionError();
        }
    }
}
