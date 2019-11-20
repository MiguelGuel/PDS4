package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSql extends DataBase {

   // Connection connection;
    public static final String HOSTNAME = "localhost";
    public static final String DBNAME = "pedidos";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "Ocanoencinas";

    @Override
    public boolean Open() {
        String URL = "jdbc:postgresql://" + HOSTNAME + ":5432/" + DBNAME;
        try {
            Class.forName("org.postgresql.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Hola entro");
            return true;
        } catch (Exception e) {
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
        PreparedStatement ps;
        ResultSet res;

        ps = connection.prepareStatement(queryString, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        res = ps.executeQuery();
        return res;
    }

    @Override
    public void Insert(String query) throws SQLException{
        PreparedStatement ps;
        ps = connection.prepareStatement(query);
        ps.executeUpdate();
    }
}
