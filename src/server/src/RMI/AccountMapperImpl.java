package RMI;

import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;

public class AccountMapperImpl implements AccountMapper {
    private DatabaseController db;
    public AccountMapperImpl(){
        db = new DatabaseController();
    }

    @Override
    public void insertCustomer(Customer customer) {
        if(db.collectionExistance(db.getObejectTitle(customer))){
            db.insertDocument(customer);
        }else{
            db.addCollection(customer);
            db.insertDocument(customer);
        }
        System.out.println("Inserted Successfully..");
    }
    
    @Override
    public ArrayList<String> getUserAccount(){
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Customer");
        ArrayList<org.bson.Document> Doc = (ArrayList<org.bson.Document>) db.mongoCollection.find().into(new ArrayList<org.bson.Document>());
        ArrayList<Customer> customer = new ArrayList<Customer>();
        ArrayList<String> result = new ArrayList<String>();
        Gson gson = new Gson();
        
        for(int i = 0; i < Doc.size(); i++){
            String jsonResult = Doc.get(i).toJson();
            customer.add(gson.fromJson(jsonResult, RMI.Customer.class));
            result.add((customer.get(i).getUsername() + ":" + customer.get(i).getPassword()));
        }
        
        return result;
    }

    @Override
    public List<Integer> getUsersSsn() {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Customer");
        ArrayList<org.bson.Document> Doc = (ArrayList<org.bson.Document>) db.mongoCollection.find().into(new ArrayList<org.bson.Document>());
        ArrayList<Customer> customer = new ArrayList<Customer>();
        Gson gson = new Gson();
        
        List<Integer> usersSsn = new ArrayList<Integer>();
        
        for(int i = 0; i < Doc.size(); i++){
            String jsonResult = Doc.get(i).toJson();
            customer.add(gson.fromJson(jsonResult, RMI.Customer.class));
            usersSsn.add((customer.get(i).getNational_ID()));
        }
        return usersSsn;
    }

    @Override
    public void ResetAccountPass(int ssn, String newPassword) {
        db.mongoCollection = db.mongoDatabase.getCollection("RMI.Customer");
        db.mongoCollection.updateOne(Filters.eq("National_ID", ssn),
                                     Updates.set("Password", newPassword));
 
    }
}
