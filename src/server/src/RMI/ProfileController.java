package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ProfileController implements ProfileInterface{
    private AccountMapper account = new AccountMapperImpl();

    public ProfileController() {
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

    @Override
    public void depositMoney(double amount, String Username) throws RemoteException {
        CustomerMapper CustMapp = new CustomerMapperImpl();
        CustMapp.depositMoney(amount, Username);
    }

    @Override
    public double getBalance(String Username) throws RemoteException {
        CustomerMapper CustMapp = new CustomerMapperImpl();
        return CustMapp.getBalance(Username);
    }

    @Override
    public void printDocument(String Username, String type, String size, String title) throws RemoteException {
         try{
             Document doc = new Document(type, size, title);
             DocumentPrintRequestDtoInterface dpr = new CDFacade(Username, doc);
             
             Registry reg = LocateRegistry.createRegistry(1099);
             reg.bind("de7k", dpr);
             System.out.println("De7k started....");
             
             
         }catch (Exception ex){
             System.out.println("Exception..");
         }
    }

    @Override
    public void renewBook(int bookID, String custID, String newDate) throws RemoteException {
        CustomerMapper CustMapp = new CustomerMapperImpl();
        CustMapp.renewBook(bookID, custID, newDate);
    }
    
}
