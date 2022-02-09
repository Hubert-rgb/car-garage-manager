package HubertRoszyk.company.strategyLogin.signinStrategy;

import java.io.IOException;
import java.sql.SQLException;

public interface SigninItemStrategy {
    void run() throws SQLException, IOException;
}
