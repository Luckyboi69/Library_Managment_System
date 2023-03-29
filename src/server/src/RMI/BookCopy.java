package RMI;



public class BookCopy {
    String Book_BarCode;
    boolean rented;
    
    public BookCopy() {
    }

    public BookCopy(String Book_BarCode, boolean rented) {
        this.Book_BarCode = Book_BarCode;
        this.rented = rented;
    }
    
    public String getBook_BarCode() {
        return Book_BarCode;
    }

    public void setBook_BarCode(String Book_BarCode) {
        this.Book_BarCode = Book_BarCode;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

}