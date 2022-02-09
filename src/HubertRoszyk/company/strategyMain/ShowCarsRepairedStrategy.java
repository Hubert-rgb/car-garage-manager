package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;

public class ShowCarsRepairedStrategy implements MenuItemStrategy{
    public void run() {
        //wypidywanie naprawionych samochodów
        Main.textManager.carDispay(Main.listManager.carsRepaired);
    }
}
