package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Buff buff = new Buff();
        Scanner scanner = new Scanner(System.in);

        boolean isOn = true;
        List<String[]> cars = new ArrayList<String[]>();

        buff.readCar(cars, "Cars.txt");

        List<Mechanic_Data> mechanics = new ArrayList<Mechanic_Data>();
        List<String[]> mechanicsData = new ArrayList<String[]>();

        mechanics = buff.readMechanic(mechanics);

        List<String[]> carsInRepair = new ArrayList<String[]>();

        buff.readCar(carsInRepair, "CarsInRepair.txt");

        List<String[]> carsInNotRepair = new ArrayList<String[]>();
        buff.readCar(carsInNotRepair, "CarsInNotRepair.txt");

        List<String[]> carsRepaired = new ArrayList<String[]>();

        buff.readCar(carsRepaired, "CarsRepaired.txt");

        while (isOn == true) {

            System.out.println();
            System.out.println("Wpisz numer czynności jaka chcesz wykonać:");
            System.out.println("1. dodawanie nowego pojazdu");
            System.out.println("2. dodaj mechanika");
            System.out.println("3. wyświetl liste samochodów");
            System.out.println("4. wyświetl liste mechaników");
            System.out.println("5. przypisz mechanika do naprawy samochodu");
            System.out.println("6. wyświetl liste naprawianych samochodów");
            System.out.println("7. wyświetl liste samochodów czekających na naprawę");
            System.out.println("8. odznacz samochód jako naprawiony");
            System.out.println("9. wyświetl liste wykonywanych prac w przeszłości");
            System.out.println("10. wyłącz program");
            //System.out.println("11. sformatuj program");

            String stringAction = scanner.next();
            int action = 11;

            try
            {
                action = Integer.parseInt(stringAction);
            } catch (NumberFormatException ex) {
                action = 11;
                System.out.println("Wpisz liczbę, a nie znak");
            }

            switch (action) {
                case 1:
                    Car_Data car = new Car_Data();
                    String[] newCarData = car.getData();
                    cars.add(newCarData);
                    carsInNotRepair.add(newCarData);
                    continue;
                case 2:
                    Mechanic_Data mechanic = new Mechanic_Data();
                    String[] data = mechanic.newData();
                    mechanic.data = data;
                    mechanics.add(mechanic);
                    mechanicsData.add(mechanic.data);

                    continue;
                case 3:
                    // wyświetla tylko nienaprawiane samochody
                    System.out. println("marka model rejestracja");
                    for (int i = 0; i < cars.size(); i++) {
                        String[] carData = cars.get(i);
                        System.out.print(carData[0] + " " + carData[1] + " " + carData[2]);
                        System.out.println();
                    }
                    continue;
                case 4:
                    System.out.println("imię nazwisko");
                    for (int j = 0; j < mechanics.size(); j++) {
                        String[] data1 = mechanics.get(j).data;
                        System.out.print(data1[0] + " " + data1[1]);
                        System.out.println();
                    }
                    continue;
                case 5:
                    if(carsInNotRepair.size() <= 0){
                        System.out.println("Nie ma żadnego samochodu czekającego na naprawę");
                    } else if (mechanics.size() <= 0) {
                        System.out.println("Nie ma żadnego mechanika w bazie danych");
                    } else {
                        System.out.println("wpisz numer samochodu");

                        System.out. println("marka model rejestracja");

                        for (int i = 0; i < carsInNotRepair.size(); i++) {
                            String[] carData = carsInNotRepair.get(i);
                            System.out.print(i + 1 + " " + carData[0] + " " + carData[1] + " " + carData[2]);
                            System.out.println();
                        }
                        int carNum = scanner.nextInt();

                        System.out.println("wpisz numer pracownika");

                        System.out.println("imię nazwisko");

                        for (int j = 0; j < mechanics.size(); j++) {
                            mechanics.get(j);
                            String[] data2 = mechanics.get(j).data;
                            System.out.print(j + 1 + " " + data2[0] + " " + data2[1]);
                            System.out.println();
                        }

                        int mechanicNum = scanner.nextInt();

                        if (mechanics.get(mechanicNum - 1).repearingCars < 2) {
                            mechanics.get(mechanicNum - 1).repearingCars++;
                            carsInRepair.add(carsInNotRepair.get(carNum - 1));
                            mechanics.get(mechanicNum - 1).repairingCarsList.add(carsInNotRepair.get(carNum - 1));
                            carsInNotRepair.remove(carsInNotRepair.get(carNum - 1));
                            System.out.println("dodano samochód do naprawy");
                        } else {
                            System.out.println("Mechanik naprawia już dwa samochody");
                        }
                    }
                    continue;
                case 6:
                    System.out. println("marka model rejestracja");
                    for (int k = 0; k < carsInRepair.size(); k++) {
                        String[] carsData = carsInRepair.get(k);
                        System.out.print(carsData[0] + " " + carsData[1] + " " + carsData[2]);
                        System.out.println();
                    }
                    continue;
                case 7:
                    System.out. println("marka model rejestracja");
                    for (int k = 0; k < carsInNotRepair.size(); k++) {
                        String[] carsData = carsInNotRepair.get(k);
                        System.out.print(carsData[0] + " " + carsData[1] + " " + carsData[2]);
                        System.out.println();
                    }
                    continue;
                case 8:
                    if(carsInRepair.size() < 1) {
                        System.out.println("Nie ma żadnego samochodu w naprawie");
                    } else {
                        System.out.println("wpisz numer samochodu, który chcesz oznaczyć jako naprawiony");
                        System.out. println("marka model rejestracja");
                        for (int k = 0; k < carsInRepair.size(); k++) {
                            String[] carsData = carsInRepair.get(k);
                            System.out.print(k + 1 + " " + carsData[0] + " " + carsData[1] + " " + carsData[2]);
                            System.out.println();
                        }
                        int carNum1 = scanner.nextInt();

                        for (int i = 0; i < mechanics.size(); i++) {
                            for (int k = 0; k < mechanics.get(i).repairingCarsList.size(); k++) {
                                if (mechanics.get(i).repairingCarsList.get(k).equals(carsInRepair.get(carNum1 - 1))) {
                                    mechanics.get(i).repearingCars--;
                                    mechanics.get(i).repairingCarsList.remove(k);
                                }
                            }
                        }
                        carsRepaired.add(carsInRepair.get(carNum1 - 1));
                        /*for (int k = 0; k < carsSize; k++) {
                            if (carsInRepair.get(carNum1 - 1).equals(cars.get(k))){
                                cars.remove(cars.get(k));
                            }
                        }*/
                        cars.remove(carsInRepair.get(carNum1 - 1));
                        carsInRepair.remove(carsInRepair.get(carNum1 - 1));
                        System.out.println("Samochód został naprawiony!");
                    }
                    continue;
                case 9:
                    System.out. println("marka model rejestracja");
                    for (int k = 0; k < carsRepaired.size(); k++) {
                        String[] carsData = carsRepaired.get(k);
                        System.out.print(carsData[0] + " " + carsData[1] + " " + carsData[2]);
                        System.out.println();
                    }
                    continue;
                case 10:
                    isOn = false;
                    //dodawanie mechanics do pliku tekstowego
                    buff.delateContent("Mechanics.txt");
                    for (int i = 0; i < mechanics.size(); i++){

                        buff.write(mechanics.get(i).data, "Mechanics.txt", 2);
                        String repairingCars = Integer.toString(mechanics.get(i).repearingCars);
                        String [] repairingCarsArray = {repairingCars};
                        buff.write(repairingCarsArray, "Mechanics.txt", 1);

                        for (int k = 0; k < (mechanics.get(i).repairingCarsList.size()); k++){
                            buff.write(mechanics.get(i).repairingCarsList.get(k), "Mechanics.txt", 3);
                        }
                    }
                    //dodawanie samochodów do pliku tekstowego
                    buff.delateContent("Cars.txt");
                    buff.delateContent("CarsInRepair.txt");
                    buff.delateContent("CarsRepaired.txt");
                    buff.delateContent("CarsInNotRepair.txt");

                    for(int i = 0; i < cars.size(); i++) {
                        buff.write(cars.get(i), "Cars.txt", 3);
                    }
                    for(int i = 0; i < carsInRepair.size(); i++) {
                        buff.write(carsInRepair.get(i), "CarsInRepair.txt", 3);
                    }
                    for(int i = 0; i < carsRepaired.size(); i++) {
                        buff.write(carsRepaired.get(i), "CarsRepaired.txt", 3);
                    }
                    for(int i = 0; i < carsInNotRepair.size(); i++) {
                        buff.write(carsInNotRepair.get(i), "CarsInNotRepair.txt", 3);
                    }
                    continue;
                case 11 :
                    buff.delateContent("CarsRepaired.txt");
                    buff.delateContent("CarsInRepair.txt");
                    buff.delateContent("Cars.txt");
                    buff.delateContent("Mechanics.txt");
                    buff.delateContent("CarsInNotRepair.txt");

                    for(int i = 0; i < cars.size(); i++) {
                        cars.remove(i);
                    }
                    for(int i = 0; i < carsInRepair.size(); i++) {
                        carsInRepair.remove(i);
                    }
                    for(int i = 0; i < carsRepaired.size(); i++) {
                        carsRepaired.remove(i);
                    }
                    for(int i = 0; i < mechanics.size(); i++) {
                        mechanics.remove(i);
                    }
                    for(int i = 0; i < carsInNotRepair.size(); i++) {
                        carsInNotRepair.remove(i);
                    }
            }
        }
    }
}
class Car_Data {
    Scanner scanner = new Scanner(System.in);

