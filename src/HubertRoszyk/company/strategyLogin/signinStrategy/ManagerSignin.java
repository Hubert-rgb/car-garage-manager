package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MainManagerPage;
import HubertRoszyk.company.SigninPage;
import HubertRoszyk.company.database.DatabaseAccountManager;
import HubertRoszyk.company.database.DatabaseManagerManager;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerSignin implements SigninItemStrategy{
    public void run() throws IOException, SQLException {
        System.out.println("Twożenie konta managera");

        BufferedReader reader = new BufferedReader(new FileReader("mainPassword.txt"));
        String mainPassword = reader.readLine();
        reader.close();

        List<String> managerData = new ArrayList<>();
        managerData = Main.textManager.getManagerData();

        if(mainPassword.equals(managerData.get(3))) {
            DatabaseAccountManager.addAccountToDatabase(managerData.get(0), managerData.get(1), managerData.get(2), "manager");

            MainManagerPage mainManagerPage = new MainManagerPage();
        } else {
            System.out.println("Podano złe hasło główne");
        }
    }
}
