package RMI;

import java.io.Serializable;

public class DocumentPrintRequestDto implements Serializable{
    
    private int CustID;
    //private Document Doc;

    public DocumentPrintRequestDto(int CustID) {
        this.CustID = CustID;
        //this.Doc = Doc;
    }   

    DocumentPrintRequestDto() {
       
    }

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int CustID) {
        this.CustID = CustID;
    }

//    public Document getDoc() {
//        return Doc;
//    }
//
//    public void setDoc(Document Doc) {
//        this.Doc = Doc;
//    }
}
