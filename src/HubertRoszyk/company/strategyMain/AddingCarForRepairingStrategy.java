package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.AddingCarsForRepairing;

import java.sql.SQLException;

public class AddingCarForRepairingStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        //dodawanie samochodu do naprawy
        AddingCarsForRepairing addingCarsForRepairing = new AddingCarsForRepairing();
        addingCarsForRepairing.managerAdd();
    }
}
