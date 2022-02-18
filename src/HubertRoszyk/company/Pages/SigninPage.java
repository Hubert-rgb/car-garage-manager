package HubertRoszyk.company.Pages;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.strategyLogin.signinStrategy.*;
import HubertRoszyk.company.strategyMain.MenuItemStrategy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class SigninPage {
    static HashMap<Integer, SigninItemStrategy> signinStrategies = new HashMap<>(){{
       put(1, new ManagerSignin());
       put(2, new MechanicSingin());
       put(3, new UserSignin());
    }};
    public SigninPage() throws IOException, SQLException {
        Main.textManager.signinPageInfoDisplay();

        int action;
        action = Main.textManager.actionInscrybing();
        if (action != -10) {
            if(signinStrategies.containsKey(action)) {
                SigninItemStrategy strategy = signinStrategies.get(action);
                strategy.run();
            } else {
                System.out.println("Brak Strategi dla akcji nr:" + action);
            }
        }
    }
}
