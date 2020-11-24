package HubertRoszyk.company;

import java.util.*;

public class AddingCarsForRepaired {
    Scanner scanner = new Scanner(System.in);
    TextManager textManager = new TextManager();
    Validator validator = new Validator();
    void addingCarsForRepeared() {
        if(Main.listManager.carsInRepair.size() < 1) {
            System.out.println("Nie ma żadnego samochodu w naprawie");
        } else {
            System.out.println("wpisz numer id samochodu, który chcesz oznaczyć jako naprawiony");
            textManager.carDispay(Main.listManager.carsInRepair);
            String carNumString = scanner.next();
            int carNum = validator.stringToInt(carNumString);
            if(carNum == -1) {
                return;
            }
            if(!validator.isCarNumValid(Main.listManager.carsInNotRepair, carNum)) {
                System.out.println("Podaj numer id samochodu, który należączy do wcześniej wyświetlonego zbioru");
            } else {
                for (int i = 0; i < Main.listManager.carsInRepair.size(); i++) {
                    if (Main.listManager.carsInRepair.get(i).id == carNum) {
                        Main.listManager.carsRepaired.add(Main.listManager.carsInRepair.get(i));
                        Main.listManager.carsInRepair.get(i).status = "Repaired";
                        Main.listManager.carsInRepair.remove(Main.listManager.carsInRepair.get(i));

                        String mechanicNum = null;
                        int outerLoopRepetition = 0;
                        Set<Map.Entry<String, List<String>>> hashmapEntrySet = Main.listManager.carsInRepairHashMap.entrySet();
                        int innerLoopRepetition = 0;
                        for (Map.Entry<String, List<String>> entry : hashmapEntrySet) { //jak to działa?
                            for (; outerLoopRepetition < entry.getValue().size(); outerLoopRepetition++) {
                                List<String> ent = new ArrayList<String>();
                                ent = entry.getValue();
                                if (ent.get(outerLoopRepetition).equals(carNumString)) {
                                    mechanicNum = entry.getKey();
                                    break;
                                }
                                innerLoopRepetition++;
                            }
                        }
                        List<String> carsInMechanicsRepair = Main.listManager.carsInRepairHashMap.get(mechanicNum);
                        carsInMechanicsRepair.remove(innerLoopRepetition - outerLoopRepetition);
                        Main.listManager.carsInRepairHashMap.put(mechanicNum, carsInMechanicsRepair);
                    }

                }
                System.out.println("Samochód został naprawiony!");
            }
        }
    }

}
