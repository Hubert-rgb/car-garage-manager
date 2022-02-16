package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.AddingCarsForRepaired;

import java.sql.SQLException;

public class AddingCarForRepairedStrategy implements MenuItemStrategy{
    public void run() throws SQLException {
        //oznaczanie samochodów jako naprawione
        AddingCarsForRepaired addingCarsForRepaired = new AddingCarsForRepaired();
        addingCarsForRepaired.managerAdd();
    }
}
