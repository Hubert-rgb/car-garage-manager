package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TextManager {
    Validator validator = new Validator();
    Scanner scanner = new Scanner(System.in);
    public void landingPageInfoDisplay() {
        System.out.println("Witaj na stronie warsztatu samochodowego!");
        System.out.println("Wpisz numer czynności jaka chcesz wykonać:");
        System.out.println("1. Zaloguj się");
        System.out.println("2. Utwórz nowe konto");
    }
    public void managerInfoDisplay() {
        System.out.println();
        System.out.println("Wpisz numer czynności jaka chcesz wykonać:");
        System.out.println("1. dodawanie nowego pojazdu");
        System.out.println("2. utwórz konto Mechanika");
        System.out.println("3. wyświetl liste samochodów");
        System.out.println("4. wyświetl liste mechaników");
        System.out.println("5. przypisz mechanika do naprawy samochodu");
        System.out.println("6. wyświetl liste naprawianych samochodów");
        System.out.println("7. wyświetl liste samochodów czekających na naprawę");
        System.out.println("8. odznacz samochód jako naprawiony");
        System.out.println("9. wyświetl liste wykonywanych prac w przeszłości");
        System.out.println("10. wyświetl status naprawy samochodu");
        System.out.println("11. wyłącz program");
        System.out.println("12. usuń zapisane dane");
    }
    public void mechanicInfoDisplay() {
        System.out.println();
        System.out.println("Wpisz numer czynności jaka chcesz wykonać:");
        System.out.println("1. wyświetl liste samochodów");
        System.out.println("2. przypisz mechanika do naprawy samochodu");
        System.out.println("3. wyświetl liste naprawianych samochodów");
        System.out.println("4. wyświetl liste samochodów czekających na naprawę");
        System.out.println("5. odznacz samochód jako naprawiony");
        System.out.println("6. wyświetl liste wykonywanych prac w przeszłości");
        System.out.println("7. wyłącz program");
    }
    public void userInfoDisplay() {
        System.out.println();
        System.out.println("Wpisz numer czynności jaka chcesz wykonać:");
        System.out.println("1. dodawanie nowego pojazdu");
        System.out.println("2. wyświetlanie statusu samochodu"); //do zrobienia
        System.out.println("3. wyłącz program");
    }
    public void signinPageInfoDisplay() {
        System.out.println();
        System.out.println("Wpisz numer typu konta które chcesz utworzyć");
        System.out.println("1. Manager");
        System.out.println("2. Mechanik");
        System.out.println("3. Użytkownik");
    }
    public int actionInscrybing() {
        String stringAction = scanner.next();
        int action;
        action = validator.stringToInt(stringAction);
        return action;
    }
    public void carDispay(List<CarData> cars) {
        System.out. println("ID marka model rejestracja");
        for (CarData car : cars) {
            System.out.println(car.id + " " + car.mark + " " + car.model + " " + car.plate);
        }
    }
    public void mechanicDisplay() {
        System.out.println("ID imię nazwisko");
        for (int j = 0; j < Main.listManager.mechanics.size(); j++) {
            System.out.println(Main.listManager.mechanics.get(j).id + " " + Main.listManager.mechanics.get(j).firstName + " " + Main.listManager.mechanics.get(j).lastName);
        }
    }
    List<String> getCarData() {
        List<String> carData = new ArrayList<>();
        System.out.println("Wpisz markę samochodu");
        String mark = scanner.next();
        System.out.println("Wpisz model samochodu");
        String model = scanner.next();
        System.out.println("Wpisz numer rejestracyjny samochodu");
        String plate = scanner.next();

        carData.add(mark);
        carData.add(model);
        carData.add(plate);

        return carData;
    }
    public List<String> getMechanicAccount() {
        System.out.println("Wpisz imię mechanika");
        String firstName = scanner.next();
        System.out.println("Wpisz nazwisko mechanika");
        String lastName = scanner.next();

        List<String> mechanicData = new ArrayList<>();  //to dać do innej klasy
        mechanicData.add(firstName);
        mechanicData.add(lastName);

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String mechanicCode = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(mechanicCode);

        mechanicData.add(mechanicCode);
        return mechanicData;
    }
    public List<String> getManagerData() {
        System.out.println("Wpisz swoje imie");
        String firstName = scanner.next();
        System.out.println("Wpisz swoje nazwisko");
        String lastName = scanner.next();
        System.out.println("Wpisz hasło do swojego konta");
        String password = scanner.next();
        System.out.println("Wpisz hasło główne programu (hasło admina)");
        String mainPassword = scanner.next();

        List<String> managerData = new ArrayList<>();
        managerData.add(firstName);
        managerData.add(lastName);
        managerData.add(password);
        managerData.add(mainPassword);
        return managerData;
    }
    public List<String> getMechanicData() {
        System.out.println("Wpisz kod wygenerowany przez twojego managera");
        String code = scanner.next();
        System.out.println("Wpisz hasło do swojego konta");
        String password = scanner.next();

        List<String> mechanicData = new ArrayList<>();
        mechanicData.add(code);
        mechanicData.add(password);
        return mechanicData;
    }
    public List<String> getUserData() {
        System.out.println("Wpisz swoje imie");
        String firstName = scanner.next();
        System.out.println("Wpisz swoje nazwisko");
        String lastName = scanner.next();
        System.out.println("Wpisz hasło do swojego konta");
        String password = scanner.next();

        List<String> userData = new ArrayList<>();
        userData.add(firstName);
        userData.add(lastName);
        userData.add(password);
        return userData;
    }
    public List<String> getLoginData() {
        System.out.println("Wpisz swoje imie");
        String firstName = scanner.next();
        System.out.println("Wpisz swoje nazwisko");
        String lastName = scanner.next();
        System.out.println("Wpisz hasło do swojego konta");
        String password = scanner.next();

        List<String> loginData = new ArrayList<>();
        loginData.add(firstName);
        loginData.add(lastName);
        loginData.add(password);
        return loginData;
    }
}
