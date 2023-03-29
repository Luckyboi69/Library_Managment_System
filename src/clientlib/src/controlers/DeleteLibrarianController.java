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
import clientlib.DeleteLibrarian;
/**
 *
 * @author Ahmed salah
 */
public class DeleteLibrarianController {
     Registry r;
     DeleteLibrarian gui;

    public DeleteLibrarianController(Registry r, DeleteLibrarian gui) {
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
                AdminInterface g = (AdminInterface) r.lookup("DeleteLibrarian");
               
                String value1 = gui.getjTextField1().getText();
               System.out.println(value1);
                 g.DeleteLibrarian(value1);
                
                gui.setVisible(false);
                
                //gui.getjLabel1().setText("done");
               
            } catch (RemoteException ex) {
                Logger.getLogger(DeleteLibrarianController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(DeleteLibrarianController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
