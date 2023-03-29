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
import RMI.librarianInterface;
import clientlib.ModifyBook;

/**
 *
 * @author Ahmed salah
 */
public class ModifyBookController {
    ModifyBook gui;
    Registry r;

    public ModifyBookController(ModifyBook gui, Registry r) {
        this.gui = gui;
        this.r = r;
           gui.getjButton1().addActionListener(new getbtnAction());
    }
        class getbtnAction implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                librarianInterface g = (librarianInterface) r.lookup("ModifyBook");
               
                 int value1 = Integer.parseInt(gui.getjTextField1().getText());
                 String value2= gui.getjTextField2().getText();
                 String value3= gui.getjTextField3().getText();
              
                 g.ModifyBookData(value1, value2, value3);
                
                gui.setVisible(false);
                
                //gui.getjLabel1().setText("done");
               
            } catch (RemoteException ex) {
                Logger.getLogger(ModifyBookController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ModifyBookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
}
