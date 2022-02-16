package HubertRoszyk.company;

import HubertRoszyk.company.database.DatabaseCarManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarData { //dostęp do plików
    public List<String> carData = new ArrayList<String>();
    public String mark;
    public String model;
    public String plate;
    public int id;
    public String status;
    TextManager mainClassManager = new TextManager();

    public CarData(int i) throws SQLException {
        if (i == 1) {
            this.carData = mainClassManager.getCarData();
            mark = carData.get(0);
            model = carData.get(1);
            plate = carData.get(2);
            id = Main.listManager.cars.size() + 1;
            carData.add(Integer.toString(id));
            status = "BeforRepair";
            carData.add(status);

            DatabaseCarManager.addCarToDatabase(id, mark, model, plate, status);
        }
    }
    public CarData(List<String> carData) {
        this.carData = carData;
        mark = carData.get(0);
        model = carData.get(1);
        plate = carData.get(2);
        id = Integer.parseInt(carData.get(3));
        status = carData.get(4);
    }
}