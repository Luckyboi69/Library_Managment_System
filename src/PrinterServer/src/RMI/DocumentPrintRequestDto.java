package RMI;

import java.io.Serializable;

public class DocumentPrintRequestDto implements Serializable{
    
    private String CustID;
    private Document Doc;

    public DocumentPrintRequestDto(String CustID, Document doc) {
        this.CustID = CustID;
        this.Doc = new Document();
        this.Doc.setSize(doc.getSize());
        this.Doc.setTitle(doc.getTitle());
        this.Doc.setType(doc.getType());
    }   

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public Document getDoc() {
        return Doc;
    }

    public void setDoc(Document Doc) {
        this.Doc = Doc;
    }
}