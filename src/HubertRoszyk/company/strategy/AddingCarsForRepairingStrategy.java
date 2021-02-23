package HubertRoszyk.company.strategy;

import HubertRoszyk.company.AddingCarsForRepairing;

public class AddingCarsForRepairingStrategy implements MenuItemStrategy{
    public void run() {
        //dodawanie samochodu do naprawy
        AddingCarsForRepairing addingCarsForRepairing = new AddingCarsForRepairing();
        addingCarsForRepairing.addingCarsForRepairing();
    }
}
