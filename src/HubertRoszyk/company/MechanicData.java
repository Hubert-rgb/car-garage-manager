package HubertRoszyk.company;
import HubertRoszyk.company.database.DatabaseMechanicManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MechanicData {
    TextManager mainClassManager = new TextManager();
    List<String> mechanicData = new ArrayList<String>();
    String firstName, lastName;
    int id;

    public MechanicData(int i) throws SQLException {
        if(i == 1) {
            this.mechanicData = mainClassManager.getMechanicData();
            this.firstName = mechanicData.get(0);
            this.lastName = mechanicData.get(1);
            this.id = Main.listManager.mechanics.size() + 1;
            this.mechanicData.add(Integer.toString(id));

            DatabaseMechanicManager.addMechanicToDatabase(id, firstName, lastName);
        }
    }
    public MechanicData(List<String> mechanicData) {
        this.mechanicData = mechanicData;
        firstName = mechanicData.get(0);
        lastName = mechanicData.get(1);
        id = Integer.parseInt(mechanicData.get(2));
    }
}