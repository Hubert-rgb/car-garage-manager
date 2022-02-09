package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MainMechanicPage;
import HubertRoszyk.company.MainUserPage;
import HubertRoszyk.company.MechanicData;
import HubertRoszyk.company.database.DatabaseAccountManager;
import HubertRoszyk.company.database.DatabaseUserManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSignin implements SigninItemStrategy{
    public void run() throws IOException, SQLException {
        System.out.println("Twożenie konta użytkownika");

        List<String> userData = new ArrayList<>();

        userData = Main.textManager.getUserData();
        DatabaseAccountManager.addAccountToDatabase(userData.get(0), userData.get(1), userData.get(2), "user");

        MainUserPage mainUserPage = new MainUserPage();
    }
}
