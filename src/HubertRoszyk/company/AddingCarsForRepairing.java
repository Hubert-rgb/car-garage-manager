package HubertRoszyk.company;

import HubertRoszyk.company.database.DatabaseCarManager;
import HubertRoszyk.company.database.DatabaseRepairManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingCarsForRepairing {
    Validator validator = new Validator();
    public void managerAdd() throws SQLException { //może konstruktor?
        TextManager textManager = new TextManager();
        Scanner scanner = new Scanner(System.in);
        if (Main.listManager.carsInNotRepair.size() == 0) {
            System.out.println("Nie ma żadnego samochodu czekającego na naprawę");
        } else if (Main.listManager.mechanics.size() <= 0) {
            System.out.println("Nie ma żadnego mechanika w bazie danych");
        } else {
            System.out.println("wpisz numer samochodu");

            textManager.carDispay(Main.listManager.carsInNotRepair);

            String carNumString = scanner.next();
            int carNum = validator.stringToInt(carNumString);
            if (carNum == -1 || carNum == -10) {
                return;
            }

            System.out.println("wpisz numer pracownika");

            textManager.mechanicDisplay();

            String mechanicNumStringIn = scanner.next();  //wpisywać string
            int mechanicNum = validator.stringToInt(mechanicNumStringIn);//isValid
            if (mechanicNum == -1 || mechanicNum == -10) {
                return;
            }

            if (!validator.isCarNumValid(Main.listManager.carsInNotRepair, carNum)) {
                System.out.println("Podaj numer id samochodu, który należączy do wcześniej wyświetlonego zbioru");
            } else if (!validator.isMechanicNumValid(Main.listManager.mechanics, mechanicNum)) {
                System.out.println("Podaj numer id mechanika, z pośród tych których wcześniej wyświetlono");
            } else if (Main.listManager.carsInRepairHashMap.get(mechanicNum) == null || Main.listManager.carsInRepairHashMap.get(mechanicNum).size() < 2) { //isValid i co jeśli nie należy do zobioru
                List<Integer> carsAddedToMechanicsList = new ArrayList<>();
                if ((Main.listManager.carsInRepairHashMap.get(mechanicNum)) != null) {
                    carsAddedToMechanicsList.add((Main.listManager.carsInRepairHashMap.get(mechanicNum)).get(0));     //bardziej uniwersalnie można zrobić na for ale teraz jest tylko 1 wartość
                }
                carsAddedToMechanicsList.add(carNum);
                Main.listManager.carsInRepairHashMap.put(mechanicNum, carsAddedToMechanicsList);
                Main.listManager.cars.get(carNum - 1).status = "InRepair";
                Main.listManager.carsInRepair.add(Main.listManager.cars.get(carNum - 1));
                Main.listManager.carsInNotRepair.remove(Main.listManager.cars.get(carNum - 1));

                DatabaseCarManager.updateCarsTable(Main.listManager.cars.get(carNum - 1).status, carNum);
                DatabaseRepairManager.addRepairToDatabase(carNum, mechanicNum, "repairongoing");

                System.out.println("dodano samochód do naprawy");
            } else {
                System.out.println("Mechanik naprawia już dwa samochody");
            }
        }
    }
    public void mechanicAdd() throws SQLException {
        Validator validator = new Validator();
        TextManager textManager = new TextManager();
        Scanner scanner = new Scanner(System.in);

        int accountNum = Main.listManager.loggedAccount.id;
        if(Main.listManager.carsInNotRepair.size() == 0){
            System.out.println("Nie ma żadnego samochodu czekającego na naprawę");
        } else {
            System.out.println("wpisz numer samochodu");

            textManager.carDispay(Main.listManager.carsInNotRepair);

            String carNumString = scanner.next();
            int carNum = validator.stringToInt(carNumString);
            if (carNum == -1 || carNum == -10) {
                return;
            }

            if (!validator.isCarNumValid(Main.listManager.carsInNotRepair, carNum)) {
                System.out.println("Podaj numer id samochodu, który należączy do wcześniej wyświetlonego zbioru");
            } else if (Main.listManager.carsInRepairHashMap.get(accountNum) == null || Main.listManager.carsInRepairHashMap.get(accountNum).size() < 2) { //isValid i co jeśli nie należy do zobioru
                List<Integer> carsAddedToMechanicsList = new ArrayList<>();
                if ((Main.listManager.carsInRepairHashMap.get(accountNum)) != null) {
                    carsAddedToMechanicsList.add((Main.listManager.carsInRepairHashMap.get(accountNum)).get(0));     //bardziej uniwersalnie można zrobić na for ale teraz jest tylko 1 wartość
                }
                carsAddedToMechanicsList.add(carNum);
                Main.listManager.carsInRepairHashMap.put(accountNum, carsAddedToMechanicsList);
                Main.listManager.cars.get(carNum - 1).status = "InRepair";
                Main.listManager.carsInRepair.add(Main.listManager.cars.get(carNum - 1));
                Main.listManager.carsInNotRepair.remove(Main.listManager.cars.get(carNum - 1));

                DatabaseCarManager.updateCarsTable(Main.listManager.cars.get(carNum - 1).status, carNum);
                DatabaseRepairManager.addRepairToDatabase(carNum, accountNum, "repairongoing");

                System.out.println("dodano samochód do naprawy");
            } else {
                System.out.println("Mechanik naprawia już dwa samochody");
            }
        }
    }
}
