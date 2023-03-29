package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface extends Remote{
    public void Signup(double Account_Balance, boolean Subscribed, int Account_Strikes, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) throws RemoteException;
    public void Login(String username, String password) throws RemoteException;
    public void ResetPassword(int ssn, String newPassword) throws RemoteException;
    public void setAccount() throws RemoteException;
}
