package HubertRoszyk.company.Pages;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.strategyMain.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MainUserPage {
    static HashMap<Integer, MenuItemStrategy> menuStrategies = new HashMap(){{
        put(1, new UserCreateCarStrategy());
        put(2, new ShowUserCarsStatusStrategy()); //ShowUserCars
        put(3, new ProgramShutDownStrategy());
    }};
    public MainUserPage() throws IOException, SQLException {
        while (Main.isOn) {
            Main.textManager.userInfoDisplay();

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
