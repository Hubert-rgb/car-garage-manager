package HubertRoszyk.company.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccountManager {
    public static void addAccountToDatabase(String firstName, String lastName, String password, String type) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInertionStatement = "INSERT INTO accounts VALUES (DEFAULT, \"" + firstName + "\", \"" + lastName + "\", \"" + password + "\", \""+ type + "\")";
        statement.executeUpdate(SQLInertionStatement);
    }
}
