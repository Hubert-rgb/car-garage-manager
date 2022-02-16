package HubertRoszyk.company.database;

import HubertRoszyk.company.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUserManager {
    public static void addUserToDatabase(UserData user) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInertionStatement = "INSERT INTO users VALUES (\"" + user.id + "\", \"" + "" + "\")";
        statement.executeUpdate(SQLInertionStatement);
    }
    public static void updateUserInDatabase(UserData user) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String carNumsString = "";
        int sizeOfCarNums = user.carNums.size();
        for (int i = 0; i < sizeOfCarNums; i++) {
            carNumsString = carNumsString + "," + user.carNums.get(i).toString();
        }

        String SQLInertionStatement = "UPDATE users SET accountId = \"" + user.id + "\", carNums = \"" + user.carNums + "\" WHERE accountId = " + user.id;
        statement.executeUpdate(SQLInertionStatement);
    }
    public static List<UserData> getUsersFromDatabase() throws SQLException {
        Validator validator = new Validator();
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
        List<UserData> usersList = new ArrayList<>();
        List<AccountData> usersAccounts = new ArrayList<>();
        ResultSet usersResult = statement.executeQuery("SELECT * FROM users");

        int accountsListSize = Main.listManager.accounts.size();
        for (int i = 0; i < accountsListSize; i++) {
            if (Main.listManager.accounts.get(i).accountType.equals("user")){
                usersAccounts.add(Main.listManager.accounts.get(i));
            }
        }

        int size = 0;
        if (usersResult.last())
        {
            size = usersResult.getRow(); // get row id
            usersResult.beforeFirst();
        }
        int counter = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> carNumsIntList = new ArrayList<>();
            String accountIdString;
            String carNumsString;
            int accountId;

            usersResult.next();

            accountIdString = usersResult.getString("accountId");
            carNumsString = usersResult.getString("carNums");

            accountId = validator.stringToInt(accountIdString);

            if (accountId == usersAccounts.get(i).id) {
                counter++;
            }


            List<String> carNumsStringList;
            if (!carNumsString.equals("")) {
                carNumsString = carNumsString.replaceAll(" ", "");
                carNumsString = carNumsString.substring(1, carNumsString.length() - 1); // usuwanie nawiasów kwadratowych
                carNumsStringList = List.of(carNumsString.split(","));
                for (int j = 0; j < carNumsStringList.size(); j++) {
                    carNumsIntList.add(Integer.valueOf(carNumsStringList.get(j)));
                }

            }

            UserData user = new UserData(usersAccounts.get(i).firstName, usersAccounts.get(i).lastName, usersAccounts.get(i).password, usersAccounts.get(i).accountType, usersAccounts.get(i).id, carNumsIntList);
            usersList.add(user);
        }
        if (counter != usersAccounts.size()) {
            System.out.println("Nastąpił błąd przy wczytywaniu samochodów z bazy danych!!!");
            System.out.println("Udaj się do serwisu");
        }

        return(usersList);
    }
}
