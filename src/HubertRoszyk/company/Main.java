package HubertRoszyk.company;

import java.io.*;
import java.sql.SQLException;

public class Main {
    public static ListManager listManager = ListManager.getInstance();
    public static TextManager textManager = new TextManager();
    public static boolean isOn;

    public static void main(String[] args) throws IOException, SQLException {
        listManager.listManagerReading();
        isOn = true;
        //przed tym logowanie
        LoginPage loginPage = new LoginPage();

        //MainManagerPage mainManagerPage = new MainManagerPage();
    }
}


