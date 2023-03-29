package RMI;




import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
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
    public void requestMissingBook(MissingBook mb) {        
        if(db.collectionExistance(db.getObejectTitle(mb))){
            db.insertDocument(mb);
        }else{
            db.addCollection(mb);
            db.insertDocument(mb);
        }
        System.out.println("Inserted Successfully..");
    }

    @Override
    public void rentBook(RentedBook rentedbook) {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.RentedBook");
        db.insertDocument(rentedbook);
    }
    
    public Room getRoom(int RoomID) {
      ArrayList <Room> rooms = viewRoomScheduals();
      Room room = new Room();
      for(int i = 0; i < rooms.size(); i++){
          if(rooms.get(i).getRoomID() == RoomID){
              room = rooms.get(i);
          }
      }
      return room;
    }
   
    @Override
    public void rentRoom(int RoomID, String StartDate, String EndDate, String Customeruser){
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.RentedRoom");
        Room room = getRoom(RoomID);
        RentedRoom Rr = new RentedRoom(StartDate, EndDate, room, Customeruser);
        db.insertDocument(Rr);
    }

    @Override
    public void depositMoney(double money, String custID) {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Customer");
        double x = this.getBalance(custID);
        x += money;
        db.mongoCollection.updateOne(Filters.eq("Username", custID),
                                     Updates.set("Account_Balance", x));
    }
    
    @Override
    public void renewBook(int bookID, String custID, String newDate){
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.RentedBook");
        db.mongoCollection.updateOne(Filters.and(Filters.eq("book.BID", bookID), Filters.eq("customerID", custID)), Updates.set("End_date", newDate));
    }
    @Override
    public double getBalance(String Username){
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Customer");
        ArrayList<Document> Doc = (ArrayList<Document>) db.mongoCollection.find().into(new ArrayList<Document>());
        ArrayList<Customer> customers = new ArrayList<Customer>(); 
        double result = 0.0;
        Gson gson = new Gson();
        
        for(int i = 0; i < Doc.size(); i++){
            String jsonResult = Doc.get(i).toJson();
            customers.add(gson.fromJson(jsonResult, RMI.Customer.class));
        }
        
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getUsername().equals(Username)){
                result = customers.get(i).getAccount_Balance();
            }
        }
        
        return result;
    }
}
