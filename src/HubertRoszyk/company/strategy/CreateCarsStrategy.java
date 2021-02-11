package HubertRoszyk.company.strategy;

import HubertRoszyk.company.CarData;
import HubertRoszyk.company.ListManager;

public class CreateCarsStrategy implements MenuItemStrategy{
    public void run(){
        ListManager listManager = ListManager.getInstance();
        CarData car = new CarData(1);
        listManager.cars.add(car);
        listManager.carsInNotRepair.add(car);
    }
}