    public String[] getData() {
        System.out.println("Wpisz markę samochodu");
        String mark = scanner.next();
        System.out.println("Wpisz model samochodu");
        String model = scanner.next();
        System.out.println("Wpisz numer rejestracyjny samochodu");
        String plate = scanner.next();

        String[] data = {mark, model, plate};

        return (data);

    }
}
class Mechanic_Data {
    Scanner scanner = new Scanner(System.in);
    int repearingCars = 0;
    List<String[]> repairingCarsList = new ArrayList<String[]>();
    String[] data = null;

    public String[] newData() {
        System.out.println("Wpisz imię pracownika");
        String firstName = scanner.next();
        System.out.println("Wpisz nazwisko pracownika");
        String lastName = scanner.next();

        String[] data = {firstName, lastName};

        return (data);
    }
    public String[] getData(String firstName, String lastName) {
        String[] data = {firstName, lastName};

        return (data);
    }
}
class Buff {
    public void delateContent(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
    }
    public void write(String[] str, String fileName, int lengthOfArray) throws IOException {
        BufferedWriter writerCars = new BufferedWriter(new FileWriter(fileName, true));
        for (int i = 0; i < lengthOfArray; i++){
            writerCars.append(str[i]);
            writerCars.append(' ');
        }
        writerCars.close();

    }
    public List<String[]> readCar(List<String[]> cars, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String [] carsNewData;
        String carsNew;
        if ((carsNew = reader.readLine()) != null) {
            carsNewData = carsNew.split(" ");
            for (int i = 0; i < carsNewData.length; i += 3) {
                String[] carData = {carsNewData[i], carsNewData[i + 1], carsNewData[i + 2]};
                cars.add(carData);
            }
        }
        return cars;
    }
    public List<Mechanic_Data> readMechanic(List<Mechanic_Data> mechanics) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Mechanics.txt"));
        String [] readMechanicsArray;
        String readMechanicsString;
        
