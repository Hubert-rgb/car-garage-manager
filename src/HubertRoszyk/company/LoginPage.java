package HubertRoszyk.company;

import HubertRoszyk.company.strategyLogin.LoginItemStrategy;
import HubertRoszyk.company.strategyLogin.LoginStrategy;
import HubertRoszyk.company.strategyLogin.SigninStrategy;
import HubertRoszyk.company.strategyMain.MenuItemStrategy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginPage {
    static HashMap<Integer, LoginItemStrategy> loginStrategies = new HashMap<>(){{
        put(1, new LoginStrategy());
        put(2, new SigninStrategy());
    }};
    public LoginPage() throws IOException, SQLException {
        Main.textManager.landingPageInfoDisplay();

        int action;
        action = Main.textManager.actionInscrybing();

        if(loginStrategies.containsKey(action)) {
            LoginItemStrategy strategy = loginStrategies.get(action);
            strategy.run();
        } else {
            System.out.println("Brak Strategi dla akcji nr:" + action);
        }
    }
}
