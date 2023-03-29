package RMI;

import java.util.ArrayList;

public class Author {
  private  String Name;
  private  int ID;
  private  String PNumber;
  private  String Adress;
  private  ArrayList<Event> autherEvent;
  private  ArrayList<DigitalBook> DigitalBook;
  Admin s;
 
    public Author(String Name, int ID, String PNumber, String Adress) {
        this.Name = Name;
        this.ID = ID;
        this.PNumber = PNumber;
        this.Adress = Adress;
    }
    
    public Author(){
        
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPNumber() {
        return PNumber;
    }

    public void setPNumber(String PNumber) {
        this.PNumber = PNumber;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

 
    public void setAutherEvent(ArrayList<Event> autherEvent) {
        this.autherEvent = autherEvent;
    }

   

    public ArrayList<DigitalBook> getDigitalBook() {
        return DigitalBook;
    }

    public void setDigitalBook(ArrayList<DigitalBook> DigitalBook) {
        this.DigitalBook = DigitalBook;
    }
   public ArrayList<Event> getAutherEvent() {
        return autherEvent;
    }

    
    public void requestEvent(int id,String Description,String Date,String Title,int Event_Capacity){
    Event E=new Event(id,Description,Date,Title,Event_Capacity);
    this.s=Admin.getAdmin_Instance();
    s.getRequstedEvents_List().add(E);
    }
    public void requestDigitalBook(int BookID, String Book_Name, String descriptino, String Category){
    DigitalBook E=new DigitalBook( BookID,Book_Name, descriptino,  Category);
    this.s=Admin.getAdmin_Instance();
    s.getPublish_Request_List().add(E);
    }

    }
  
  

