package RMI;

import java.util.ArrayList;

public interface UserMapper {
    public void insertFeedback(Feedback feedback);
    public Book searchForBook(String Title);
    public ArrayList<Book> viewAllBooks();
}
