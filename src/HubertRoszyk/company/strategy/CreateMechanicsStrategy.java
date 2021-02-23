package HubertRoszyk.company.strategy;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.MechanicData;

public class CreateMechanicsStrategy implements MenuItemStrategy{
    public void run(){
        MechanicData mechanic = new MechanicData(1);
        Main.listManager.mechanics.add(mechanic);
    }
}
