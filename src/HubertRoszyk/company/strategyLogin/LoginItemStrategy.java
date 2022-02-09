package HubertRoszyk.company.strategyLogin;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginItemStrategy {
    void run() throws IOException, SQLException;
}
