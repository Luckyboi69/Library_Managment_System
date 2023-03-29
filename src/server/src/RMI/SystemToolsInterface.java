package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SystemToolsInterface extends Remote{
    public ArrayList<String> viewBooks()throws RemoteException;
    public String getBook(String Title)throws RemoteException;
    public void makeFeedback(int id, String title, String desc, int rate) throws RemoteException;
    public void RentBook(String Title) throws RemoteException;
    public void requestMissingBook(String Title, String Name) throws RemoteException;
    public ArrayList<String> viewRooms() throws RemoteException;
    public ArrayList<String> viewRoomScheduals(int ID) throws RemoteException;
    public void RentRoom(int id, String StartDate, String EndDate) throws RemoteException;
}
