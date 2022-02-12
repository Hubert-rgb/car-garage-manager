package HubertRoszyk.company;

public class AccountData { //może abstract?
    public AccountData(String firstName, String lastName, String password, String accountType, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accountType = accountType;
        this.id = id;
    }
    public String firstName, lastName, password, accountType;
    public int id;
}
