package HubertRoszyk.company;

import java.util.List;

public class Validator { //Singleton!!!
    boolean isItInt(String value) {

        try
        {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    public int stringToInt(String stringOfValue) {
        if (isItInt(stringOfValue)) {
            int value = Integer.parseInt(stringOfValue);
            return value;
        } else {
            System.out.println("Wpisz liczbę, a nie znak");
            return -1;
        }
    }
    boolean isCarNumValid(List<CarData> cars, int carNum) {
        int k = 0;
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).id == carNum || !cars.get(i).status.equals("BeforRepair")){
                k++;
            }
        }
        if(k == 0) {

            return false;
        } else {
            return true;
        }
    }
    boolean isMechanicNumValid(List<MechanicData> mechanics, int mechanicNum) {
        int k = 0;
        for (int i = 0; i < Main.listManager.mechanics.size(); i++) {
            if(Main.listManager.mechanics.get(i).id == mechanicNum){
                k++;
            }
        }
        if(k == 0) {
            return false;
        } else {
            return true;
        }
    }
}
