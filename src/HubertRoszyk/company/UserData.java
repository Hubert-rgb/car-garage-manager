package HubertRoszyk.company;

import java.util.List;

public class UserData extends AccountData{
    public List<Integer> carNums;
    public UserData(String firstName, String lastName, String password, String accountType, int id, List<Integer> carNums) {
        super(firstName, lastName, password, accountType, id);
        this.carNums = carNums;
    }
}
