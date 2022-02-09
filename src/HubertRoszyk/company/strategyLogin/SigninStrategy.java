package HubertRoszyk.company.strategyLogin;

import HubertRoszyk.company.SigninPage;

import java.io.IOException;
import java.sql.SQLException;

public class SigninStrategy implements LoginItemStrategy{
    public void run() throws IOException, SQLException {
        SigninPage signinPage = new SigninPage();
    }
}
