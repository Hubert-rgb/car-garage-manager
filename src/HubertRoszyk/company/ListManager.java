package HubertRoszyk.company;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

public class ListManager {
    //hashmap
    private static ListManager instance;
    public static ListManager getInstance(){
        if(instance==null){
            instance = new ListManager();
        }
        return instance;
    }
    private ListManager() {}

    public CarsStorageManager carsManager = new CarsStorageManager("Cars.txt");
    public CarsStorageManager carsInRepairManager = new CarsStorageManager("CarsInRepair.txt");
    public CarsStorageManager carsRepairedManager = new CarsStorageManager("CarsRepaired.txt");
    public CarsStorageManager carsBeforRepairManager = new CarsStorageManager("CarsInNotRepair.txt");
    public MechanicsStorageManager mechanicsManager = new MechanicsStorageManager("Mechanics.txt");
    public HashmapStorageManager hashmapManager = new HashmapStorageManager("HashMap.txt");
    public List<CarData> cars = new ArrayList<CarData>();
    public List<MechanicData> mechanics = new ArrayList<MechanicData>();
    public List<CarData> carsInNotRepair = new ArrayList<CarData>();
    public List<CarData> carsInRepair = new ArrayList<CarData>();
    public List<CarData> carsRepaired = new ArrayList<CarData>();
    public HashMap<String, List<String>> carsInRepairHashMap = new HashMap<String, List<String>>();

    void listManagerReading() throws IOException, SQLException {

        //cars = carsManager.readCar();
        cars = DatabaseCarManager.getCarsFromDatabase();
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
        //mechanics = mechanicsManager.readMechanic();
        mechanics = DatabaseMechanicManager.getMechanicsFromDatabase();
        //carsInRepairHashMap = hashmapManager.readHashmap();
        carsInRepairHashMap = DatabaseRepairManager.getRepairsFromDatabase("repairongoing");
    }
}
