package RMI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.rmi.server.UnicastRemoteObject;

public class Admin   implements AdminInterface{
    AdminMapper a = new AdminMapperImpl();
     private  ArrayList<Event> RequstedEvents_List =  new ArrayList<>();
      private  ArrayList<DigitalBook> Publish_Request_List =  new ArrayList<>();
       private  ArrayList<Report> ReportsForms_List =  new ArrayList<>();
    private static Admin Admin_Instance = new Admin();
   /* private  ArrayList<Customer> Customer =  new ArrayList<>();
    private  ArrayList<Author> Author_List =  new ArrayList<>();
    private  ArrayList<Librarian> Librarian_List =  new ArrayList<>();
    private  ArrayList<Event> RequstedEvents_List =  new ArrayList<>();
    private  ArrayList<DigitalBook> Publish_Request_List =  new ArrayList<>();
    private  ArrayList<Report> ReportsForms_List =  new ArrayList<>();*/

    private  Admin() {
    }

    public ArrayList<Event> getRequstedEvents_List() {
        return RequstedEvents_List;
    }

    public void setRequstedEvents_List(ArrayList<Event> RequstedEvents_List) {
        this.RequstedEvents_List = RequstedEvents_List;
    }


   
    public static Admin getAdmin_Instance() {
        if(Admin_Instance==null){
            
            Admin_Instance= new Admin();
        }
        return Admin_Instance;
    }

    public ArrayList<DigitalBook> getPublish_Request_List() {
        return Publish_Request_List;
    }

    public void setPublish_Request_List(ArrayList<DigitalBook> Publish_Request_List) {
        this.Publish_Request_List = Publish_Request_List;
    }

    public AdminMapper getA() {
        return a;
    }

    public void setA(AdminMapper a) {
        this.a = a;
    }

    public ArrayList<Report> getReportsForms_List() {
        return ReportsForms_List;
    }

    public void setReportsForms_List(ArrayList<Report> ReportsForms_List) {
        this.ReportsForms_List = ReportsForms_List;
    }

   
    //-------------------Rest of the functions-----------------------------------
    
    //public void View_Reports(){}
    //public void AddRoom(){}
    //public void ModifyRoom(){}
    //public void DeleteRoom(){}
      
    //public void DeclineRequestedEvents(){} 
    //public void EditRequestedEvents(){} 
    //public void AddLibrarian(){} 
    //public void ModifyLibrarian(){} 
    //public void DeleteLibrarian(){} 
    //public void AcceptPublishRequest(){}
    //public void DeclinePublishRequest(){} 
    //public void EditPublishRequest(){} 
    public void AddRoom(Room.TypeOfRoom RoomClass,int RoomID, String RoomFloor){
        RoomDuration one=new RoomDuration("10:00","12:00");
        RoomDuration Two=new RoomDuration("12:00","02:00");
        RoomDuration three=new RoomDuration("02:00","04:00");
        RoomDuration four=new RoomDuration("04:00","06:00");
        ArrayList<RoomDuration> RoomSchedual= new ArrayList<RoomDuration>();
        RoomSchedual.add(one);
        RoomSchedual.add(Two);
        RoomSchedual.add(three);
        RoomSchedual.add(four);
        Room newRoom = new Room(RoomClass,RoomID,RoomSchedual,RoomFloor);
        a.insertRoom(newRoom);
    }
    public String ViewReports(){
        String text ="";
         setReportsForms_List(a.viewReports());
         ArrayList<Report> d= a.viewReports();
         for(int i=0;i<d.size();i++){
             text = text+"Report ID  :"+d.get(i).getReportID()+"\n";
             text = text+"Account ID  :"+d.get(i).getAccountID()+"\n";
             text = text+"Description :"+d.get(i).getReprotDescription()+"\n\n"; 
          
            
        }
         System.out.println(text);
         return text;
    }
    public void DeleteRoom(int RoomID){
    a.deleteRoom(RoomID);
    }
    public void ModifyRoom(int id,String edited,String newdata){
    a.modifyRoom(id, edited, newdata);
    
    }
    public void AddLibrarian(int Salary, int National_ID, String Username, String Password, String Email, int Age, int Phone_Number) throws RemoteException{
    Librarian l=new Librarian(Salary,National_ID,Username,Password,Email,Age,Phone_Number);
    a.insertLibrarian(l);
    
    
    }
    public void DeleteLibrarian(String libID){
    a.deleteLibrarian(libID);
    }
    public void acceptEventRequest(int eventid){
        for(int i=0;i<getRequstedEvents_List().size();i++){
        if(getRequstedEvents_List().get(i).getEvent_id()==eventid){
            a.insertAcceptedEvent(getRequstedEvents_List().get(i));
            getRequstedEvents_List().remove(i);
        }
      }
    }
    public void DeclineEvent(int eventid){
        for(int i=0;i<getRequstedEvents_List().size();i++){
        if(getRequstedEvents_List().get(i).getEvent_id()==eventid){
            getRequstedEvents_List().remove(i);
        }
      }
    }
    
    
    
      public void acceptPublishRequest(int BookID){
        for(int i=0;i<getPublish_Request_List().size();i++){
        if(getPublish_Request_List().get(i).getBookID()==BookID){
            a.insertAccpetedDigitalBook(getPublish_Request_List().get(i));
            getPublish_Request_List().remove(i);
        }
      }
    }
   public void DeclinePublishRequest(int BookID){
        for(int i=0;i<getPublish_Request_List().size();i++){
        if(getPublish_Request_List().get(i).getBookID()==BookID){
            getPublish_Request_List().remove(i);
        }
      }
    }
  public void ModifyLibrarianData(int id,String att,String newdata){
      a.modifyLibrarian(id,  att, newdata);
  }
}