package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CDFacade extends UnicastRemoteObject implements DocumentPrintRequestDtoInterface {

    DocumentCustomer dc;
    Document doc;      
    public CDFacade(String username, Document doc) throws RemoteException {
        this.doc = doc;
        dc = new DocumentCustomer(username, this.doc);
    }
    
    @Override
    public void setDocumentCust(String CustomerID, Document doc) throws RemoteException {
        dc.setCustomerID(CustomerID);
        dc.setDoc(doc);
    }
    
    @Override
    public DocumentPrintRequestDto getObjectPrint() throws RemoteException {
        DocumentPrintRequestDto dtoo = new DocumentPrintRequestDto(dc.getCustomerID(), dc.getDoc());
        return dtoo;
    }

    @Override
    public void printde7k() throws RemoteException {
        System.out.println("Client Connected");
    }
    
}
