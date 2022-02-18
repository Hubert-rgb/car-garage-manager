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
        } else if (stringOfValue.equals("esc")) {
            return -10;
        } else {
            System.out.println("Wpisz liczbę, a nie znak");
            return -1;
        }
    }
    public boolean isItEscape (String in) {
        if (in.equals("esc")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isCarNumValid(List<CarData> cars, int carNum) {
        int k = 0;
        for (CarData car : cars) {
            if (car.id == carNum) {
                k++;
            }
        }
        if(k == 0) {
            return false;
        } else {
            System.out.println(k);
            return true;
        }
    }
    public boolean isMechanicNumValid(List<MechanicData> mechanics, int mechanicNum) {
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
    public boolean isMechanicRepairingCar(List<Integer> carNums) {
        int size = -1;
        try {
            size = carNums.size();
        } catch (Exception ignored) {
            System.out.println(ignored);
            return false;
        }
        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }
}
