package HubertRoszyk.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private static String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static String USER = "root";
    private  static String PASSWORD = "1234";
    private static Connection connection = null;

    public static Connection connect() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
