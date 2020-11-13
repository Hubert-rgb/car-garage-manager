package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CarData {
    Scanner scanner = new Scanner(System.in); //dostęp do plików
    String mark;
    String model;
    String plate;

    public CarData(String mark) {
        this.mark = mark;
    }

    public String[] getData() { //konstruktorem
        //System.out.println("Wpisz markę samochodu"); // dane wejściowe ze skanerem
        //mark = scanner.next();
        System.out.println("Wpisz model samochodu");
        model = scanner.next();
        System.out.println("Wpisz numer rejestracyjny samochodu");
        plate = scanner.next();

        String[] data = {mark, model, plate};

        return (data);

    }
}