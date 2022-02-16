package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MechanicData;
import HubertRoszyk.company.database.DatabaseAccountManager;
import HubertRoszyk.company.database.DatabaseMechanicManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateMechanicsStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        List<String> mechnaicInputData;
        mechnaicInputData = Main.textManager.getMechanicAccount();
        int accountId = Main.listManager.accounts.size() + 1;
        MechanicData mechanic = new MechanicData(mechnaicInputData.get(0), mechnaicInputData.get(1), "", "mechanic", accountId, mechnaicInputData.get(2));

        DatabaseMechanicManager.addMechanicToDatabase(mechanic);
        DatabaseAccountManager.addAccountToDatabase(mechanic);
        Main.listManager.mechanics.add(mechanic);
    }
}
