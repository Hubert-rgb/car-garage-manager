package HubertRoszyk.company.strategyLogin.signinStrategy;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MainManagerPage;
import HubertRoszyk.company.MainMechanicPage;
import HubertRoszyk.company.MechanicData;
import HubertRoszyk.company.database.DatabaseAccountManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MechanicSingin implements SigninItemStrategy{
    public void run() throws SQLException, IOException {
        System.out.println("Twożenie konta mechanika");

        List<String> mechanicData = new ArrayList<>();

        mechanicData = Main.textManager.getMechanicData2();

        //int id = Main.listManager.mechanics.size() + 1;
        //mechanicData.add(String.valueOf(id));

        //MechanicData mechanic = new MechanicData(mechanicData);

        //Main.listManager.mechanics.add(mechanic);

        //DatabaseAccountManager.addAccountToDatabase();



        MainMechanicPage mainMechanicPage = new MainMechanicPage();
    }
}
