package RMI;


import RMI.BookReadOnly;
import RMI.CustomerMapper;
import RMI.CustomerMapperImpl;
import RMI.RentedBook;
import RMI.Room;
import RMI.User;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Customer extends User{
   
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
   
    
    public String viewBooks(){
        CustomerMapper CustMapp = new CustomerMapperImpl(); 
        ArrayList<BookReadOnly> Books_In_DB = CustMapp.viewBooks();
        String result = "";
        
        System.out.println("Books Existed: ");
        for(BookReadOnly bookNeeded: Books_In_DB){
            System.out.println("=============================================");
            bookNeeded.printBookDetails();
        }
        System.out.println(" ");
        System.out.println("Select the Book Title Needed: ");
        Scanner sc = new Scanner(System.in);
        String Book_Title_Needed = sc.nextLine();
        
        for(BookReadOnly bookNeeded : Books_In_DB){
            if(bookNeeded.getTitle().equals(Book_Title_Needed)){
                result = Book_Title_Needed;
            }else{
                result = "Not Existed, Try Again";
            }
        }
        return result;
    }
    
    
    public double getAccount_Balance() {
        return Account_Balance;
    }

    public void setAccount_Balance(float Account_Balance) {
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

