package RMI;




import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Iterator;
import org.bson.Document;


public class CustomerMapperImpl implements CustomerMapper{

    private DatabaseController db;
    public CustomerMapperImpl(){
        db = new DatabaseController();
    }

    @Override
    public ArrayList<BookReadOnly> viewBooks() {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Book");
        ArrayList<BookReadOnly> result = new ArrayList<BookReadOnly>();
        ArrayList<Document> Doc = (ArrayList<Document>) db.mongoCollection.find().into(new ArrayList<Document>());
        Gson gson = new Gson();

       for (int i = 0; i < Doc.size(); i++) {
            String jsonResult = Doc.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Book.class));
        }
        return result;
        
    }

    @Override
    public ArrayList<Room> viewRoomScheduals() {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Room");
        ArrayList<Document> Doc = (ArrayList<Document>) db.mongoCollection.find().into(new ArrayList<Document>());
        ArrayList<Room> result = new ArrayList<Room>();
        Gson gson = new Gson();
        
        for(int i = 0; i < Doc.size(); i++){
            String jsonResult = Doc.get(i).toJson();
            result.add(gson.fromJson(jsonResult, RMI.Room.class));
        }
        
        return result;
    }

    @Override
    public void reserveRoom() {
        
    }
    
    
}
