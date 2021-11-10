package HubertRoszyk.company;

import java.io.IOException;
import java.sql.SQLException;

public class ProgramShutDown {
    public void ShutDown() throws IOException, SQLException {
        MechanicsStorageManager mechanicManager = new MechanicsStorageManager("Mechanics.txt");
        mechanicManager.deleteContent();
        //dodawanie mechaników do pliku
        for (int i = 0; i < Main.listManager.mechanics.size(); i++) {
            mechanicManager.write(Main.listManager.mechanics.get(i).mechanicData);
        }
        //zapisywanie HashMap
        HashmapStorageManager hashmapManager = new HashmapStorageManager("HashMap.txt");
        hashmapManager.deleteContent();
        hashmapManager.write(Main.listManager.carsInRepairHashMap);
        //dodawanie samochodów do pliku tekstowego
        CarsStorageManager carsManager = new CarsStorageManager("Cars.txt");

        carsManager.deleteContent();

        carsManager.write(Main.listManager.cars);
    }
}
