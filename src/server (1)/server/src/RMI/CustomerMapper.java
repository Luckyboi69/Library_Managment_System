package RMI;
import java.util.ArrayList;

public interface CustomerMapper {
    public ArrayList<BookReadOnly> viewBooks();
    public ArrayList<Room> viewRoomScheduals();
    public void reserveRoom();
}
