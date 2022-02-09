package HubertRoszyk.company.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManagerManager {
    public static void addManagerToDatabase(String firstName, String lastaName, String password) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInertionStatement = "INSERT INTO managers VALUES (DEFAULT, \"" + firstName + "\", \"" + lastaName + "\", \"" + password + "\")";
        statement.executeUpdate(SQLInertionStatement);
    }
}
