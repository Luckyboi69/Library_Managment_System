package RMI;
import java.util.ArrayList;

public interface CustomerMapper {
    public ArrayList<BookReadOnly> viewBooks();
    public ArrayList<Room> viewRoomScheduals();
    public void rentBook(RentedBook rentedbook);
    public void rentRoom(int RoomID, String StartDate, String EndDate, String Customeruser);
    public void depositMoney(double money, String custId);
    public void renewBook(int bookID, String custID, String newDate);
    public void requestMissingBook(MissingBook mb);
    public double getBalance(String Username);
}
