package RMI;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Scanner;



public class LibrarianMapperImpl implements LibrarianMapper{

    private DatabaseController db;
    public LibrarianMapperImpl() {
        db = new DatabaseController();
    }

    @Override
    public void insertBook(Book book) {
        if(db.collectionExistance(db.getObejectTitle(book))){
            db.insertDocument(book);
        }else{
            db.addCollection(book);
            db.insertDocument(book);
        }
        System.out.println("Inserted Successfully..");
    }

    @Override
    public void modifyBook(int bookID) {
        Scanner edit = new Scanner(System.in);
        System.out.println("Enter Which attribute needed to be modified");
        String editor = edit.nextLine();
        
        db.mongoCollection = db.mongoDatabase.getCollection("Book");
        
        Scanner newDataScan = new Scanner(System.in);
        System.out.println("Enter new Data: ");
        String newData = newDataScan.nextLine();
        
        switch(editor) {
            case "BID":
                db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("BID", Integer.valueOf(newData)));
              break;
            case "Title":
              db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("Title", newData));
              break;
            case "Publication Year":
                db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("Publication_Year", newData));
              break;
            case "Author":
                db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("Author", newData));
               break;
            case "Writer_Name":
                db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("Writer_Name", newData));
               break;
            case "Description":
                db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("Description", newData));
               break;
            case "Book_Copys":
                db.mongoCollection.updateOne(Filters.eq("BID", bookID),
                                     Updates.set("Book_Copys.0.Book_BarCode", newData));
               break;
            default:
              //do nothing
      }

    }

    @Override
    public void deleteBook(int BID) {
        db.mongoCollection.deleteOne(Filters.eq("BID", BID));
    }
    
    @Override
    public void insertReport(Report R) {
        if(db.collectionExistance(db.getObejectTitle(R))){
            db.insertDocument(R);
        }else{
            db.addCollection(R);
            db.insertDocument(R);
        }
        System.out.println("Inserted Successfully..");
    } 
    
}
