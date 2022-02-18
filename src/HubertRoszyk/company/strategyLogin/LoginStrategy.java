package HubertRoszyk.company.strategyLogin;

import HubertRoszyk.company.*;
import HubertRoszyk.company.Pages.LoginPage;
import HubertRoszyk.company.Pages.MainManagerPage;
import HubertRoszyk.company.Pages.MainMechanicPage;
import HubertRoszyk.company.Pages.MainUserPage;
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
        Validator validator = new Validator();
        List<String> loginData;
        loginData = Main.textManager.getLoginData();
        if (loginData != null) {
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
                idString = accountsResult.getString("accountId"); //to może nie działać najwyżej zamiast int dać string i potem zamienić
                firstName = accountsResult.getString("firstName");
                lastName = accountsResult.getString("lastName");
                password = accountsResult.getString("password");

                accountData.add(firstName);
                accountData.add(lastName);
                accountData.add(password);

                if (loginData.equals(accountData)) {
                    accountData.add(accountType);
                    accountData.add(idString);

                    AccountData account = new AccountData(accountData.get(0), accountData.get(1), accountData.get(2), accountData.get(3), validator.stringToInt(accountData.get(4)));
                    Main.listManager.loggedAccount = account;

                    System.out.println("Zalogowano na konto\n");
                    //System.out.println(account.firstName);

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
        } else {
            LoginPage loginPage = new LoginPage();
        }
    }
}
