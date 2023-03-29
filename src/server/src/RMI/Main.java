package RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
//
public class Main {
   public static void main(String[] args)throws RemoteException, AlreadyBoundException{
        
//       RoomSubscription d = new RoomSubscription();
//       Credit_Payment s;
//       PayPal_Payment p;
//       p = new PayPal_Payment("Seif", "Hammam");
//       s = new Credit_Payment("ahmed","banna","qwqw","qwqw");
//       d.pay(p,50);
//       d.pay(s,50);
       
       
       Scanner sc = new Scanner(System.in);
       String x = sc.nextLine();
       
       if(x.equals("Client")){
           librarianInterface l= new Librarian(11,"banna","password","email",123,124124);
            l.setm();
            Admin a=Admin.getAdmin_Instance();
            LoginInterface login = new LoginController();
            login.setAccount();

            ProfileInterface profile = new ProfileController();
            SystemToolsInterface tools = new Customer(0.00, true, 0, 0, "", "", "", 0, 0);
            Registry r = LocateRegistry.createRegistry(500);
            Registry r2 = LocateRegistry.createRegistry(600);
            Registry r3 = LocateRegistry.createRegistry(700);
            //UnicastRemoteObject.exportObject(l,500);
            //UnicastRemoteObject.exportObject(a,500);
            UnicastRemoteObject.exportObject(login,500);
            UnicastRemoteObject.exportObject(profile,600);
            UnicastRemoteObject.exportObject(tools,700);
            //r.bind("librarian", l);
            //r.bind("Admin", a);
            r.bind("login", login);
            r2.bind("profile", profile);
            r3.bind("Tools", tools);
            System.out.println("The server is ready");
       }
       else{
           DatabaseController db = new DatabaseController();
        
        librarianInterface l= new Librarian(11,"banna","password","email",123,124124);l.setm();
            Admin a=Admin.getAdmin_Instance();
            Author aa=new Author("qw",1313,"aqe","2ewer");
          
            aa.requestEvent(12, "i dont know", "ihope this runs", "please god", 0);
            aa.requestEvent(132, "wefwef", "please wefwefgod","eqefqf", 30);
            aa.requestDigitalBook(1234, "ahmewd", "yarrdab", "add3w");
          
                 Registry r = LocateRegistry.createRegistry(500);
                 UnicastRemoteObject.exportObject(l,500);
                 UnicastRemoteObject.exportObject(a,500);
                 r.bind("librarian", l);
                 r.bind("DeleteBook", l); 
                 r.bind("ModifyBook", l);
                 r.bind("AddBook", l);        
                 r.bind("Admin", a);
                 r.bind("Reports", a);
                 r.bind("AddRoom", a);
                 r.bind("DeleteRoom", a);
                 r.bind("ModifyRoom", a);
                 r.bind("DeleteLibrarian", a);
                 r.bind("AcceptEvent", a);
                 r.bind("AcceptDBook", a);
                 r.bind("ModifyLibrarian", a);
                System.out.println("The server is ready");
       } 
 }
}