package controlers;

import RMI.LoginInterface;
import RMI.librarianInterface;
import clientlib.Login;
import clientlib.SystemTools;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    Login login;
    Registry r;
    Registry r2;
    Registry r3;
    
    public LoginController(Login login , Registry r, Registry r2, Registry r3) {
        this.login = login;
        this.r = r;
        this.r2 = r2;
        this.r3 = r3;
        login.getjButton1().addActionListener(new LoginbtnAction());
        login.getjButton2().setVisible(false);
        login.getjButton2().addActionListener(new ResetbtnAction());
        login.getjTextField3().setVisible(false);
        login.getjLabel4().setVisible(false);
        login.getjTextField4().setVisible(false);
        login.getjLabel5().setVisible(false);
        login.getjButton3().setVisible(true);
    }
    class LoginbtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                LoginInterface g = (LoginInterface) r.lookup("login");
                String username = login.getjTextField1().getText();
                String password = login.getjTextField1().getText();
                g.Login(username, password);
                login.getjLabel3().setText("Welcome " + username);
                login.setVisible(false);
                SystemTools s = new SystemTools(username);
                s.setVisible(true);
                SystemToolsContr ss = new SystemToolsContr(s, r2, r3);
            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ResetbtnAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                
                LoginInterface g = (LoginInterface) r.lookup("login"); 
                
                
                int ssn =  Integer.parseInt(login.getjTextField4().getText());
                String password = login.getjTextField3().getText();
                
                g.ResetPassword(ssn, password);
                
               
            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
