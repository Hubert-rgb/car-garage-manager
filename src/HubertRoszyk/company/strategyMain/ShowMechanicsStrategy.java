package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;

public class ShowMechanicsStrategy implements MenuItemStrategy{
    public void run() {
        Main.textManager.mechanicDisplay();
    }
}
