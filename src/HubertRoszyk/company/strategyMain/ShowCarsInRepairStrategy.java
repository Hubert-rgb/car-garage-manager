package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;

public class ShowCarsInRepairStrategy implements MenuItemStrategy{
    public void run() {
        //wyświetlanie aut w naprawie
        Main.textManager.carDispay(Main.listManager.carsInRepair);
        //System.out.println(Main.listManager.carsInRepairHashMap);
    }
}