package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProfileInterface extends Remote{
    public void ResetPassword(int ssn, String newPassword) throws RemoteException;
    public void depositMoney(double amount, String Username) throws RemoteException;
    public double getBalance(String Username) throws RemoteException;
    public void printDocument(String Username, String type, String size, String title) throws RemoteException;
    public void renewBook(int bookID, String custID, String newDate) throws RemoteException;
}
