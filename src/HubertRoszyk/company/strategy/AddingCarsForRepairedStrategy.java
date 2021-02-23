package HubertRoszyk.company.strategy;

import HubertRoszyk.company.AddingCarsForRepaired;

public class AddingCarsForRepairedStrategy implements MenuItemStrategy{
    public void run() {
        //oznaczanie samochodów jako naprawione
        AddingCarsForRepaired addingCarsForRepaired = new AddingCarsForRepaired();
        addingCarsForRepaired.addingCarsForRepeared();
    }
}
