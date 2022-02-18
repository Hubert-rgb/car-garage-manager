package HubertRoszyk.company.strategyMain;

import HubertRoszyk.company.Main;
import HubertRoszyk.company.TextManager;
import HubertRoszyk.company.Validator;

import java.util.Scanner;

public class ShowCarStatusStrategy implements MenuItemStrategy{
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        Main.textManager.carDispay(Main.listManager.cars);

        String carNumString = scanner.next();
        int carNum = validator.stringToInt(carNumString);
        if(carNum == -1 || carNum == -10) {
            return;
        }

        String carStatus = Main.listManager.cars.get(carNum - 1).status;
        System.out.println(carStatus);
    }
}
