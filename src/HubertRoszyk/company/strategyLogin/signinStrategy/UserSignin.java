package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.*;
import HubertRoszyk.company.Pages.MainUserPage;
import HubertRoszyk.company.database.DatabaseAccountManager;
import HubertRoszyk.company.database.DatabaseUserManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSignin implements SigninItemStrategy{
    public void run() throws IOException, SQLException {
        System.out.println("Twożenie konta użytkownika");

        List<String> userInputData;
        userInputData = Main.textManager.getUserData();
        List<Integer> integerList = new ArrayList<>();

        int accountId = Main.listManager.accounts.size() + 1;

        UserData user = new UserData(userInputData.get(0), userInputData.get(1), userInputData.get(2), "user", accountId, integerList);
        AccountData account = new AccountData(userInputData.get(0), userInputData.get(1), userInputData.get(2), "user", accountId);

        Main.listManager.accounts.add(account);
        Main.listManager.loggedAccount = account;

        DatabaseAccountManager.addAccountToDatabase(user);
        DatabaseUserManager.addUserToDatabase(user);

        MainUserPage mainUserPage = new MainUserPage();
    }
}
