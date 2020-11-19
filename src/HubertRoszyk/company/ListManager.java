package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

public class ListManager {
    //hashmap
    CarsStorageManager carsManager = new CarsStorageManager("Cars.txt");
    CarsStorageManager carsInRepairManager = new CarsStorageManager("CarsInRepair.txt");
    CarsStorageManager carsRepairedManager = new CarsStorageManager("CarsRepaired.txt");
    CarsStorageManager carsBeforRepairManager = new CarsStorageManager("CarsInNotRepair.txt");
    MechanicsStorageManager mechanicsManager = new MechanicsStorageManager("Mechanics.txt");
    HashmapStorageManager hashmapManager = new HashmapStorageManager("HashMap.txt");
    List<CarData> cars = new ArrayList<CarData>();
    List<MechanicData> mechanics = new ArrayList<MechanicData>();
    List<CarData> carsInNotRepair = new ArrayList<CarData>();
    List<CarData> carsInRepair = new ArrayList<CarData>();
    List<CarData> carsRepaired = new ArrayList<CarData>();
    HashMap<String, List<String>> carsInRepairHashMap = new HashMap<String, List<String>>();
    void listManagerReading() throws IOException {

        cars = carsManager.readCar();
        for(int i = 0; i < cars.size(); i++) {
            switch (cars.get(i).status) {
                case "BeforRepair" :
                    carsInNotRepair.add(cars.get(i));
                    break;
                case "InRepair" :
                    carsInRepair.add(cars.get(i));
                    break;
                case "Repaired" :
                    carsRepaired.add(cars.get(i));
                    break;
            }
        }
        /*carsInNotRepair = carsInNotRepairManager.readCar();
        carsInRepair = carsInRepairManager.readCar();
        carsRepaired = carsRepairedManager.readCar();*/
        mechanics = mechanicsManager.readMechanic();
        carsInRepairHashMap = hashmapManager.readHashmap();
    }
}
