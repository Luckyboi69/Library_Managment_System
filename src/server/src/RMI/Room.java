package RMI;

import java.util.ArrayList;
public class Room {
    public enum TypeOfRoom {General,deluxe,primem,none};
    private boolean Reserved;
    private TypeOfRoom RoomClass; 
    private int RoomID;
    private ArrayList<RoomDuration> RoomSchedual;
    private String RoomFloor;
    
    public Room(){
        Reserved = false;
        RoomClass = TypeOfRoom.none;
        RoomID = 0;
        RoomSchedual = new ArrayList<RoomDuration>();
        RoomFloor = "";
    }

    public Room( TypeOfRoom RoomClass, int RoomID, ArrayList<RoomDuration> RoomSchedual, String RoomFloor) {
        this.Reserved = false;
        this.RoomClass = RoomClass;
        this.RoomID = RoomID;
        this.RoomSchedual = RoomSchedual;
        this.RoomFloor = RoomFloor;
    }

   

    public boolean isReserved() {
        return Reserved;
    }

    public void setReserved(boolean Reserved) {
        this.Reserved = Reserved;
    }

    public TypeOfRoom getRoomClass() {
        return RoomClass;
    }

    public void setRoomClass(TypeOfRoom RoomClass) {
        this.RoomClass = RoomClass;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

  
    public ArrayList<RoomDuration> getRoomSchedual() {
        return RoomSchedual;
    }

    public void setRoomSchedual(ArrayList<RoomDuration> RoomSchedual) {
        this.RoomSchedual = RoomSchedual;
    }

    public String getRoomFloor() {
        return RoomFloor;
    }

    public void setRoomFloor(String RoomFloor) {
        this.RoomFloor = RoomFloor;
    }
    
    
}
