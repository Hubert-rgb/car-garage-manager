package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;

public class ShowCarsStrategy implements MenuItemStrategy{
    public void run(){
        // wyświetla tylko nienaprawiane samochody
        Main.textManager.carDispay(Main.listManager.cars);
    }
}
