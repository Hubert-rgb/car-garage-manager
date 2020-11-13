package HubertRoszyk.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MechanicData { //data zmienić na 2 dane
    Scanner scanner = new Scanner(System.in); //dużo metod
    int repearingCars = 0;
    List<String[]> repairingCarsList = new ArrayList<String[]>();
    String[] data = null;

    public String[] newData() { //konstruktorem
        System.out.println("Wpisz imię pracownika");
        String firstName = scanner.next(); //public
        System.out.println("Wpisz nazwisko pracownika");
        String lastName = scanner.next();

        String[] data = {firstName, lastName};

        return (data);
    }
    public String[] getData(String firstName, String lastName) {
        String[] data = {firstName, lastName};

        return data;
    }
}