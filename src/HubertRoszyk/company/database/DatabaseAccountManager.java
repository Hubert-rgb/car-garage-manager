package HubertRoszyk.company.database;

import HubertRoszyk.company.AccountData;
import HubertRoszyk.company.MechanicData;
import HubertRoszyk.company.Validator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccountManager {
    public static void addAccountToDatabase(AccountData account) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInertionStatement = "INSERT INTO accounts VALUES ( \"" + account.id + "\", \"" + account.firstName + "\", \"" + account.lastName + "\", \"" + account.password + "\", \""+ account.accountType + "\")";
        statement.executeUpdate(SQLInertionStatement);
    }
    public static void updateAccountInDatabase(AccountData account) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInertionStatement = "Update accounts SET accountId = \"" + account.id + "\", firstName = \"" + account.firstName + "\", lastName = \"" + account.lastName + "\", password =\"" + account.password + "\", accountType = \""+ account.accountType + "\" WHERE accountId =" + account.id;
        statement.executeUpdate(SQLInertionStatement);
    }
    public static List<AccountData> getAccountsFromDatabase() throws SQLException {
        Validator validator = new Validator();
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
        List<AccountData> accountDatas = new ArrayList<>();
        ResultSet accountsResult = statement.executeQuery("SELECT * FROM accounts");

        int size = 0;
        if (accountsResult.last())
        {
            size = accountsResult.getRow(); // get row id
            accountsResult.beforeFirst();
        }
        for (int i = 0; i < size; i++) {
            String idString, firstName, lastName, accountType, password;
            int id;

            accountsResult.next();

            firstName = accountsResult.getString("firstName");
            lastName = accountsResult.getString("lastName");
            password = accountsResult.getString("password");
            accountType = accountsResult.getString("accountType");
            idString = accountsResult.getString("accountId");

            id = validator.stringToInt(idString);

            AccountData accountData = new AccountData(firstName, lastName, password, accountType, id);//dodać haslo

            accountDatas.add(accountData);
        }

        return(accountDatas);
    }
}
