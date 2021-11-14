package HubertRoszyk.company.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDeletingValues {
    public static void delateValuses(String tableName) throws SQLException { //możnaby dać tablicę
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLDeleteStatement = "DELETE FROM " + tableName;
        statement.executeUpdate(SQLDeleteStatement);
    }
}
