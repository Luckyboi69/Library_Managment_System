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
    private Customer customer;

    public RentedBook(String Start_date, String End_date, Book book, Customer customer) {
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.book = book;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}

