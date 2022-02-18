package HubertRoszyk.company;

import HubertRoszyk.company.database.DatabaseCarManager;
import HubertRoszyk.company.database.DatabaseRepairManager;

import java.sql.SQLException;
import java.util.*;

public class AddingCarsForRepaired {
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    public void managerAdd() throws SQLException {
        if(Main.listManager.carsInRepair.size() < 1) {
            System.out.println("Nie ma żadnego samochodu w naprawie");
        } else {
            System.out.println("wpisz numer id samochodu, który chcesz oznaczyć jako naprawiony");
            Main.textManager.carDispay(Main.listManager.carsInRepair);
            String carNumString = scanner.next();
            int carNum = validator.stringToInt(carNumString);
            if(carNum == -1 || carNum == -10) {
                return;
            }

            if(!validator.isCarNumValid(Main.listManager.carsInRepair, carNum)) {
                System.out.println("Podaj numer id samochodu, który należączy do wcześniej wyświetlonego zbioru");
            } else {
                for (int i = 0; i < Main.listManager.carsInRepair.size(); i++) {
                    if (Main.listManager.carsInRepair.get(i).id == carNum) {
                        Main.listManager.carsInRepair.get(i).status = "Repaired";
                        Main.listManager.carsRepaired.add(Main.listManager.carsInRepair.get(i));
                        DatabaseCarManager.updateCarsTable(Main.listManager.carsInRepair.get(i).status, carNum);
                        int mechanicId = DatabaseRepairManager.getRepairValuesFromDatabase("repairongoing",carNum);
                        DatabaseRepairManager.addRepairToDatabase(carNum, mechanicId, "repairdone");
                        DatabaseRepairManager.deleteRepairFromDatabase("repairongoing", carNum);
                        Main.listManager.carsInRepair.remove(Main.listManager.carsInRepair.get(i));

                        int mechanicNum = -1;
                        int outerLoopRepetition = 0;
                        Set<Map.Entry<Integer, List<Integer>>> hashmapEntrySet = Main.listManager.carsInRepairHashMap.entrySet();
                        int innerLoopRepetition = 0;
                        int mechanicsCar = -1;
                        for (Map.Entry<Integer, List<Integer>> entry : hashmapEntrySet) { //jak to działa?
                            for (outerLoopRepetition=0; outerLoopRepetition < entry.getValue().size(); outerLoopRepetition++) {
                                List<Integer> ent = new ArrayList<>();
                                
                                ent = entry.getValue();
                                if (ent.get(outerLoopRepetition) == carNum) {
                                    mechanicNum = entry.getKey();
                                    break;
                                }
                                innerLoopRepetition++;
                            }
                        }
                        for(int j = 0; j < Main.listManager.carsInRepairHashMap.get(mechanicNum).size(); j++) {
                            if(carNum == Main.listManager.carsInRepairHashMap.get(mechanicNum).get(j)) {
                                mechanicsCar = j;
                            }
                        }
                        List<Integer> carsInMechanicsRepair = Main.listManager.carsInRepairHashMap.get(mechanicNum);
                        carsInMechanicsRepair.remove(mechanicsCar);
                        Main.listManager.carsInRepairHashMap.put(mechanicNum, carsInMechanicsRepair);

                    }

                }
                System.out.println("Samochód został naprawiony!");
            }
        }
    }
    public void mechanicAdd() throws SQLException {
        List<Integer> carNumsList = Main.listManager.carsInRepairHashMap.get(Main.listManager.loggedAccount.id);

        List<CarData> carsInMechanicRepair = new ArrayList<>();
        if (!validator.isMechanicRepairingCar(carNumsList)) {
            System.out.println("Nie naprawiasz żadnego samochodu");
        } else {
            for (Integer carNum : carNumsList) {
                for (CarData car : Main.listManager.carsInRepair) {
                    if (car.id == carNum) {
                        carsInMechanicRepair.add(car);
                    }
                }
            }

            System.out.println("wpisz numer id samochodu, który chcesz oznaczyć jako naprawiony");
            Main.textManager.carDispay(carsInMechanicRepair);
            String carNumString = scanner.next();
            int carNum = validator.stringToInt(carNumString);
            if(carNum == -1 || carNum == -10) {
                return;
            }

            if(!validator.isCarNumValid(carsInMechanicRepair, carNum)) {
                System.out.println("Podaj numer id samochodu, który należączy do wcześniej wyświetlonego zbioru");
            } else {
                for (int i = 0; i < Main.listManager.carsInRepair.size(); i++) {
                    if (Main.listManager.carsInRepair.get(i).id == carNum) {
                        Main.listManager.carsInRepair.get(i).status = "Repaired";
                        Main.listManager.carsRepaired.add(Main.listManager.carsInRepair.get(i));
                        DatabaseCarManager.updateCarsTable(Main.listManager.carsInRepair.get(i).status, carNum);
                        int mechanicId = DatabaseRepairManager.getRepairValuesFromDatabase("repairongoing",carNum);
                        DatabaseRepairManager.addRepairToDatabase(carNum, mechanicId, "repairdone");
                        DatabaseRepairManager.deleteRepairFromDatabase("repairongoing", carNum);
                        Main.listManager.carsInRepair.remove(Main.listManager.carsInRepair.get(i));

                        int mechanicNum = 0;
                        int outerLoopRepetition = 0;
                        Set<Map.Entry<Integer, List<Integer>>> hashmapEntrySet = Main.listManager.carsInRepairHashMap.entrySet();
                        int innerLoopRepetition = 0;
                        int mechanicsCar = -1;
                        for (Map.Entry<Integer, List<Integer>> entry : hashmapEntrySet) { //jak to działa?
                            for (outerLoopRepetition=0; outerLoopRepetition < entry.getValue().size(); outerLoopRepetition++) {
                                List<Integer> ent;

                                ent = entry.getValue();
                                if (ent.get(outerLoopRepetition) == carNum) {
                                    mechanicNum = entry.getKey();
                                    break;
                                }
                                innerLoopRepetition++;
                            }
                        }
                        for(int j = 0; j < Main.listManager.carsInRepairHashMap.get(mechanicNum).size(); j++) {
                            if(carNum == Main.listManager.carsInRepairHashMap.get(mechanicNum).get(j)) {
                                mechanicsCar = j;
                            }
                        }
                        List<Integer> carsInMechanicsRepair = Main.listManager.carsInRepairHashMap.get(mechanicNum);
                        carsInMechanicsRepair.remove(mechanicsCar);
                        Main.listManager.carsInRepairHashMap.put(mechanicNum, carsInMechanicsRepair);

                    }

                }
                System.out.println("Samochód został naprawiony!");
            }
        }
    }
}
