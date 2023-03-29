package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CDFacade extends UnicastRemoteObject implements DocumentPrintRequestDtoInterface {

    DocumentCustomer dc;
    Document doc;      
    public CDFacade() throws RemoteException {
        dc = new DocumentCustomer(555555, new Document("","",""));
    }
    
    @Override
    public void setDocumentCust(int CustomerID) throws RemoteException {
        dc.setCustomerID(CustomerID);
//        /dto.setDoc(doc);
    }
    
    @Override
    public DocumentPrintRequestDto getObjectPrint() throws RemoteException {
        DocumentPrintRequestDto dtoo = new DocumentPrintRequestDto(dc.getCustomerID());
        return dtoo;
    }

    @Override
    public void printde7k() throws RemoteException {
        System.out.println("a7a");
    }
    
}
