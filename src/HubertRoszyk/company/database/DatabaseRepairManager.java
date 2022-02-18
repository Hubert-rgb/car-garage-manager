package HubertRoszyk.company.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseRepairManager {
    public static void addRepairToDatabase(int car_id, int mechanic_id, String tableName) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInsertionStatement = "INSERT INTO " + tableName + " VALUES (DEFAULT," + car_id + "," + mechanic_id + ")";

        statement.executeUpdate(SQLInsertionStatement);
    }
    public static int getRepairValuesFromDatabase(String tableName, int car_id) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        int mechanic_id;

        String SQLGettingValuesStatement = "SELECT car_id, mechanic_id FROM " + tableName + " WHERE car_id = " + String.valueOf(car_id);
        ResultSet mechanic_idResultSet = statement.executeQuery(SQLGettingValuesStatement);

        mechanic_idResultSet.next();
        mechanic_id = mechanic_idResultSet.getInt("mechanic_id");

        return(mechanic_id);
    }
    public static void deleteRepairFromDatabase(String tableName, int car_id) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLDeleteStatement = "DELETE FROM " + tableName + " WHERE car_id = " + String.valueOf(car_id);
        statement.executeUpdate(SQLDeleteStatement);
    }
    public static HashMap<Integer, List<Integer>> getRepairsFromDatabase(String tableName) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
        HashMap<Integer, List<Integer>> repairs = new HashMap<>();

        ResultSet repairsResult = statement.executeQuery("SELECT * FROM " + tableName);
        Statement countStatement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //creating second statement and result set
        ResultSet countResults = countStatement.executeQuery("SELECT COUNT(*) FROM " + tableName +" AS size");
        int size = 0;
        if(countResults.last()) {
            size = countResults.getInt("COUNT(*)");
        }
        
        for (int i = 0; i < size; i++) {
            List<Integer> carsInRepair = new ArrayList<>();
            int carId, mechanicId;
            String stringMechanicId, stringCarId;

            repairsResult.next();

            carId = repairsResult.getInt("car_id");
            mechanicId = repairsResult.getInt("mechanic_id");

            if (repairs.get(mechanicId) != null) {
                carsInRepair = repairs.get(mechanicId);
            }

            carsInRepair.add(carId);
            repairs.put(mechanicId, carsInRepair);
        }

        return(repairs);
    }
}
