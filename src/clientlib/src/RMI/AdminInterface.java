/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Ahmed salah
 */
public interface AdminInterface  extends Remote{
    
    public void AddLibrarian(int Salary, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) throws RemoteException;
    public ArrayList<Report> getReportsForms_List()throws RemoteException;
    public String ViewReports()throws RemoteException;
    public void AddRoom(Room.TypeOfRoom RoomClass,int RoomID, String RoomFloor)throws RemoteException;
    public void DeleteRoom(int RoomID)throws RemoteException;
    public void ModifyRoom(int id,String edited,String newdata)throws RemoteException;
    public void DeleteLibrarian(String libID) throws RemoteException;
    public void acceptEventRequest(int eventid)throws RemoteException;
    public void acceptPublishRequest(int BookID)throws RemoteException;
    public void ModifyLibrarianData(int id,String att,String newdata)throws RemoteException;
}
