package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.List;

class MechanicData { //data zmienić na 2 dane
    MainClassManager mainClassManager = new MainClassManager();//dużo metod
    //int repearingCars = 0;
    //List<CarData> repairingCarsList = new ArrayList<CarData>();
    List<String> mechanicData = new ArrayList<String>();
    String firstName, lastName;
    int id;
    //List<String> repearingCars = new ArrayList<String>();

    MechanicData(int i) {
        if(i == 1) {
            this.mechanicData = mainClassManager.getMechanicData();
            this.firstName = mechanicData.get(0);
            this.lastName = mechanicData.get(1);
            //mechanicData.add(Integer.toString(repearingCars));
            this.id = Main.listManager.mechanics.size() + 1;
            this.mechanicData.add(Integer.toString(id));
            //Main.listManager.carsInRepairHashMap.put(Integer.toString(id), null); //nie działa
        }
    }
    MechanicData(List<String> mechanicData) {
        this.mechanicData = mechanicData;
        firstName = mechanicData.get(0);
        lastName = mechanicData.get(1);
        id = Integer.parseInt(mechanicData.get(2));
        //Main.listManager.carsInRepairHashMap.put(Integer.toString(id), repearingCars);
    }
}