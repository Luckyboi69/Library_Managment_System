package RMI;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Customer extends User implements SystemToolsInterface{

    enum TypeOfSubscription {General,deluxe,primem};
    private double Account_Balance;
    private boolean Subscribed;
    private Room Rented_Room;
    private int Account_Strikes;
    private static ArrayList<RentedBook> Rented_Books =  new ArrayList<>();
    private TypeOfSubscription Subscribation_Type;
    
    
    public Customer(float Account_Balance, boolean Subscribed, Room Rented_Room, int Account_Strikes, TypeOfSubscription Subscribation_Type,int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) {
        super(National_ID, Username, Password, Email, Age, Phone_Number);
        this.Account_Balance = Account_Balance;
        this.Subscribed = Subscribed;
        this.Rented_Room = Rented_Room;
        this.Account_Strikes = Account_Strikes;
        this.Subscribation_Type = Subscribation_Type;
    }

    public Customer(double Account_Balance, boolean Subscribed, int Account_Strikes, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) {
        super(National_ID, Username, Password, Email, Age, Phone_Number);
        this.Account_Balance = Account_Balance;
        this.Subscribed = Subscribed;
        this.Account_Strikes = Account_Strikes;
    }
    
    
    @Override
    public ArrayList<String> viewBooks(){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        ArrayList<BookReadOnly> Books_In_DB = CustMapp.viewBooks();
        ArrayList<String> books = new ArrayList<String>();
        for(int i = 0; i < CustMapp.viewBooks().size(); i++){
            books.add(CustMapp.viewBooks().get(i).getTitle());
            books.add(CustMapp.viewBooks().get(i).getDescription());
            books.add(CustMapp.viewBooks().get(i).getWriter_Name());
            books.add(CustMapp.viewBooks().get(i).getPublication_Year());
        }
        return books;
    }
    
    @Override
    public String getBook(String title){
        String book = "";
        ArrayList<String> books = viewBooks();
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).equals(title)){
                book = books.get(i) + ":" + books.get(i+1) + ":" + books.get(i+2) + ":" + books.get(i+3);
            }
        }
        return book;
    }
    
    @Override
    public ArrayList<String> viewRooms(){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        ArrayList<Room> rrooms = CustMapp.viewRoomScheduals();
        ArrayList<String> rooms = new ArrayList<String>();
        for(int i = 0; i < CustMapp.viewRoomScheduals().size(); i++){
            int id = CustMapp.viewRoomScheduals().get(i).getRoomID();
            rooms.add(Integer.toString(id));
            rooms.add(CustMapp.viewRoomScheduals().get(i).getRoomFloor());
            rooms.add(CustMapp.viewRoomScheduals().get(i).getRoomClass().toString());
            for(int j = 0; j < CustMapp.viewRoomScheduals().get(i).getRoomSchedual().size(); j++){
                rooms.add(CustMapp.viewRoomScheduals().get(i).getRoomSchedual().get(j).getStartDate());
                rooms.add(CustMapp.viewRoomScheduals().get(i).getRoomSchedual().get(j).getEndDate());
                rooms.add(String.valueOf(CustMapp.viewRoomScheduals().get(i).getRoomSchedual().get(j).isReserved()));
            }
        }
        return rooms;
    }
    
     @Override
    public void makeFeedback(int id, String title, String desc, int rate) throws RemoteException {
        this.giveFeedback(id, title, desc, rate);
    }
    
    @Override
    public void RentBook(String title){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        String x = getBook(title);
        String[] bookDetails = x.split(":");
        Book book = new Book(bookDetails[0], bookDetails[1], bookDetails[2], bookDetails[3]);
        RentedBook rb = new RentedBook("01/01/2022", "07/01/2022", book, this.getUsername());
        CustMapp.rentBook(rb);
    }
    
    @Override
    public void RentRoom(int roomID, String StartDate, String EndDate){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        CustMapp.rentRoom(roomID, StartDate, EndDate, this.getUsername());
    }
    
    public void depositMoney(double amount){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        CustMapp.depositMoney(amount, this.getUsername());
    }
    
    public void renewBook(int bookID, String custID, String newDate){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        CustMapp.renewBook(bookID, custID, newDate);
    }
    
    @Override
    public void requestMissingBook(String Title, String Name) throws RemoteException {
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        MissingBook mb = new MissingBook(Title, Name);
        CustMapp.requestMissingBook(mb);
    }
    
    @Override
    public ArrayList<String> viewRoomScheduals(int ID) throws RemoteException {
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        ArrayList<Room> rooms = CustMapp.viewRoomScheduals();
        ArrayList<String> roomSchedual = new ArrayList<String>();
        for(int i = 0; i < CustMapp.viewRoomScheduals().size(); i++){
            int id = CustMapp.viewRoomScheduals().get(i).getRoomID();
            if(id == ID){
                for(int j = 0; j < CustMapp.viewRoomScheduals().get(i).getRoomSchedual().size(); j++){
                    roomSchedual.add(CustMapp.viewRoomScheduals().get(i).getRoomSchedual().get(j).getStartDate());
                    roomSchedual.add(CustMapp.viewRoomScheduals().get(i).getRoomSchedual().get(j).getEndDate());
                    roomSchedual.add(String.valueOf(CustMapp.viewRoomScheduals().get(i).getRoomSchedual().get(j).isReserved()));
                    break;
                }
                break;
            } 
        }
        return roomSchedual;
    }
    
    public double getAccount_Balance() {
        return Account_Balance;
    }

    public void setAccount_Balance(double Account_Balance) {
        this.Account_Balance = Account_Balance;
    }

    public boolean isSubscribed() {
        return Subscribed;
    }

    public void setSubscribed(boolean Subscribed) {
        this.Subscribed = Subscribed;
    }

    public Room getRented_Room() {
        return Rented_Room;
    }

    public void setRented_Room(Room Rented_Room) {
        this.Rented_Room = Rented_Room;
    }

    public int getAccount_Strikes() {
        return Account_Strikes;
    }

    public void setAccount_Strikes(int Account_Strikes) {
        this.Account_Strikes = Account_Strikes;
    }

    public static ArrayList<RentedBook> getRented_Books() {
        return Rented_Books;
    }

    public static void setRented_Books(ArrayList<RentedBook> Rented_Books) {
        Customer.Rented_Books = Rented_Books;
    }

    public TypeOfSubscription getSubscribation_Type() {
        return Subscribation_Type;
    }

    public void setSubscribation_Type(TypeOfSubscription Subscribation_Type) {
        this.Subscribation_Type = Subscribation_Type;
    }
   

}  

