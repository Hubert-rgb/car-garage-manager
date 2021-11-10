package HubertRoszyk.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitialize {
    private static String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static String USER = "root";
    private  static String PASSWORD = "1234";

    public Connection connect() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement statement = connection.createStatement();

            String carsTableCreation = "CREATE TABLE cars(car_id Integer, mark Text, model Text, plate Text, status Text, PRIMARY KEY(car_id))";
            String mechanicsTableCreation = "CREATE TABLE mechanics(mechanic_id Integer, firstName Text, lastName Text, PRIMARY KEY(mechanic_id))";
            String repairTableCreation = "CREATE TABLE repair(repair_id Integer, car_id Integer, mechanic_id Integer, PRIMARY KEY(repair_id))";

            statement.executeUpdate("DROP TABLE cars");

            System.out.println("stworzonao tabelę");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
