package HubertRoszyk.company;

import java.util.Scanner;
import HubertRoszyk.company.Main;
import HubertRoszyk.company.CarData;
public class MainClassManager {
    Scanner scanner = new Scanner(System.in);
    ListManager listManager = new ListManager();
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
        int action = 11;

        try
        {
            action = Integer.parseInt(stringAction);
        } catch (NumberFormatException ex) {
            System.out.println("Wpisz liczbę, a nie znak");
        }
        return action;
    }
    void carDispay()
    {
        System.out. println("marka model rejestracja");
        for (int i = 0; i < listManager.cars.size(); i++) {
            String[] carData = listManager.cars.get(i);
            System.out.print(carData[0] + " " + carData[1] + " " + carData[2]);
            System.out.println();
        }
    }
    String getCarData() {
        System.out.println("Wpisz markę samochodu"); // dane wejściowe ze skanerem
        String mark = scanner.next();
        CarData carData = new CarData(mark);
        return mark;
    }
}
