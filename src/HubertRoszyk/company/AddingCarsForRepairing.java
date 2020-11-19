package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingCarsForRepairing {
    void addingCarsForRepairing() { //może konstruktor?
        MainClassManager mainClassManager = new MainClassManager();
        Scanner scanner = new Scanner(System.in);
        if(Main.listManager.carsInNotRepair.size() == 0){
            System.out.println("Nie ma żadnego samochodu czekającego na naprawę");
        } else if (Main.listManager.mechanics.size() <= 0) {
            System.out.println("Nie ma żadnego mechanika w bazie danych");
        } else {
            System.out.println("wpisz numer samochodu");

            mainClassManager.carDispay(Main.listManager.carsInNotRepair);

            int carNum = scanner.nextInt();

            System.out.println("wpisz numer pracownika");

            mainClassManager.mechanicDisplay();

            int mechanicNum = scanner.nextInt();  //wpisywać string
            String mechanicNumString = Integer.toString(mechanicNum);//isValid

            if (Main.listManager.carsInRepairHashMap.get(mechanicNumString) == null || Main.listManager.carsInRepairHashMap.get(mechanicNumString).size() < 2) { //isValid
                List<String> carsAddedToMechanicsList = new ArrayList<String>();
                if((Main.listManager.carsInRepairHashMap.get(mechanicNumString)) != null) {
                    carsAddedToMechanicsList.add((Main.listManager.carsInRepairHashMap.get(mechanicNumString)).get(0));     //bardziej uniwersalnie
                    System.out.println("dodaje");      //nie działa
                }
                carsAddedToMechanicsList.add(Integer.toString(carNum));
                Main.listManager.carsInRepairHashMap.put(mechanicNumString, carsAddedToMechanicsList);
                Main.listManager.cars.get(carNum-1).status = "InRepair";
                Main.listManager.carsInRepair.add(Main.listManager.cars.get(carNum - 1));
                Main.listManager.carsInNotRepair.remove(Main.listManager.cars.get(carNum - 1));
                System.out.println(Main.listManager.carsInNotRepair.size());
                System.out.println("dodano samochód do naprawy");
            } else {
                System.out.println("Mechanik naprawia już dwa samochody");
            }
        }
    }
}
