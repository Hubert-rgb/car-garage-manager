package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MechanicData;

import java.sql.SQLException;

public class CreateMechanicsStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        MechanicData mechanic = new MechanicData(1);
        Main.listManager.mechanics.add(mechanic);
    }
}
