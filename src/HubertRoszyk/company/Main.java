package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import HubertRoszyk.company.*;
public class Main { // tablice na listy
// klasa dla scannera
    public static void main(String[] args) throws IOException {
        boolean isOn = true;
        MainClassManager menuManager = new MainClassManager();
        ListManager listManager = new ListManager();
        while (isOn == true) {
            menuManager.infoDisplay();

            int action;
            action = menuManager.actionInscrybing();

            switch (action) {
                case 1:
                    CarData car = new CarData();
                    String[] newCarData = car.getData();
                    listManager.cars.add(newCarData);
                    listManager.carsInNotRepair.add(newCarData);

                    break;
                case 2:
                    MechanicData mechanic = new MechanicData();
                    String[] data = mechanic.newData();
                    mechanic.data = data;
                    listManager.mechanics.add(mechanic);
                    listManager.mechanicsData.add(mechanic.data);

                    continue;
                case 3:
                    // wyświetla tylko nienaprawiane samochody
                     //kalsa main menue zamiast tego
                    menuManager.carDispay();
                    System.out. println("marka model rejestracja");
                    for (int i = 0; i < listManager.cars.size(); i++) {
                        String[] carData = listManager.cars.get(i);
                        System.out.print(listManager.cars.mark + " " + carData[1] + " " + carData[2]);
                        System.out.println();
                    }
                    continue;
                case 4:
                    System.out.println("imię nazwisko");
                    for (int j = 0; j < listManager.mechanics.size(); j++) { //stworzenie np. newCarDisplayer.show
                        String[] data1 = listManager.mechanics.get(j).data; //status samochodu i ich identyfikatory
                        System.out.print(data1[0] + " " + data1[1]);
                        System.out.println();
                    }
                    continue;
                case 5:
                    if(listManager.carsInNotRepair.size() <= 0){
                        System.out.println("Nie ma żadnego samochodu czekającego na naprawę");
                    } else if (listManager.mechanics.size() <= 0) {
                        System.out.println("Nie ma żadnego mechanika w bazie danych");
                    } else {
                        System.out.println("wpisz numer samochodu");

                        System.out. println("marka model rejestracja");

                        for (int i = 0; i < listManager.carsInNotRepair.size(); i++) {
                            String[] carData = listManager.carsInNotRepair.get(i);
                            System.out.print(i + 1 + " " + carData[0] + " " + carData[1] + " " + carData[2]);
                            System.out.println();
                        }
                        int carNum = scanner.nextInt();

                        System.out.println("wpisz numer pracownika");

                        System.out.println("imię nazwisko");

                        for (int j = 0; j < listManager.mechanics.size(); j++) {
                            listManager.mechanics.get(j);
                            String[] data2 = listManager.mechanics.get(j).data;
                            System.out.print(j + 1 + " " + data2[0] + " " + data2[1]);
                            System.out.println();
                        }

                        int mechanicNum = scanner.nextInt();

                        if (listManager.mechanics.get(mechanicNum - 1).repearingCars < 2) {
                            listManager.mechanics.get(mechanicNum - 1).repearingCars++;
                            listManager.carsInRepair.add(listManager.carsInNotRepair.get(carNum - 1));
                            listManager.mechanics.get(mechanicNum - 1).repairingCarsList.add(listManager.carsInNotRepair.get(carNum - 1));
                            listManager.carsInNotRepair.remove(listManager.carsInNotRepair.get(carNum - 1));
                            System.out.println("dodano samochód do naprawy");
                        } else {
                            System.out.println("Mechanik naprawia już dwa samochody");
                        }
                    }
                    continue;
                case 6:
                    System.out. println("marka model rejestracja");
                    for (int k = 0; k < listManager.carsInRepair.size(); k++) {
                        String[] carsData = listManager.carsInRepair.get(k);
                        System.out.print(carsData[0] + " " + carsData[1] + " " + carsData[2]);
                        System.out.println();
                    }
                    continue;
                case 7:
                    System.out. println("marka model rejestracja");
                    for (int k = 0; k < listManager.carsInNotRepair.size(); k++) {
                        String[] carsData = listManager.carsInNotRepair.get(k);
                        System.out.print(carsData[0] + " " + carsData[1] + " " + carsData[2]);
                        System.out.println();
                    }
                    continue;
                case 8:
                    if(listManager.carsInRepair.size() < 1) {
                        System.out.println("Nie ma żadnego samochodu w naprawie");
                    } else {
                        System.out.println("wpisz numer samochodu, który chcesz oznaczyć jako naprawiony");
                        System.out. println("marka model rejestracja");
                        for (int k = 0; k < listManager.carsInRepair.size(); k++) {
                            String[] carsData = listManager.carsInRepair.get(k);
                            System.out.print(k + 1 + " " + carsData[0] + " " + carsData[1] + " " + carsData[2]);
                            System.out.println();
                        }
                        int carNum1 = scanner.nextInt();

                        for (int i = 0; i < listManager.mechanics.size(); i++) {
                            for (int k = 0; k < listManager.mechanics.get(i).repairingCarsList.size(); k++) {
                                if (listManager.mechanics.get(i).repairingCarsList.get(k).equals(listManager.carsInRepair.get(carNum1 - 1))) {
                                    listManager.mechanics.get(i).repearingCars--;
                                    listManager.mechanics.get(i).repairingCarsList.remove(k);
                                }
                            }
                        }
                        listManager.carsRepaired.add(listManager.carsInRepair.get(carNum1 - 1));
                        /*for (int k = 0; k < carsSize; k++) {
                            if (carsInRepair.get(carNum1 - 1).equals(cars.get(k))){
                                cars.remove(cars.get(k));
                            }
                        }*/
                        listManager.cars.remove(listManager.carsInRepair.get(carNum1 - 1));
                        listManager.carsInRepair.remove(listManager.carsInRepair.get(carNum1 - 1));
                        System.out.println("Samochód został naprawiony!");
                    }
                    continue;
                case 9:
                    System.out. println("marka model rejestracja");
                    for (int k = 0; k < listManager.carsRepaired.size(); k++) {
                        String[] carsData = listManager.carsRepaired.get(k);
                        System.out.print(carsData[0] + " " + carsData[1] + " " + carsData[2]);
                        System.out.println();
                    }
                    continue;
                case 10:
                    isOn = false;
                    //dodawanie mechanics do pliku tekstowego
                    listManager.storageManager.delateContent("Mechanics.txt");
                    for (int i = 0; i < listManager.mechanics.size(); i++){

                        listManager.storageManager.write(listManager.mechanics.get(i).data, "Mechanics.txt", 2);
                        String repairingCars = Integer.toString(listManager.mechanics.get(i).repearingCars);
                        String [] repairingCarsArray = {repairingCars};
                        listManager.storageManager.write(repairingCarsArray, "Mechanics.txt", 1);

                        for (int k = 0; k < (listManager.mechanics.get(i).repairingCarsList.size()); k++){
                            listManager.storageManager.write(listManager.mechanics.get(i).repairingCarsList.get(k), "Mechanics.txt", 3);
                        }
                    }
                    //dodawanie samochodów do pliku tekstowego
                    listManager.storageManager.delateContent("Cars.txt");
                    listManager.storageManager.delateContent("CarsInRepair.txt");
                    listManager.storageManager.delateContent("CarsRepaired.txt");
                    listManager.storageManager.delateContent("CarsInNotRepair.txt");

                    for(int i = 0; i < listManager.cars.size(); i++) {
                        listManager.storageManager.write(listManager.cars.get(i), "Cars.txt", 3);
                    }
                    for(int i = 0; i < listManager.carsInRepair.size(); i++) {
                        listManager.storageManager.write(listManager.carsInRepair.get(i), "CarsInRepair.txt", 3);
                    }
                    for(int i = 0; i < listManager.carsRepaired.size(); i++) {
                        listManager.storageManager.write(listManager.carsRepaired.get(i), "CarsRepaired.txt", 3);
                    }
                    for(int i = 0; i < listManager.carsInNotRepair.size(); i++) {
                        listManager.storageManager.write(listManager.carsInNotRepair.get(i), "CarsInNotRepair.txt", 3);
                    }
                    continue;
                case 11 :
                    listManager.storageManager.delateContent("CarsRepaired.txt");
                    listManager.storageManager.delateContent("CarsInRepair.txt");
                    listManager.storageManager.delateContent("Cars.txt");
                    listManager.storageManager.delateContent("Mechanics.txt");
                    listManager.storageManager.delateContent("CarsInNotRepair.txt");

                    for(int i = 0; i < listManager.cars.size(); i++) { //removeall
                        listManager.cars.remove(i);
                    }
                    for(int i = 0; i < listManager.carsInRepair.size(); i++) {
                        listManager.carsInRepair.remove(i);
                    }
                    for(int i = 0; i < listManager.carsRepaired.size(); i++) {
                        listManager.carsRepaired.remove(i);
                    }
                    for(int i = 0; i < listManager.mechanics.size(); i++) {
                        listManager.mechanics.remove(i);
                    }
                    for(int i = 0; i < listManager.carsInNotRepair.size(); i++) {
                        listManager.carsInNotRepair.remove(i);
                    }
            }
        }
    }
}


