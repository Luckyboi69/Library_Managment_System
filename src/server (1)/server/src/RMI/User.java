package RMI;



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class User {
    private int National_ID;
    private String Username;
    private String Password;
    private String Email;
    private int Age;
    private int Phone_Number;

    public User(int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) {
        this.National_ID = National_ID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Age = Age;
        this.Phone_Number = Phone_Number;
    }

    public void setNational_ID(int National_ID) {
        this.National_ID = National_ID;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setPhone_Number(int Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public int getNational_ID() {
        return National_ID;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public int getAge() {
        return Age;
    }

    public int getPhone_Number() {
        return Phone_Number;
    }

//-------------------Rest of the functions-----------------------------------
    
    //public void giveFeedback(){}
    //public Book searchForBook(String Name){}
    //public ArrayList<Book> viewAllBooks(){}
}
