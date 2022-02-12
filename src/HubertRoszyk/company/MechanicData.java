package HubertRoszyk.company;
import HubertRoszyk.company.database.DatabaseMechanicManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MechanicData extends AccountData {
    public String mechanicCode;

    public MechanicData(String firstName, String lastName, String password, String accountType, int id, String mechanicCode) {
        super(firstName, lastName, password, accountType, id);
        this.mechanicCode = mechanicCode;
    }
}