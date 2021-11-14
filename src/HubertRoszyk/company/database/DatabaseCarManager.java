package HubertRoszyk.company.database;

import HubertRoszyk.company.CarData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCarManager {
    public static void addCarToDatabase(int id, String mark, String model, String plate, String status) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInsertionStatement = "INSERT INTO cars VALUES (" + id + ",\"" + mark + "\",\"" + model + "\",\"" + plate + "\",\"" + status + "\")";

        statement.executeUpdate(SQLInsertionStatement);
    }
    public static List<CarData> getCarsFromDatabase() throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
        List<CarData> carsList = new ArrayList<>();
        ResultSet carsResult = statement.executeQuery("SELECT * FROM cars");

        int size = 0;
        if (carsResult.last())
        {
            size = carsResult.getRow(); // get row id
            carsResult.beforeFirst();
        }
        for (int i = 0; i < size; i++) {
            List<String> carDataList = new ArrayList<>();
            String idString, mark, model, plate, status;
            int id;

            carsResult.next();

            idString = carsResult.getString("car_id"); //to może nie działać najwyżej zamiast int dać string i potem zamienić
            mark = carsResult.getString("mark");
            model = carsResult.getString("model");
            plate = carsResult.getString("plate");
            status = carsResult.getString("status");

            carDataList.add(mark);
            carDataList.add(model);
            carDataList.add(plate);
            carDataList.add(idString);
            carDataList.add(status);

            CarData carObject = new CarData(carDataList);
            carsList.add(carObject);
        }
        return(carsList);
    }
    public static void updateCarsTable(String status, int car_id) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLUpdateStatement = "UPDATE cars SET status = \"" + status + "\" WHERE car_id =" + car_id;

        statement.executeUpdate(SQLUpdateStatement);
    }
}
