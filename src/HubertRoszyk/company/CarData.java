package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;

class CarData { //dostęp do plików
    public List<String> carData = new ArrayList<String>();
    String mark;
    String model;
    String plate;
    int id;
    public String status;
    MainClassManager mainClassManager = new MainClassManager();

    CarData(int i) {
        if (i == 1) {
            this.carData = mainClassManager.getCarData();
            mark = carData.get(0);
            model = carData.get(1);
            plate = carData.get(2);
            id = Main.listManager.cars.size() + 1;
            carData.add(Integer.toString(id));
            status = "BeforRepair";
            //carData.add(status);
        }
    }
    CarData(List<String> carData) {
        this.carData = carData;
        mark = carData.get(0);
        model = carData.get(1);
        plate = carData.get(2);
        id = Integer.parseInt(carData.get(3));
        status = carData.get(4);
    }
}