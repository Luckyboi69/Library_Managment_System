package RMI;

public class DocumentCustomer {
    private String CustomerID;
    private Document doc;

    public DocumentCustomer(String CustomerID, Document doc) {
        this.CustomerID = CustomerID;
        this.doc = doc;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
}
