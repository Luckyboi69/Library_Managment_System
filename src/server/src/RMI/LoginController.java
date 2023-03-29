package RMI;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class LoginController implements LoginInterface{
    private String username;
    private String password;
    private AccountMapper account = new AccountMapperImpl();;
    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginController() {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public void Signup(double Account_Balance, boolean Subscribed, int Account_Strikes, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number){
        Customer customer = new Customer(Account_Balance, Subscribed, Account_Strikes, National_ID, Username, Password, Email, Age, Phone_Number);
        account.insertCustomer(customer);
    }
    
    @Override
    public void Login(String username, String password) throws RemoteException {
        String cerd = username + ":" + password;
        boolean existed = false;
        ArrayList<String> acc = account.getUserAccount();
        for(int i = 0; i < acc.size(); i++){
            if(acc.get(i).equals(cerd)){
                System.out.println("Welcome " + username);
                break;
            }else{
                existed = false;
            }
        }
    }

    @Override
    public void setAccount() throws RemoteException {
       this.account = new AccountMapperImpl();
    }

    @Override
    public void ResetPassword(int ssn, String newPassword) throws RemoteException {
        boolean existed = false;
        List<Integer> acc = account.getUsersSsn();
        for(int i = 0; i < acc.size(); i++){
            if(acc.get(i).equals(ssn)){
                existed = true;
                break;
            }else{
                existed = false;
            }
        }
        if(existed){
            account.ResetAccountPass(ssn, newPassword);
        }
    }
}
