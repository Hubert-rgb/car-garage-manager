package HubertRoszyk.company.Pages;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.strategyMain.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MainManagerPage {
    static HashMap<Integer, MenuItemStrategy> menuStrategies = new HashMap(){{
        put(1, new CreateCarsStrategy());
        put(2, new CreateMechanicsStrategy());
        put(3, new ShowCarsStrategy());
        put(4, new ShowMechanicsStrategy());
        put(5, new AddingCarForRepairingStrategy());
        put(6, new ShowCarsInRepairStrategy());
        put(7, new ShowCarsInNotRepairStrategy());
        put(8, new AddingCarForRepairedStrategy());
        put(9, new ShowCarsRepairedStrategy());
        put(10, new ShowCarStatusStrategy());
        put(11, new ProgramShutDownStrategy());
        put(12, new DeleteContentStrategy());

    }};
    public MainManagerPage() throws IOException, SQLException {
        while (Main.isOn) {
            Main.textManager.managerInfoDisplay();

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
