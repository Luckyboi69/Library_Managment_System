/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import RMI.AdminInterface;
import RMI.Room;
import clientlib.ModifyRoom;
/**
 *
 * @author Ahmed salah
 */
public class ModifyRoomController {
     Registry r;
    ModifyRoom gui;

    public ModifyRoomController(Registry r, ModifyRoom gui) {
        this.r = r;
        this.gui = gui;
         gui.getjButton1().addActionListener(new getbtnAction());
    }
    class getbtnAction implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent ae) {
            try {

               
                AdminInterface g = (AdminInterface) r.lookup("ModifyRoom");
                int value1 = Integer.parseInt(gui.getjTextField1().getText());
                String value2 = gui.getjTextField2().getText();
                String value3 = gui.getjTextField3().getText();
            
                 //g.ModifyRoom(value1, "Reserved", value3);
                 switch(value2) {
                case "RoomID":
                g.ModifyRoom(value1, "RoomID", value3);
                 break;
                 
                case "Reserved":
                    if(value3.contains("true"))g.ModifyRoom(value1, "Reserved", "true");
                    if(value3.contains("false"))g.ModifyRoom(value1, "Reserved", "false");
                        
                break;
                
                case "RoomClass":
                    g.ModifyRoom(value1, "RoomClass", value3);
                 break;
  
                case "RoomFloor":
                    g.ModifyRoom(value1, "RoomFloor", value3);
                break;
              default:
        }
          gui.setVisible(false);
               
            } catch (RemoteException ex) {
                Logger.getLogger(ModifyRoomController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ModifyRoomController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
