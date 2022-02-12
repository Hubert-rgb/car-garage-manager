package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.*;
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

        UserData user = new UserData(userInputData.get(0), userInputData.get(1), userInputData.get(2), "user", Main.listManager.accounts.size() + 1);

        DatabaseAccountManager.addAccountToDatabase(user);

        MainUserPage mainUserPage = new MainUserPage();
    }
}
