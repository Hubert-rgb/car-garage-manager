package HubertRoszyk.company.strategy;
import HubertRoszyk.company.*;
import java.io.IOException;

public class ProgramShutDownStrategy implements MenuItemStrategy{
    public void run() throws IOException {
        Main.isOn = false;
        ProgramShutDown programShutDown = new ProgramShutDown();
        programShutDown.ShutDown();
    }
}
