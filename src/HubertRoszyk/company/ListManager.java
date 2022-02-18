package HubertRoszyk.company;
import HubertRoszyk.company.database.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

public class ListManager {
    //hashmap
    private static ListManager instance;
    public static ListManager getInstance(){ //to jest singleton
        if(instance==null){
            instance = new ListManager();
        }
        return instance;
    }
    private ListManager() {}

    public AccountData loggedAccount;

    public List<CarData> cars = new ArrayList<>();
    public List<AccountData> accounts = new ArrayList<>();
    public List<UserData> users = new ArrayList<>();
    public List<ManagerData> managers = new ArrayList<>();
    public List<MechanicData> mechanics = new ArrayList<>();
    public List<CarData> carsInNotRepair = new ArrayList<>();
    public List<CarData> carsInRepair = new ArrayList<>();
    public List<CarData> carsRepaired = new ArrayList<>();
    public HashMap<Integer, List<Integer>> carsInRepairHashMap = new HashMap<>();

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
        users = DatabaseUserManager.getUsersFromDatabase();
        carsInRepairHashMap = DatabaseRepairManager.getRepairsFromDatabase("repairongoing");
    }
}
