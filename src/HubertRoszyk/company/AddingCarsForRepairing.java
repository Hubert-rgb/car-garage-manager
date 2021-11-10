package HubertRoszyk.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingCarsForRepairing {
    Validator validator = new Validator();
    public void addingCarsForRepairing() throws SQLException { //może konstruktor?
        TextManager textManager = new TextManager();
        Scanner scanner = new Scanner(System.in);
        if(Main.listManager.carsInNotRepair.size() == 0){
            System.out.println("Nie ma żadnego samochodu czekającego na naprawę");
        } else if (Main.listManager.mechanics.size() <= 0) {
            System.out.println("Nie ma żadnego mechanika w bazie danych");
        } else {
            System.out.println("wpisz numer samochodu");

            textManager.carDispay(Main.listManager.carsInNotRepair);

            String carNumString = scanner.next();
            int carNum = validator.stringToInt(carNumString);
            if(carNum == -1) {
                return;
            }

            System.out.println("wpisz numer pracownika");

            textManager.mechanicDisplay();

            String mechanicNumString = scanner.next();  //wpisywać string
            int mechanicNum = validator.stringToInt(mechanicNumString);//isValid
            if(mechanicNum == -1) {
                return;
            }

            mechanicNumString = Integer.toString(mechanicNum);

            //System.out.println(carNumString + " " + mechanicNumString);
            //System.out.println(Main.listManager.carsInRepairHashMap.get(mechanicNumString));

            if(!validator.isCarNumValid(Main.listManager.carsInNotRepair, carNum)) {
                System.out.println("Podaj numer id samochodu, który należączy do wcześniej wyświetlonego zbioru");
            } if(!validator.isMechanicNumValid(Main.listManager.mechanics, mechanicNum)) {
                System.out.println("Podaj numer id mechanika, z pośród tych których wcześniej wyświetlono");
            } else if (Main.listManager.carsInRepairHashMap.get(mechanicNumString) == null || Main.listManager.carsInRepairHashMap.get(mechanicNumString).size() < 2) { //isValid i co jeśli nie należy do zobioru
                List<String> carsAddedToMechanicsList = new ArrayList<String>();
                if(Main.listManager.carsInRepairHashMap.get(mechanicNumString) == null) {  //zmiany
                } else if((Main.listManager.carsInRepairHashMap.get(mechanicNumString)) != null) {
                    carsAddedToMechanicsList.add((Main.listManager.carsInRepairHashMap.get(mechanicNumString)).get(0));     //bardziej uniwersalnie można zrobić na for ale teraz jest tylko 1 wartość
                }
                carsAddedToMechanicsList.add(carNumString);
                Main.listManager.carsInRepairHashMap.put(mechanicNumString, carsAddedToMechanicsList);
                Main.listManager.cars.get(carNum-1).status = "InRepair";
                Main.listManager.carsInRepair.add(Main.listManager.cars.get(carNum - 1));
                Main.listManager.carsInNotRepair.remove(Main.listManager.cars.get(carNum - 1));

                DatabaseCarManager.updateCarsTable(Main.listManager.cars.get(carNum-1).status, carNum);
                DatabaseRepairManager.addRepairToDatabase(carNum, mechanicNum, "repairongoing");

                System.out.println("dodano samochód do naprawy");
            } else {
                System.out.println("Mechanik naprawia już dwa samochody");
            }
        }
    }
}
