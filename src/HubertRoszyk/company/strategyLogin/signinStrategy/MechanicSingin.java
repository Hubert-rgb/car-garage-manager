package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MainMechanicPage;
import HubertRoszyk.company.database.DatabaseAccountManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
            if (!Main.listManager.mechanics.get(i).password.equals("")) {
                System.out.println("Utworzono już konto dla tego kodu!!!");
                System.out.println("Skorzystaj z opcji logowania lub przypomnienia hasła");
                counter = -1;
            } else {
                if (Main.listManager.mechanics.get(i).mechanicCode.equals(mechanicCodeInput)) {
                    counter++;
                    Main.listManager.mechanics.get(i).password = password;
                    DatabaseAccountManager.updateAccountInDatabase(Main.listManager.mechanics.get(i));
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
