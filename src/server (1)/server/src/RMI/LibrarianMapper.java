package RMI;



public interface LibrarianMapper{
    public void insertBook(Book book);
    public void modifyBook(int bookID);
    public void deleteBook(int bookID);
    public void insertReport(Report R);
}
