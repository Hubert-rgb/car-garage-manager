package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.CarData;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.database.DatabaseUserManager;

import java.sql.SQLException;

public class CreateCarsStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        ListManager listManager = ListManager.getInstance();
        CarData car = new CarData(1);
        listManager.cars.add(car);
        listManager.carsInNotRepair.add(car);
    }
}