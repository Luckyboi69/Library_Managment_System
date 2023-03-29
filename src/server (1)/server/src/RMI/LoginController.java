package RMI;

import java.util.ArrayList;

public class LoginController {
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
    
    public void Signup(Customer customer){
        account.insertCustomer(customer);
    }
    
    public void Login(String username, String password){
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
    
}
