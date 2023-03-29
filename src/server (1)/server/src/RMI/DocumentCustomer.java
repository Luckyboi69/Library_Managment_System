package RMI;

public class DocumentCustomer {
    private int CustomerID;
    private Document doc;

    public DocumentCustomer(int CustomerID, Document doc) {
        this.CustomerID = CustomerID;
        this.doc = doc;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
}
