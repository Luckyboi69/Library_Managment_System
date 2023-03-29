package RMI;



public interface LibrarianMapper{
    public void insertBook(Book book);
   public void modifyBook(int bookID,String editor,String newData);
    public void deleteBook(int bookID);
    public void insertReport(Report R);
}
