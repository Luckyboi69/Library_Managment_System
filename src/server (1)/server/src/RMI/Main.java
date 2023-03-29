//package RMI;
//
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args){
//        //System.setProperty("jdk.tls.trustNamerService", "true");
//        DatabaseController db = new DatabaseController();
//        Admin x=Admin.getAdmin_Instance();
//        AdminMapper a = new AdminMapperImpl();
//        Librarian k =new Librarian(1233,124124,"eefefefrg","23r2f23f42424","23235355",255,78);
//        
//        Customer c = new Customer(100.5, false, 0, 1029384756, "Abdullah0", "aA4122000", "abdullah.yasser33@gmail.com", 21, 01022037625);
//        LoginController l = new LoginController();
//        l.Signup(c);
//        l.Login("Abdullah0", "aA4122000");
////        Event n = new Event(1,"223","13/1313","edtw",4);
////        a.insertAcceptedEvent(n);
//
//
//        //Author aa=new Author("qw",1313,"aqe","2ewer");
//       /// aa.requestDigitalBook(1234, "ahmewd", "yarrdab", "pefwflease god");
//     //   x.acceptPublishRequest(1234);
////       ArrayList<BookCopy> bc = new ArrayList<BookCopy>();
////        
////      BookCopy bb = new BookCopy();
////       bb.setBook_BarCode("123456789");
////       bb.setRented(true);
////        
////       BookCopy bb2 = new BookCopy();
////        bb2.setBook_BarCode("987654321");
////        bb2.setRented(false);
////        
////        bc.add(bb);
////        bc.add(bb2);
////        
////        Book b = new Book(1, "Harry Potter", "2021", "Banna", "banna", "Fantasy magic world", bc);
////        Book b2 = new Book(2, "De7k", "2021", "3aiz", "anam", "Drama", bc);
////        db.addCollection(b);
////        db.getCollection();
////        db.insertDocument(b);
////        db.insertDocument(b2);
////            AdminMapper a = new AdminMapperImpl();
////
////            Room room = new Room();
////            room.setReserved(false);
////            room.setRoomClass(Room.TypeOfRoom.General);
////            room.setRoomFloor("Floor 1");
////            room.setRoomID(1);
////
////            RoomDuration r = new RoomDuration();
////            r.setStartDate("sdf");
////            r.setEndDate("asfdas");
////            r.setReserved(true);
////
////            ArrayList<RoomDuration> x = new ArrayList<RoomDuration>();
////
////            x.add(r);
////
////            room.setRoomSchedual(x);
////
////            a.insertRoom(room);
////          Customer c = new Customer(2000.00, true, 0, 1029384756, "Abdullah", "12345", "abdullah@mail.com", 21, 0122);
////          System.out.println(c.viewBooks());
////          CustomerMapper cc = new CustomerMapperImpl();
////          ArrayList<Room> rooms = cc.viewRoomScheduals();
////          for(Room r : rooms){
////              System.out.println("============================================");
////              System.out.println("Room ID: " + r.getRoomID());
////              System.out.println("Room Class: " + r.getRoomClass());
////              System.out.println("Room Floor: " + r.getRoomFloor());
////              for(int i = 0; i < r.getRoomSchedual().size(); i++){
////                  System.out.println("========================================");
////                  System.out.println("Start Date: " + r.getRoomSchedual().get(i).getStartDate());
////                  System.out.println("End Date: " + r.getRoomSchedual().get(i).getEndDate());
////                  System.out.println("Reserved: " + r.getRoomSchedual().get(i).isReserved());
////              }
////          }
//          
////        
////        LibrarianMapper m = new LibrarianMapperImpl();
////        
////        m.modifyBook(1);
//        
////        m.deleteBook(2);
////        CustomerMapper c = new CustomerMapperImpl();
////        
////        ArrayList<Book> books = c.viewBooks();
////        for (int i = 0; i < books.size(); i++) {
////            System.out.println(books.get(i).getBID());
////            System.out.println(books.get(i).getTitle());
////            System.out.println(books.get(i).getAuthor());
////            System.out.println(books.get(i).getDescription());
////            System.out.println(books.get(i).getPublication_Year());
////            System.out.println("----------------------------------------------");
////        }
////        
////        
////        a.modifyRoom("Room 1");
//
////        int Salary = 10000;
////        Librarian l = new Librarian(Salary, 123456789, "Ali", "1029384756", "ali@gmail.com", 21, 1275538748);
////        Author s = new Author("dd", 33, "fsd", "sdra");
//////        a.insertLibrarian(l);
////        //a.modifyLibrarian("Ali");
////        
//////        Event n = new Event(1,"223","13/1313","edtw",4);
//////        //a.insertAcceptedEvent(n);
////        DigitalBook k=new DigitalBook(13,s,"wafe","qefqef");
//////        a.insertAccpetedDigitalBook(k);
////      //  a.modifyAccpetedDigitalBook(13);
////       // a.deleteAccpetedDigitalBook(1);
////          Event ev = new Event(3, "11414", "1144", "1314", 20, s);
////          a.insertAcceptedEvent(ev);
////       Admin D = Admin.getAdmin_Instance();
//////          
//////          a.insertAcceptedEvent(ev);
////          D.AddRoom(General,12, "dke");
//
//         // a.insertAccpetedDigitalBook(k);
//         
//         try{
//             DocumentPrintRequestDtoInterface dpr = new CDFacade();
//             
//             Registry reg = LocateRegistry.createRegistry(1099);
//             reg.bind("de7k", dpr);
//             System.out.println("De7k started....");
//             
//             
//         }catch (Exception ex){
//             System.out.println("Exception..");
//         }
//                      //  Author aa=new Author("qw",1313,"aqe","2ewer");
//                   //aa.requestEvent(12, "i dont know", "ihope this runs", "please god", 0);
//                   // aa.requestEvent(132, "wefwef", "please wefwefgod","eqefqf", 30);
//                   //System.out.println( x.getRequstedEvents_List().get(0).getDescription());
//                  //aa.requestDigitalBook(1234, "ahmewd", "yarrdab", "pefwflease god");
//                  //DigitalBook b=new DigitalBook(134, "ahmed", "yarrab", "please god");
//                  //a.insertDigitalBook(b);
//                  //  x.acceptPublishRequest(1234);
//                 // x.acceptEventRequest(12);
//                   // x.acceptPublishRequest(134);
//                    //System.out.println( x.getRequstedEvents_List().get(0).getDescription());
//         // a.insertAccpetedDigitalBook(k);
//  // Librarian l=new  Librarian(13, 0, "qeqeqe", "wergwerg", "ergwerg", 0, 0);;
//                 //  a.insertLibrarian(l);
//                  // l.setm();
//                  // l.FileReport(0, 0, "ewfwe");
//                   //Author aa=new Author("qw",1313,"a
//                   
//                   
//                     // k.setm();
//                    //k.FileReport(1, 25355, "29049294024");
//                   // k.FileReport(45, 56546345, "2904elfwf9294024");
//                   //x.ViewReports();
//                  // a.modifyRoom(0, "RoomID", "8558585");
//                  // x.ViewReports();
//                 // x.AddRoom(General, 1, "one");
//                 // x.AddRoom(General, 2, "three");
//                  //x.AddRoom(General, 3, "two");
//                 // x.DeleteRoom(2);
//                  //  a.modifyRoom(1, "RoomID", "1314");
//                   // x.ModifyRoom(3, "Reserved", "true");
//    }
//}