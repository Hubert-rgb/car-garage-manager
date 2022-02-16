package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.AccountData;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.MechanicData;
import HubertRoszyk.company.Pages.MainMechanicPage;
import HubertRoszyk.company.database.DatabaseAccountManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MechanicSingin implements SigninItemStrategy{
    public void run() throws SQLException, IOException {
        List<String> mechanicDataInput;
        mechanicDataInput = Main.textManager.getMechanicData();

        String mechanicCodeInput = mechanicDataInput.get(0);
        String password = mechanicDataInput.get(1);


        System.out.println("Twożenie konta mechanika");
        int counter = 0;
        int sizeOfMechanicsList = Main.listManager.mechanics.size();
        for (int i = 0; i < sizeOfMechanicsList; i++) {
            MechanicData mechanic= Main.listManager.mechanics.get(i);
            if (!mechanic.password.equals("")) {
                System.out.println("Utworzono już konto dla tego kodu!!!");
                System.out.println("Skorzystaj z opcji logowania lub przypomnienia hasła");
                counter = -1;
            } else {
                if (mechanic.mechanicCode.equals(mechanicCodeInput)) {
                    counter++;
                    mechanic.password = password;
                    DatabaseAccountManager.updateAccountInDatabase(mechanic);
                    AccountData account = new AccountData(mechanic.firstName, mechanic.lastName, mechanic.password, mechanic.accountType, mechanic.id);

                    Main.listManager.accounts.add(account);
                    Main.listManager.loggedAccount = account;

                    MainMechanicPage mainMechanicPage = new MainMechanicPage();
                }
            }

            if (counter == 0) {
                System.out.println("Wpisano błędny kod");
            } else if (counter > 1) {
                System.out.println("Błąd programu związany z powtórzeniem się kodu");
                System.out.println("Udaj się do serwisu!!!");
            }
        }
    }
}
