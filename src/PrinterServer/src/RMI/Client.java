package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    @SuppressWarnings("empty-statement")
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        try{
            Registry reg = LocateRegistry.getRegistry(1099);
            DocumentPrintRequestDtoInterface p = (DocumentPrintRequestDtoInterface) reg.lookup("de7k");
            
            //p.setDocumentCust(20);
            p.printde7k();
            
            DocumentPrintRequestDto dto = p.getObjectPrint();
            System.out.println(dto.getCustID());
            System.out.println(dto.getDoc().getTitle());
            System.out.println(dto.getDoc().getType());
            System.out.println(dto.getDoc().getSize());
        }catch(Exception ex){
            System.out.println("exception");
        }
    }
}
