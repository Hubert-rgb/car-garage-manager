package HubertRoszyk.company.strategy;

import HubertRoszyk.company.Main;

public class ShowMechanicsStrategy implements MenuItemStrategy{
    public void run() {
        Main.textManager.mechanicDisplay();
    }
}
