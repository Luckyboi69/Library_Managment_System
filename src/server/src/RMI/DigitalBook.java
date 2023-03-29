package RMI;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class DigitalBook {
 private  int BookID; 
 private  String  Book_Name;
 private  String descriptino;
 private  String Category;

    public DigitalBook(int BookID, String Book_Name, String descriptino, String Category) {
        this.BookID = BookID;
        this.Book_Name = Book_Name;
        this.descriptino = descriptino;
        this.Category = Category;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String Book_Name) {
        this.Book_Name = Book_Name;
    }

    public String getDescriptino() {
        return descriptino;
    }

    public void setDescriptino(String descriptino) {
        this.descriptino = descriptino;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

   

   
 
    
    
}
