package HubertRoszyk.company;

import java.util.*;

public class AddingCarsForRepaired {
    Scanner scanner = new Scanner(System.in);
    MainClassManager mainClassManager = new MainClassManager();
    void addingCarsForRepeared() {
        if(Main.listManager.carsInRepair.size() < 1) {
            System.out.println("Nie ma żadnego samochodu w naprawie");
        } else {
            System.out.println("wpisz numer id samochodu, który chcesz oznaczyć jako naprawiony");
            mainClassManager.carDispay(Main.listManager.carsInRepair);
            int carNum = scanner.nextInt();

            for (int i = 0; i < Main.listManager.carsInRepair.size(); i++) {
                if(Main.listManager.carsInRepair.get(i).id == carNum) {
                    Main.listManager.carsRepaired.add(Main.listManager.carsInRepair.get(i));
                    Main.listManager.carsInRepair.get(i).status = "Repaired";
                    ;
                    Main.listManager.carsInRepair.remove(Main.listManager.carsInRepair.get(i));

                    String mechanicNum = null;
                    int j = 0;
                    Set<Map.Entry<String, List<String>>> s = Main.listManager.carsInRepairHashMap.entrySet();
                    int k = 0;
                    for (Map.Entry<String, List<String>> entry : s) {
                        for(; j < entry.getValue().size(); j++) {
                            List<String> ent = new ArrayList<String>();
                            ent = entry.getValue();
                            String carNumStr = Integer.toString(carNum);
                            if (ent.get(j).equals(carNumStr)) {
                                mechanicNum = entry.getKey();
                                break;
                            }
                            k++;
                        }
                    }
                    List<String> carsInMechanicsRepair = Main.listManager.carsInRepairHashMap.get(mechanicNum);
                    carsInMechanicsRepair.remove(k - j);
                    Main.listManager.carsInRepairHashMap.put(mechanicNum, carsInMechanicsRepair);
                }

            }
            System.out.println("Samochód został naprawiony!");
        }
    }

}
