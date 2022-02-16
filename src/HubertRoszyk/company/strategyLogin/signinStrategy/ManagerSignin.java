package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.AccountData;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.Pages.MainManagerPage;
import HubertRoszyk.company.ManagerData;
import HubertRoszyk.company.database.DatabaseAccountManager;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManagerSignin implements SigninItemStrategy{
    public void run() throws IOException, SQLException {
        System.out.println("Twożenie konta managera");

        BufferedReader reader = new BufferedReader(new FileReader("mainPassword.txt"));
        String mainPassword = reader.readLine();
        reader.close();

        List<String> managerInputData;
        managerInputData = Main.textManager.getManagerData();

        int accountId = Main.listManager.accounts.size() + 1;

        ManagerData manager = new ManagerData(managerInputData.get(0), managerInputData.get(1), managerInputData.get(2), "manager", accountId);
        AccountData account = new AccountData(managerInputData.get(0), managerInputData.get(1), managerInputData.get(2), "manager", accountId);

        if(mainPassword.equals(managerInputData.get(3))) {
            DatabaseAccountManager.addAccountToDatabase(manager);
            Main.listManager.accounts.add(account);
            Main.listManager.loggedAccount = account;

            MainManagerPage mainManagerPage = new MainManagerPage();
        } else {
            System.out.println("Podano złe hasło główne");
        }
    }
}
