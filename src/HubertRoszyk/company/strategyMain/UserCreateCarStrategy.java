package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.CarData;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.UserData;
import HubertRoszyk.company.database.DatabaseUserManager;

import java.sql.SQLException;
import java.util.List;

public class UserCreateCarStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        ListManager listManager = ListManager.getInstance();
        CarData car = new CarData(1);
        listManager.cars.add(car);
        listManager.carsInNotRepair.add(car);

        for (int i = 0; i < Main.listManager.users.size(); i++) {
            UserData user = Main.listManager.users.get(i); //nie ma tam świerzo stworzonego konta i trzbea zdebugować databaseUser
            if (Main.listManager.loggedAccount.id == user.id) {
                List<Integer> carNums;
                carNums = user.carNums;
                carNums.add(car.id);
                user.carNums = carNums;
                DatabaseUserManager.updateUserInDatabase(user);
                System.out.println("Dodano samochód do naprawy");
            }
        }
    }
}
