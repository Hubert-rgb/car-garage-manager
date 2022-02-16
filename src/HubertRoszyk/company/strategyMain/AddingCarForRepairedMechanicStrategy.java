package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.AddingCarsForRepaired;
import HubertRoszyk.company.AddingCarsForRepairing;

import java.io.IOException;
import java.sql.SQLException;

public class AddingCarForRepairedMechanicStrategy implements MenuItemStrategy {
    @Override
    public void run() throws IOException, SQLException {
        AddingCarsForRepaired addingCarsForRepaired = new AddingCarsForRepaired();
        addingCarsForRepaired.mechanicAdd();
    }
}
