package RMI;

import java.util.ArrayList;
import java.util.List;

public interface AccountMapper {
    public void insertCustomer(Customer customer);
    public ArrayList<String> getUserAccount();
    public void ResetAccountPass(int ssn, String newPassword);
    public List<Integer> getUsersSsn();
}
