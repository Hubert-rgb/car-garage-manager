package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.CarData;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.UserData;
import HubertRoszyk.company.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowUserCarsStatusStrategy implements MenuItemStrategy{
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        int sizeOfUsers = Main.listManager.users.size();
        int userId = -1;
        List<CarData> userCarsList = new ArrayList<>();

        for (int i = 0; i < sizeOfUsers; i++) {
           if (Main.listManager.users.get(i).id == Main.listManager.loggedAccount.id) {
               userId = i;
           }
        }
        UserData user = Main.listManager.users.get(userId);

        for (int i = 0; i < user.carNums.size(); i++) {
            userCarsList.add(Main.listManager.cars.get(user.carNums.get(i) - 1));
        }

        Main.textManager.carDispay(userCarsList);

        String carNumString = scanner.next();
        int carNum = validator.stringToInt(carNumString);

        if (user.carNums.contains(carNum)) {
            String carStatus = Main.listManager.cars.get(carNum - 1).status;
            System.out.println(carStatus);
        } else {
            System.out.println("wpisano niepoprawny numer");
        }


    }
}
