package HubertRoszyk.company;
import HubertRoszyk.company.database.DatabaseAccountManager;
import HubertRoszyk.company.database.DatabaseCarManager;
import HubertRoszyk.company.database.DatabaseMechanicManager;
import HubertRoszyk.company.database.DatabaseRepairManager;

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

    public List<CarData> cars = new ArrayList<>();
    public List<AccountData> accounts = new ArrayList<>();
    public List<MechanicData> mechanics = new ArrayList<>();
    public List<CarData> carsInNotRepair = new ArrayList<>();
    public List<CarData> carsInRepair = new ArrayList<>();
    public List<CarData> carsRepaired = new ArrayList<>();
    public HashMap<String, List<String>> carsInRepairHashMap = new HashMap<>();

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
        accounts = DatabaseAccountManager.getAccountsFromDatabase();
        mechanics = DatabaseMechanicManager.getMechanicsFromDatabase();
        carsInRepairHashMap = DatabaseRepairManager.getRepairsFromDatabase("repairongoing");
    }
}
