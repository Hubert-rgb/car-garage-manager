package HubertRoszyk.company.database;

import HubertRoszyk.company.AccountData;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.MechanicData;
import HubertRoszyk.company.Validator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMechanicManager {
    public static void addMechanicToDatabase(MechanicData mechanic) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInsertionStatement = "INSERT INTO mechanics VALUES (" + mechanic.id + ",\"" + mechanic.mechanicCode + "\")";
        //System.out.println(SQLInsertionStatement);

        statement.executeUpdate(SQLInsertionStatement);
    }
    public static void updateMechanicInDatabase(MechanicData mechanic) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInsertionStatement = "UPDATE mechanics SET accountId = " + mechanic.id + ",\" mechanicCode =" + mechanic.mechanicCode + "\" WHERE accountID = " + mechanic.id;
        //System.out.println(SQLInsertionStatement);

        statement.executeUpdate(SQLInsertionStatement);
    }
    public static List<MechanicData> getMechanicsFromDatabase() throws SQLException {
        Validator validator = new Validator();
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
        List<MechanicData> mechanicsList = new ArrayList<>();
        List<AccountData> mechanicsAccount = new ArrayList<>();
        ResultSet mechanicsResult = statement.executeQuery("SELECT * FROM mechanics");

        int accountsListSize = Main.listManager.accounts.size();
        for (int i = 0; i < accountsListSize; i++) {
            if (Main.listManager.accounts.get(i).accountType.equals("mechanic")){
                mechanicsAccount.add(Main.listManager.accounts.get(i));
            }
        }

        int size = 0;
        if (mechanicsResult.last())
        {
            size = mechanicsResult.getRow(); // get row id
            mechanicsResult.beforeFirst();
        }
        int counter = 0;
        for (int i = 0; i < size; i++) {
            String accountIdString, mechanicCode;
            int accountId;

            mechanicsResult.next();

            accountIdString = mechanicsResult.getString("accountId");
            mechanicCode = mechanicsResult.getString("mechanicCode");

            accountId = validator.stringToInt(accountIdString);

            if (accountId == mechanicsAccount.get(i).id) {
                counter++;
            }

            MechanicData mechanic = new MechanicData(mechanicsAccount.get(i).firstName, mechanicsAccount.get(i).lastName, mechanicsAccount.get(i).password, mechanicsAccount.get(i).accountType, mechanicsAccount.get(i).id, mechanicCode);
            mechanicsList.add(mechanic);
        }
        if (counter != mechanicsAccount.size()) {
            System.out.println("Nastąpił błąd przy wczytywaniu mechaników z bazy danych!!!");
            System.out.println("Udaj się do serwisu");
        }

        return(mechanicsList);
    }
}
