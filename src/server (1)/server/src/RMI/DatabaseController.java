package RMI;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static java.lang.reflect.Modifier.TRANSIENT;
import org.bson.Document;

public class DatabaseController {
    public MongoClient mongoClient;
    public MongoDatabase mongoDatabase;
    public MongoCollection mongoCollection;
    
    public DatabaseController(){
        mongoClient = new MongoClient("localhost", 27017);
        mongoDatabase = mongoClient.getDatabase("LibararyManagmentSystem");
    }
   
    public String getObejectTitle(Object object){
       String collectionName = object.toString(); 
       collectionName = collectionName.substring(0, collectionName.indexOf('@'));
       return collectionName;
    }
    
    public void addCollection(Object object){
       String collectionName = getObejectTitle(object);
       mongoDatabase.createCollection(collectionName);       
    }
    
    public boolean collectionExistance(String collection){
        boolean existed = false;
        for(String name : mongoDatabase.listCollectionNames()){
           if(name.equals(collection)){
               existed = true;
               break;
           }else{
               existed = false;
           }
       }
        return existed;
    }
    
    public void insertDocument(Object object){
        System.out.println(object.getClass().getTypeName());
        Gson gson= new Gson();
        String Json = gson.toJson(object);
        mongoCollection = mongoDatabase.getCollection(getObejectTitle(object));
        mongoCollection.insertOne(Document.parse(Json));
        System.out.println("Inserted Succssfully..");
    }
    
}
