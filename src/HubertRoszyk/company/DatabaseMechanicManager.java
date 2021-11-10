package HubertRoszyk.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMechanicManager {
    public static void addMechanicToDatabase(int id, String firstName, String lastName) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInsertionStatement = "INSERT INTO mechanics VALUES (" + id + ",\"" + firstName + "\",\"" + lastName + "\")";
        System.out.println(SQLInsertionStatement);

        statement.executeUpdate(SQLInsertionStatement);
    }
    public static List<MechanicData> getMechanicsFromDatabase() throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
        List<MechanicData> mechanicsList = new ArrayList<>();
        ResultSet mechanicsResult = statement.executeQuery("SELECT * FROM mechanics");

        int size = 0;
        if (mechanicsResult.last())
        {
            size = mechanicsResult.getRow(); // get row id
            mechanicsResult.beforeFirst();
        }
        for (int i = 0; i < size; i++) {
            List<String> mechanicDataList = new ArrayList<>();
            String idString, firstName, lastName;
            int id;

            mechanicsResult.next();

            idString = mechanicsResult.getString("mechanic_id"); //to może nie działać najwyżej zamiast int dać string i potem zamienić
            firstName = mechanicsResult.getString("firstName");
            lastName = mechanicsResult.getString("lastName");

            mechanicDataList.add(firstName);
            mechanicDataList.add(lastName);
            mechanicDataList.add(idString);

            MechanicData mechanicData = new MechanicData(mechanicDataList);
            mechanicsList.add(mechanicData);
        }

        return(mechanicsList);
    }
}
