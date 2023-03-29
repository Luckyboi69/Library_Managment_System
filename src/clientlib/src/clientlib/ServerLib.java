/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientlib;


import controlers.AcceptDBookController;
import controlers.AcceptEventController;
import controlers.AddBookController;
import controlers.AddLibrarianController;
import controlers.AddRoomController;
import controlers.DeleteBookController;
import controlers.DeleteLibrarianController;
import controlers.ModifyBookController;
import controlers.ModifyLibrarianController;
import controlers.ModifyRoomController;
import controlers.ReportsController;
import controlers.deleteRoomController;
import controlers.libcont;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Ahmed salah
 */
public class ServerLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException{
        // TODO code application logic here
        FileReport f= new FileReport();
        AddLibrarian l= new AddLibrarian();
        ViewReports x=new ViewReports();
        AddRoom aa=new AddRoom();
        DeleteRoom dr=new DeleteRoom();
        ModifyRoom mr =new ModifyRoom();
        DeleteLibrarian dl= new DeleteLibrarian();
        AcceptEvent av =new AcceptEvent();
        AcceptDBook adb =new AcceptDBook();
        ModifyLibrarian ml =new  ModifyLibrarian();
        DeleteBookData DB=new  DeleteBookData();
        AddBook ab = new AddBook();
        ModifyBook mb=new ModifyBook();
        
        f.setLocationRelativeTo(null);
        f.setVisible(true); 
        l.setLocationRelativeTo(null); 
        l.setVisible(false);
        x.setLocationRelativeTo(null); 
        x.setVisible(false);
        aa.setLocationRelativeTo(null);
        aa.setVisible(false);
        dr.setLocationRelativeTo(null); 
        dr.setVisible(false);
        mr.setLocationRelativeTo(null); 
        mr.setVisible(true);
        dl.setLocationRelativeTo(null); 
        dl.setVisible(false);
        av.setLocationRelativeTo(null); 
        av.setVisible(false);
        adb.setLocationRelativeTo(null); 
        adb.setVisible(false);
        ml.setLocationRelativeTo(null); 
        ml.setVisible(false);
        DB.setLocationRelativeTo(null); 
        DB.setVisible(false);
        ab.setLocationRelativeTo(null); 
        ab.setVisible(true);
        mb.setLocationRelativeTo(null); 
        mb.setVisible(false);
       
        Registry r = LocateRegistry.getRegistry(500);
        libcont controller = new libcont(f,r);
        AddLibrarianController admincon = new AddLibrarianController(l,r);
        ReportsController  reports = new ReportsController(r,x);
        AddRoomController Addroom=new AddRoomController(r,aa);
        deleteRoomController cont= new deleteRoomController(r,dr);
        ModifyRoomController mrc =new ModifyRoomController(r,mr);
        DeleteLibrarianController dlc= new DeleteLibrarianController(r,dl);
        AcceptEventController aec= new  AcceptEventController(av,r);
        AcceptDBookController adbc = new AcceptDBookController(adb,r);
        ModifyLibrarianController mlc =new ModifyLibrarianController(ml,r);
        DeleteBookController DBC= new DeleteBookController(DB,r);
        AddBookController abc=new AddBookController (ab,r);
        ModifyBookController mbc=new ModifyBookController(mb,r);
    }
    
}
