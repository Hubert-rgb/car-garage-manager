package HubertRoszyk.company.strategy;

import java.io.IOException;
import java.sql.SQLException;

public interface MenuItemStrategy{
    void run() throws IOException, SQLException;
}