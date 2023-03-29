/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RMI.Admin;
import RMI.Room;
import RMI.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class JUnitTest_Admin {
    DatabaseController db = new DatabaseController();
    Admin admin;
  
    @BeforeClass
    public static void setUpClass() {
        		System.out.println("Testing is Running for the class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        		System.out.println("Tesing Done for the class");
    }
    
        @Before
    public void setUp() {
                admin = Admin.getAdmin_Instance();
                System.out.println("This object needed before each test");
    }
    
    @After
    public void tearDown() {
        System.out.println("This is running after each test");
        
    }
    //----------------------------------------------------
    	@Test
    public void ViewReportsTest()
    {
        System.out.println("Test ViewReports");
      String y= "";
       String x= admin.ViewReports();
        assertNotSame(x, y);
        assertNotNull(x);
         assertTrue(x.length() >0);
    }
    @Test
    public void ADDRoomTesr()
    {
        System.out.println("Test AddRoom");
        int roomid=101;
     admin.AddRoom(Room.TypeOfRoom.General, roomid, "third floor");
     //we are going to try to fetch the added object from the database to make sure it was add
     CustomerMapper a = new CustomerMapperImpl();
      assertNotNull( a.getRoom(roomid));
      assertSame(a.getRoom(roomid).getRoomID(), roomid);
      assertTrue(a.getRoom(roomid).getRoomID()==roomid) ;                      
    }
    @Test
    public void updateRoom()
    {
        System.out.println("Test updateRoom");
         CustomerMapper a = new CustomerMapperImpl();
         //assertNotNull( a.getRoom(3));
         admin.ModifyRoom(101, "RoomID", "5005");
     //we are going to try to fetch the updated object from the database to make sure it was updated
         assertNotNull( a.getRoom(5005));
     
                           
    }


 


}
