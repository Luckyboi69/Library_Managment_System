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
import clientlib.AddRoom;

/**
 *
 * @author Ahmed salah
 */
public class AddRoomController {
    Registry r;
    AddRoom gui;

    public AddRoomController(Registry r, AddRoom gui) {
        this.r = r;
        this.gui = gui;
           gui.getjButton1().addActionListener(new getbtnAction());
    }
     class getbtnAction implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                AdminInterface g = (AdminInterface) r.lookup("AddRoom");
                int value1 = Integer.parseInt(gui.getjTextField1().getText());
                String value2 = gui.getjTextField2().getText();
                 String value3 = gui.getjTextField3().getText();
                 if(null!=value3)switch (value3) {
                    case "general":
                        g.AddRoom(Room.TypeOfRoom.General, value1, value2);
                        break;
                    case "delux":
                        g.AddRoom(Room.TypeOfRoom.deluxe, value1, value2);
                        break;
                    case "primem":
                        g.AddRoom(Room.TypeOfRoom.primem, value1, value2);
                        break;
                    default:
                        break;
                }
                
                gui.setVisible(false);
                
                //gui.getjLabel1().setText("done");
               
            } catch (RemoteException ex) {
                Logger.getLogger(AddRoomController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(AddRoomController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
