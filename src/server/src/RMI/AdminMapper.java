package RMI;

import java.util.ArrayList;



public interface AdminMapper {
    public void insertRoom(Room room);
    public void modifyRoom(int RoomID,String editor ,String newData) ;
    public void deleteRoom(int RoomID);
    
    public void insertLibrarian(Librarian librarian);
    public void modifyLibrarian(int id,String editor ,String newData);
    public void deleteLibrarian(String uname);
    
    public void insertAcceptedEvent(Event event);
    public void modifyAcceptedEvent(int eventID);
    public void deleteAcceptedEvent(int eventID);
    
    public void insertAccpetedDigitalBook(DigitalBook digitalBook);
    public void modifyAccpetedDigitalBook(int digitalBook);
    public void deleteAccpetedDigitalBook(int digitalBook);
    
    public ArrayList<Report> viewReports() ;

    public void insertDigitalBook(DigitalBook DigitalBook);
    public void insertEvent(Event Event);
}
