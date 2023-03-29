package RMI;

import com.google.gson.Gson;
import java.util.ArrayList;

public class UserMapperImpl implements UserMapper {
    private DatabaseController db;
    
    public UserMapperImpl() {
       db = new DatabaseController();
    }
    
    @Override
    public void insertFeedback(Feedback feedback) {
        if(db.collectionExistance(db.getObejectTitle(feedback))){
            db.insertDocument(feedback);
        }else{
            db.addCollection(feedback);
            db.insertDocument(feedback);
        }
        System.out.println("Inserted Successfully..");
    }

    @Override
    public Book searchForBook(String Title) {
                Book book = new Book();
        for(Book bookNeeded : viewAllBooks()){
            if(bookNeeded.getTitle().equals(Title)){
                book = bookNeeded;
            }else{
                book = null;
            }
        }
        return book;
    }

    @Override
    public ArrayList<Book> viewAllBooks() {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Book");
        ArrayList<Book> result = new ArrayList<Book>();
        ArrayList<org.bson.Document> Doc = (ArrayList<org.bson.Document>) db.mongoCollection.find().into(new ArrayList<org.bson.Document>());
        Gson gson = new Gson();

       for (int i = 0; i < Doc.size(); i++) {
            String jsonResult = Doc.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Book.class));
        }
       return result;
    }
    
}
