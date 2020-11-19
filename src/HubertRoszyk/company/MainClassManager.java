package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClassManager {
    Scanner scanner = new Scanner(System.in);
    void infoDisplay() {
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
    }
    int actionInscrybing() {
        String stringAction = scanner.next();
        //scanner.close();
        int action = 11;

        try
        {
            action = Integer.parseInt(stringAction);
        } catch (NumberFormatException ex) {
            System.out.println("Wpisz liczbę, a nie znak");
        }
        return action;
    }
    void carDispay(List<CarData> cars) {
        System.out. println("ID marka model rejestracja");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).id + " " + cars.get(i).mark + " " + cars.get(i).model + " " + cars.get(i).plate);
        }
    }
    void mechanicDisplay() {
        System.out.println("imię nazwisko");
        for (int j = 0; j < Main.listManager.mechanics.size(); j++) {
            System.out.println(Main.listManager.mechanics.get(j).id + " " + Main.listManager.mechanics.get(j).firstName + " " + Main.listManager.mechanics.get(j).lastName);
        }
    }
    List<String> getCarData() {
        List<String> carData = new ArrayList<String>();
        System.out.println("Wpisz markę samochodu"); // dane wejściowe ze skanerem
        String mark = scanner.next();
        System.out.println("Wpisz model samochodu");
        String model = scanner.next();
        System.out.println("Wpisz numer rejestracyjny samochodu");
        String plate = scanner.next();

        carData.add(mark);
        carData.add(model);
        carData.add(plate);

        //scanner.close();
        return carData;
    }
    List<String> getMechanicData()
    {
        System.out.println("Wpisz imię pracownika");
        String firstName = scanner.next(); //public
        System.out.println("Wpisz nazwisko pracownika");
        String lastName = scanner.next();

        List<String> mechanicData = new ArrayList<String>();
        mechanicData.add(firstName);
        mechanicData.add(lastName);
        //scanner.close();
        return mechanicData;
    }
}
