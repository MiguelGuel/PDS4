/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LENOVO
 */
public class factory {
    public DataBase baseD(String opcion){
        
        DataBase seleccion = null;
        if (opcion.equalsIgnoreCase("PostgreSQL")) {
            seleccion = new PostgreSql();
        }else if(opcion.equalsIgnoreCase("MySQL")){
            seleccion = new MySQL();
        }
        return seleccion;
    }
}
