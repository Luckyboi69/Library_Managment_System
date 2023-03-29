package RMI;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class RentedBook {
    private String Start_date;
    private String End_date;
    private Book book;
    private String customerID;

    public RentedBook(String Start_date, String End_date, Book book, String customerID) {
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.book = book;
        this.customerID = customerID;
    }

    
    public String getStart_date() {
        return Start_date;
    }

    public void setStart_date(String Start_date) {
        this.Start_date = Start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCustomer() {
        return customerID;
    }

    public void setCustomer(String customerID) {
        this.customerID = customerID;
    }
    
}

