package RMI;




import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMapperImpl implements AdminMapper {

    public DatabaseController db;

    public AdminMapperImpl() {
        db = new DatabaseController();
    }

    @Override
    public void insertRoom(Room room) {
        if(db.collectionExistance(db.getObejectTitle(room))){
            db.insertDocument(room);
        }else{
            db.addCollection(room);
            db.insertDocument(room);
        }
        System.out.println("Inserted Successfully..");
    }

    @Override
    public void modifyRoom(int RoomID,String editor ,String newData) {
            boolean reserved=false;
    if(editor=="Reserved"&&newData=="false"){
        reserved=false;
     
    }else if(editor=="Reserved"&&newData=="true"){
     reserved=true;
    }
        
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Room");
        switch(editor) {
            case "RoomID":
                db.mongoCollection.updateOne(Filters.eq("RoomID", RoomID),
                                     Updates.set("RoomID", Integer.valueOf(newData)));
              break;
            case "Reserved":
                db.mongoCollection.updateOne(Filters.eq("RoomID", RoomID),
                                     Updates.set("Reserved", reserved));
              break;
            case "RoomClass":
              db.mongoCollection.updateOne(Filters.eq("RoomID", RoomID),
                                     Updates.set("RoomClass", newData));
              break;
            case "RoomSchedual":
                db.mongoCollection.updateOne(Filters.eq("RoomID", RoomID),
                                     Updates.set("RoomSchedual", newData));
              break;
            case "RoomFloor":
                db.mongoCollection.updateOne(Filters.eq("RoomID", RoomID),
                                     Updates.set("RoomFloor", newData));
               break;
            default:
              //do nothing
        }
    }

    @Override
    public void deleteRoom(int RoomID) {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Room");
        db.mongoCollection.deleteOne(Filters.eq("RoomID", RoomID));
    }

    @Override
    public void insertLibrarian(Librarian librarian) {
        if(db.collectionExistance(db.getObejectTitle(librarian))){
            db.insertDocument(librarian);
        }else{
            db.addCollection(librarian);
            db.insertDocument(librarian);
        }
        System.out.println("Inserted Successfully..");
    }

    @Override
    public void modifyLibrarian(int id,String editor ,String newData) {
       
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Librarian");

        switch(editor) {
            case "National_ID":
                 System.out.println("The server is ready");
                db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("National_ID", Integer.valueOf(newData)));
              break;
            case "Salary":
                 System.out.println("The server is ready");
                db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("Salary", Integer.valueOf(newData)));
              break;
            case "Username":
                db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("Username", newData));
              break;
            case "Password":
              db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("Password", newData));
              break;
            case "Email":
                db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("Email", newData));
              break;
            case "Age":
                db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("Age", newData));
               break;
            case "Phone Number":
                db.mongoCollection.updateOne(Filters.eq("National_ID", id),
                                     Updates.set("Phone_Number", newData));
               break;
            default:
              //do nothing
        }
    }

    @Override
    public void deleteLibrarian(String uname) {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Librarian");
        db.mongoCollection.deleteOne(Filters.eq("Username", uname));

    }

    @Override
    public void insertAcceptedEvent(Event event) {
      if(db.collectionExistance(db.getObejectTitle(event))){
      db.insertDocument(event);
      }else{
          db.addCollection(event);
          db.insertDocument(event);
      }
    }

    @Override
    public void modifyAcceptedEvent(int eventID) {
        Scanner edit = new Scanner(System.in);
        System.out.println("Enter Which attribute needed to be modified");
        String editor = edit.nextLine();
        
        db.mongoCollection = db.mongoDatabase.getCollection("Event");
        
        Scanner newDataScan = new Scanner(System.in);
        System.out.println("Enter new Data: ");
        String newData = newDataScan.nextLine();
        
       switch(editor) {
            case "Event_id":
                db.mongoCollection.updateOne(Filters.eq("Event_id", eventID),
                                     Updates.set("Event_id", Integer.valueOf(newData)));
              break;
            case "Description":
                db.mongoCollection.updateOne(Filters.eq("Event_id", eventID),
                                     Updates.set("Description", newData));
              break;
            case "Event_Date":
              db.mongoCollection.updateOne(Filters.eq("Event_id", eventID),
                                     Updates.set("Event_Date", newData));
              break;
            case "Event_title":
                db.mongoCollection.updateOne(Filters.eq("Event_id", eventID),
                                     Updates.set("Event_title", newData));
              break;
            case "Event_capacity":
                db.mongoCollection.updateOne(Filters.eq("Event_id", eventID),
                                     Updates.set("Event_capacity", Integer.valueOf(newData)));
               break;
           
            default:
              //do nothing
        }
    }
    
    

    @Override
    public void deleteAcceptedEvent(int eventID) { 
        db.mongoCollection = db.mongoDatabase.getCollection("Event");
        db.mongoCollection.deleteOne(Filters.eq("Event_id", eventID));
    }

    @Override
    public void insertAccpetedDigitalBook(DigitalBook digitalBook) {
        if(db.collectionExistance(db.getObejectTitle(digitalBook))){
            db.insertDocument(digitalBook);
        }else{
            db.addCollection(digitalBook);
             db.insertDocument(digitalBook);
        }
    }

    @Override
    public void modifyAccpetedDigitalBook(int digitalBook) {
        Scanner edit = new Scanner(System.in);
        System.out.println("Enter Which attribute needed to be modified");
        String editor = edit.nextLine();
        
        db.mongoCollection = db.mongoDatabase.getCollection("DigitalBook");
        
        Scanner newDataScan = new Scanner(System.in);
        System.out.println("Enter new Data: ");
        String newData = newDataScan.nextLine();
        
       switch(editor) {
            case "BookID":
                db.mongoCollection.updateOne(Filters.eq("BookID", digitalBook),
                                     Updates.set("BookID", Integer.valueOf(newData)));
              break;
            case "Author":
                db.mongoCollection.updateOne(Filters.eq("BookID", digitalBook),
                                     Updates.set("ID", Integer.valueOf(newData)));
              break;
            case "Book_Name":
              db.mongoCollection.updateOne(Filters.eq("BookID", digitalBook),
                                     Updates.set("Book_Name", newData));
              break;
            case "Title":
                db.mongoCollection.updateOne(Filters.eq("BookID", digitalBook),
                                     Updates.set("Event_title", newData));
              break;
           
           
            default:
                 break;
              //do nothing
        }
    }

    @Override
    public void deleteAccpetedDigitalBook(int digitalBook) {
        db.mongoCollection=db.mongoDatabase.getCollection("DigitalBook");
        db.mongoCollection.deleteOne(Filters.eq("BookID", digitalBook));
    }
     public ArrayList<Report> viewReports() {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Report");
        ArrayList<Report> result = new ArrayList();
        ArrayList<org.bson.Document> Doc = (ArrayList<org.bson.Document>) db.mongoCollection.find().into(new ArrayList<org.bson.Document>());
        Gson gson = new Gson();

       for (int i = 0; i < Doc.size(); i++) {
            String jsonResult = Doc.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Report.class));
        }
       
       
        return result;
        
    }
     
     
     public void insertEvent(Event Event) {
        if(db.collectionExistance(db.getObejectTitle(Event))){
            db.insertDocument(Event);
        }else{
            db.addCollection(Event);
            db.insertDocument(Event);
        }
        System.out.println("Inserted Successfully..");
        
        
        
    }
     
     
        public void insertDigitalBook(DigitalBook DigitalBook) {
        if(db.collectionExistance(db.getObejectTitle(DigitalBook))){
            db.insertDocument(DigitalBook);
        }else{
            db.addCollection(DigitalBook);
            db.insertDocument(DigitalBook);
        }
        System.out.println("Inserted Successfully..");
    }
}
