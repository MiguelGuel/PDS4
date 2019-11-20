package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class MySQL extends DataBase{
    //Connection connection;
    public static final String HOSTNAME = "localhost";
    public static final String DBNAME   = "pedidos";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "admin123";
    @Override
    public boolean Open() {
       String URL="jdbc:mysql://"+HOSTNAME+":3306/"+DBNAME;
        try {
             Class.forName("com.mysql.jdbc.Driver");
             connection = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
             System.out.println("Conexion");
             return true;
        }    catch(Exception e){
             System.out.println(e);
        }
        return false;
    }

    @Override
    public ResultSet Query(String queryString) throws SQLException {
        PreparedStatement ps;
        ResultSet res;
        
        ps = connection.prepareStatement(queryString);
        res = ps.executeQuery();
        return res;
    }

    @Override
    public boolean Close() {
        return true;
    }

    @Override
    public ResultSet QueryRecorrible(String queryString) throws SQLException {
        return null;
        
    }

    @Override
    public void Insert(String query) throws SQLException{
        PreparedStatement ps;
        ps = connection.prepareStatement(query);
        ps.executeUpdate();
    }
    
}
