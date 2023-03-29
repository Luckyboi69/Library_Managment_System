package RMI;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;


public class Book implements BookReadOnly {
    int BID;
    String Title;
    String Publication_Year;
    String Writer_Name;
    String Description;
    ArrayList<BookCopy> Book_Copys;
    //BookShelf book;

    public Book() {
        
    }

 
    public Book(int BID, String Title, String Publication_Year, String Writer_Name, String Description, ArrayList<BookCopy> Book_Copys) {
        this.BID = BID;
        this.Title = Title;
        this.Publication_Year = Publication_Year;
        this.Writer_Name = Writer_Name;
        this.Description = Description;
        this.Book_Copys = Book_Copys;
    }
    
    public Book(String Title, String Publication_Year, String Writer_Name, String Description) {
        this.Title = Title;
        this.Publication_Year = Publication_Year;
        this.Writer_Name = Writer_Name;
        this.Description = Description;
    }

    
    public void setBID(int BID) {
        this.BID = BID;
    }
    public int getBID() {
        return BID;
    }

    @Override
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String getPublication_Year() {
        return Publication_Year;
    }

    public void setPublication_Year(String Publication_Year) {
        this.Publication_Year = Publication_Year;
    }

    public String getWriter_Name() {
        return Writer_Name;
    }

    public void setWriter_Name(String Writer_Name) {
        this.Writer_Name = Writer_Name;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public ArrayList<BookCopy> getBook_Copys() {
        return Book_Copys;
    }

    public void setBook_Copys(ArrayList<BookCopy> Book_Copys) {
        this.Book_Copys = Book_Copys;
    }

    @Override
    public void printBookDetails(){
        System.out.println("BID: " + this.getBID());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Publication Year: " + this.Publication_Year);
        System.out.println("Writer Name: " + this.getWriter_Name());
        System.out.println("Description: " + this.getDescription());
    }
 
}