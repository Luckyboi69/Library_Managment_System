package RMI;




import java.util.ArrayList;

class Librarian extends User  {
    private int Salary;
    private ArrayList<String> RequestedBooks;
    private ArrayList<Feedback> CustomerFeedbacks;
    private ArrayList<RentedBook> RentedBooks;
    LibrarianMapper m;
    
    public Librarian(int Salary, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) {
        super(National_ID, Username, Password, Email, Age, Phone_Number);
        this.Salary = Salary;
        
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
    
    public void setm(){
     this.m =new LibrarianMapperImpl();
    }
    public void FileReport(int id,int AccountID,String Description){
    Report r= new Report(id,Description,AccountID);
    m.insertReport(r);
    }
    
}
