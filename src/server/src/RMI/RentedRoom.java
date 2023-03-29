package RMI;

public class RentedRoom {
    private String Start_Time;
    private String End_Time;
    private Room room;
    private String customerID;

    public RentedRoom(String Start_Time, String End_Time, Room room, String customerID) {
        this.Start_Time = Start_Time;
        this.End_Time = End_Time;
        this.room = room;
        this.customerID = customerID;
    }

    public String getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(String Start_Time) {
        this.Start_Time = Start_Time;
    }

    public String getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(String End_Time) {
        this.End_Time = End_Time;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    
}
