package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.AddingCarsForRepairing;

import java.sql.SQLException;

public class AddingCarsForRepairingStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        //dodawanie samochodu do naprawy
        AddingCarsForRepairing addingCarsForRepairing = new AddingCarsForRepairing();
    }
}