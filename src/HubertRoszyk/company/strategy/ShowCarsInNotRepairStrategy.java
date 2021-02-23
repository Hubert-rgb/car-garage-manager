package HubertRoszyk.company.strategy;

import HubertRoszyk.company.Main;

public class ShowCarsInNotRepairStrategy implements MenuItemStrategy{
    public void run() {
        //wyświetlanie aut nie naprawianych
        Main.textManager.carDispay(Main.listManager.carsInNotRepair);
    }
}
