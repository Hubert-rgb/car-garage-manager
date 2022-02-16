package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.AddingCarsForRepairing;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.TextManager;
import HubertRoszyk.company.Validator;
import HubertRoszyk.company.database.DatabaseCarManager;
import HubertRoszyk.company.database.DatabaseRepairManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingCarForRepairingMechanicStrategy implements MenuItemStrategy{
    @Override
    public void run() throws IOException, SQLException {
        AddingCarsForRepairing addingCarsForRepairing = new AddingCarsForRepairing();
        addingCarsForRepairing.mechanicAdd();
    }
}
