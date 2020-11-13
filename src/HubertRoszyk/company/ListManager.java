package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import HubertRoszyk.company.StorageManager;

public class ListManager {
    StorageManager carsStorage = new StorageManager("Cars.txt");
    List<String[]> cars = new ArrayList<String[]>();

    cars = carsStorage.readCar();

    List<MechanicData> mechanics = new ArrayList<MechanicData>();
    List<String[]> mechanicsData = new ArrayList<String[]>();

    StorageManager  mechanicsManager = new StorageManager("Mechanics.txt");

    mechanics = .readMechanic();
    mechani

    List<String[]> carsInRepair = new ArrayList<String[]>();

        storageManager.readCar(carsInRepair, "CarsInRepair.txt");

    List<String[]> carsInNotRepair = new ArrayList<String[]>();
        storageManager.readCar(carsInNotRepair, "CarsInNotRepair.txt");

    List<String[]> carsRepaired = new ArrayList<String[]>();

        storageManager.readCar(carsRepaired, "CarsRepaired.txt");
}
