package HubertRoszyk.company;

import HubertRoszyk.company.Pages.LoginPage;

import java.io.*;
import java.sql.SQLException;

public class Main {
    public static ListManager listManager = ListManager.getInstance();
    public static TextManager textManager = new TextManager();
    public static boolean isOn;

    public static void main(String[] args) throws IOException, SQLException {
        listManager.listManagerReading();
        isOn = true;

        LoginPage loginPage = new LoginPage();

    }
}