        if ((readMechanicsString = reader.readLine()) != null) {
            readMechanicsArray = readMechanicsString.split(" ");
            int a = 3;
            for (int i = 0; i < readMechanicsArray.length; i += a) {
                Mechanic_Data mechanic = new Mechanic_Data();
                a = 3;
                String[] mechanicData = {readMechanicsArray[i], readMechanicsArray[i + 1]};
                mechanic.data = mechanicData;
                
                int mehanicRepairigCars = Integer.parseInt(readMechanicsArray[i + 2]);
                mechanic.repearingCars = mehanicRepairigCars;

                if (mehanicRepairigCars > 0) {
                    a += (mehanicRepairigCars * 3);
                    String[] car1 = {readMechanicsArray[i + 3], readMechanicsArray[i + 4], readMechanicsArray[i + 5]};
                    switch (mehanicRepairigCars) {
                        case 1:
                            mechanic.repairingCarsList.add(car1);
                            break;
                        case 2:
                            String[] car2 = {readMechanicsArray[i + 6], readMechanicsArray[i + 7], readMechanicsArray[i + 8]};
                            mechanic.repairingCarsList.add(car1);
                            mechanic.repairingCarsList.add(car2);
                    }

                }
                mechanics.add(mechanic);
            }
        }
        return (mechanics);
        //zmieniam coś
    }
}