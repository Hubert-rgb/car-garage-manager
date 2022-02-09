package HubertRoszyk.company.strategyLogin;

import HubertRoszyk.company.*;
import HubertRoszyk.company.database.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginStrategy implements LoginItemStrategy {
    public void run() throws IOException, SQLException {
        List<String> loginData = new ArrayList<>();
        loginData = Main.textManager.getLoginData();

        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //co to znaczy
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
            List<String> accountData = new ArrayList<>();

            accountsResult.next();

            accountType = accountsResult.getString("accountType");
            idString = accountsResult.getString("account_id"); //to może nie działać najwyżej zamiast int dać string i potem zamienić
            firstName = accountsResult.getString("firstName");
            lastName = accountsResult.getString("lastName");
            password = accountsResult.getString("password");

            accountData.add(firstName);
            accountData.add(lastName);
            accountData.add(password);

            System.out.println(loginData + " "+ accountData);
            if (loginData.equals(accountData)) {
                accountData.add(idString);
                accountData.add(accountType);

                System.out.println("Zalogowano na konto\n");

                switch (accountType) {
                    case "manager":
                        MainManagerPage mainManagerPage = new MainManagerPage();
                        break;
                    case "mechanic":
                        MainMechanicPage mainMechanicPage = new MainMechanicPage();
                        break;
                    case "user":
                        MainUserPage mainUserPage = new MainUserPage();
                        break;
                }

            }
        }
        System.out.println("Nie znaleziono konta dla tych danych");
    }
}
