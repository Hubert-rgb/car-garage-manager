package HubertRoszyk.company;
import java.io.*;

public class Main {
    public static ListManager listManager = new ListManager();

    public static void main(String[] args) throws IOException {
        listManager.listManagerReading();
        boolean isOn = true;
        MainClassManager menuManager = new MainClassManager();

        while (isOn == true) {
            menuManager.infoDisplay();

            int action;
            action = menuManager.actionInscrybing();

            switch (action) {
                case 1:
                    CarData car = new CarData(1);
                    listManager.cars.add(car);
                    listManager.carsInNotRepair.add(car);

                    break;
                case 2:
                    MechanicData mechanic = new MechanicData(1);
                    listManager.mechanics.add(mechanic);

                    break;
                case 3:
                    // wyświetla tylko nienaprawiane samochody
                    menuManager.carDispay(listManager.cars);   //status samochodu i ich identyfikatory
                    break;
                case 4:
                    menuManager.mechanicDisplay();
                    break;
                case 5:
                    //dodawanie samochodu do naprawy
                    AddingCarsForRepairingOld addingCarsForRepairing = new AddingCarsForRepairingOld();
                    addingCarsForRepairing.addingCarsForRepairing();
                    break;
                case 6:
                    //wyświetlanie aut w naprawie
                    menuManager.carDispay(listManager.carsInRepair);
                    break;
                case 7:
                    //wyświetlanie aut nie naprawianych
                    menuManager.carDispay(listManager.carsInNotRepair);
                    break;
                case 8:
                    //oznaczanie samochodów jako naprawione
                    AddingCarsForRepaired addingCarsForRepaired = new AddingCarsForRepaired();
                    addingCarsForRepaired.addingCarsForRepeared();
                    break;
                case 9:
                    //wypidywanie naprawionych samochodów
                    menuManager.carDispay(listManager.carsRepaired);
                    break;
                case 10:
                    isOn = false;
                    ProgramShutDown programShutDown = new ProgramShutDown();
                    programShutDown.ShutDown();
                    break;
                case 11 :
                    //dodatek usuwanie zawartości plików tekstowych
                    listManager.carsManager.deleteContent();
                    listManager.carsInRepairManager.deleteContent();
                    listManager.carsBeforRepairManager.deleteContent();
                    listManager.carsRepairedManager.deleteContent();
                    listManager.mechanicsManager.deleteContent();

                    listManager.cars.removeAll(listManager.cars);//removeall
                    listManager.carsInRepair.removeAll(listManager.carsInRepair);
                    listManager.carsRepaired.removeAll(listManager.carsRepaired);
                    listManager.mechanics.removeAll(listManager.mechanics);
                    listManager.carsInNotRepair.removeAll(listManager.carsInNotRepair);
                case 12:
                    System.out.println(listManager.carsInRepairHashMap);
                    System.out.println(listManager.carsInRepairHashMap.get("1"));
            }
        }
    }
}


