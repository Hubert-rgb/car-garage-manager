package HubertRoszyk.company;

import HubertRoszyk.company.strategyMain.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MainMechanicPage {
    static HashMap<Integer, MenuItemStrategy> menuStrategies = new HashMap(){{
        put(1, new ShowCarsStrategy());
        put(2, new AddingCarsForRepairingStrategy());
        put(3, new ShowCarsInRepairStrategy());
        put(4, new ShowCarsInNotRepairStrategy());
        put(5, new AddingCarsForRepairedStrategy());
        put(6, new ShowCarsRepairedStrategy());
        put(7, new ProgramShutDownStrategy());
    }};
    public MainMechanicPage() throws IOException, SQLException {
        while (Main.isOn) {
            Main.textManager.mechanicInfoDisplay();

            int action;
            action = Main.textManager.actionInscrybing();

            if(menuStrategies.containsKey(action)) {
                MenuItemStrategy strategy = menuStrategies.get(action);
                strategy.run();
            } else {
                System.out.println("Brak Strategi dla akcji nr:" + action);
            }
        }
    }
}
