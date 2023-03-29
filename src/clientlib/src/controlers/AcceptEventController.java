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
import clientlib.AcceptEvent;
/**
 *
 * @author Ahmed salah
 */
public class AcceptEventController {
      AcceptEvent gui;
      Registry  r;

    public AcceptEventController(AcceptEvent gui, Registry r) {
        this.gui = gui;
        this.r = r;
      gui.getjButton1().addActionListener(new getbtnAction());
    }
     class getbtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

               int value1 = Integer.parseInt(gui.getjTextField1().getText());
                AdminInterface g = (AdminInterface) r.lookup("AcceptEvent");
                g.acceptEventRequest(value1);
               
                 gui.setVisible(false);
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                //gui.getjLabel1().setText("done");
               
            } catch (RemoteException ex) {
                Logger.getLogger(AcceptEventController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(AcceptEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
    }
      
}
