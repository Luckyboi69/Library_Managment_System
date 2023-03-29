package RMI;

import java.util.ArrayList;

public interface AccountMapper {
    public void insertCustomer(Customer customer);
    public ArrayList<String> getUserAccount();
}
