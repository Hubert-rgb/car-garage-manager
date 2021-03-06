package HubertRoszyk.company.strategy;

import HubertRoszyk.company.Main;

import java.io.IOException;

public class DeleteContentStrategy implements MenuItemStrategy{
    public void run() throws IOException {
        //dodatek usuwanie zawartości plików tekstowych
        Main.listManager.carsManager.deleteContent();
        Main.listManager.carsInRepairManager.deleteContent();
        Main.listManager.carsBeforRepairManager.deleteContent();
        Main.listManager.carsRepairedManager.deleteContent();
        Main.listManager.mechanicsManager.deleteContent();

        Main.listManager.cars.removeAll(Main.listManager.cars);//removeall
        Main.listManager.carsInRepair.removeAll(Main.listManager.carsInRepair);
        Main.listManager.carsRepaired.removeAll(Main.listManager.carsRepaired);
        Main.listManager.mechanics.removeAll(Main.listManager.mechanics);
        Main.listManager.carsInNotRepair.removeAll(Main.listManager.carsInNotRepair);
    }
}
