package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.List;

public class MechanicData {
    TextManager mainClassManager = new TextManager();
    List<String> mechanicData = new ArrayList<String>();
    String firstName, lastName;
    int id;

    public MechanicData(int i) {
        if(i == 1) {
            this.mechanicData = mainClassManager.getMechanicData();
            this.firstName = mechanicData.get(0);
            this.lastName = mechanicData.get(1);
            this.id = Main.listManager.mechanics.size() + 1;
            this.mechanicData.add(Integer.toString(id));
        }
    }
    MechanicData(List<String> mechanicData) {
        this.mechanicData = mechanicData;
        firstName = mechanicData.get(0);
        lastName = mechanicData.get(1);
        id = Integer.parseInt(mechanicData.get(2));
    }
}