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
import clientlib.FileReport;
/**
 *
 * @author Ahmed salah
 */
public class libcont {
    FileReport gui;
    Registry  r;

    public libcont(FileReport gui, Registry r) {
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
                librarianInterface g = (librarianInterface) r.lookup("librarian");
                
                // Get the grade (in numbers) as it is written inside the text field
                // Please note that we are able to interact with the gui elements through
                // the getters that we have set up earlier
                
                // Also we are parsing to int below because by default, the text field
                // will return a string
                int value1 = Integer.parseInt(gui.getjTextField1().getText());
                int value2 = Integer.parseInt(gui.getjTextField2().getText());
                String value3 = gui.getjTextField3().getText();
                // Once we have the grade as numbers, we can pass it to the remote
                // function getGrade using our remote reference g
                 g.FileReport(value1,value2,value3);
                
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                gui.getjLabel1().setText("done");
               
            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
