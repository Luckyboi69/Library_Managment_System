package RMI;




import java.util.ArrayList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class Librarian extends User implements librarianInterface {
    private int Salary;
    private ArrayList<String> RequestedBooks;
    private ArrayList<Feedback> CustomerFeedbacks;
    private ArrayList<RentedBook> RentedBooks;
    LibrarianMapper m;
    
    
    public Librarian(int Salary, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) throws RemoteException {
        super(National_ID, Username, Password, Email, Age, Phone_Number);
        this.Salary = Salary;
        
    }

    public Librarian(int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) throws RemoteException{
        super(National_ID, Username, Password, Email, Age, Phone_Number);
        
    } 

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public ArrayList<String> getRequestedBooks() {
        return RequestedBooks;
    }

    public void setRequestedBooks(ArrayList<String> RequestedBooks) {
        this.RequestedBooks = RequestedBooks;
    }

    public ArrayList<Feedback> getCustomerFeedbacks() {
        return CustomerFeedbacks;
    }

    public void setCustomerFeedbacks(ArrayList<Feedback> CustomerFeedbacks) {
        this.CustomerFeedbacks = CustomerFeedbacks;
    }

    public ArrayList<RentedBook> getRentedBooks() {
        return RentedBooks;
    }

    public void setRentedBooks(ArrayList<RentedBook> RentedBooks) {
        this.RentedBooks = RentedBooks;
    }
    
    public void returnRentedBook(int rentedBookID){
    
    }
    
    @Override
    public void setm()throws RemoteException{
     this.m =new LibrarianMapperImpl();
    }
    @Override
    public void FileReport(int id,int AccountID,String Description)throws RemoteException{
    Report r= new Report(id,Description,AccountID);
    m.insertReport(r);
    }
    public void DeleteBookData( int BookID){
        
        m.deleteBook(BookID);
        
    }
    public void insertBook(int bid,String Title,String PY,String au,String wn,String d){
        BookCopy bc1=new BookCopy();
        BookCopy bc2=new BookCopy();
        BookCopy bc3=new BookCopy();
        BookCopy bc4=new BookCopy();
        BookCopy bc5=new BookCopy();
        ArrayList<BookCopy> x= new ArrayList();
       Book b = new Book(bid,Title,PY,au,wn,x);
        m.insertBook(b);
    }

    public void ModifyBookData(int BID,String WhatToChange,String newData){
        m.modifyBook(BID, WhatToChange, newData);
   }
    
}
