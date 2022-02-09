package HubertRoszyk.company.strategyMain;
import HubertRoszyk.company.*;
import java.io.IOException;
import java.sql.SQLException;

public class ProgramShutDownStrategy implements MenuItemStrategy{
    public void run() throws IOException, SQLException {
        Main.isOn = false;
        ProgramShutDown programShutDown = new ProgramShutDown();
        programShutDown.ShutDown();
    }
}
