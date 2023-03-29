package controlers;

import RMI.LoginInterface;
import RMI.ProfileInterface;
import clientlib.Profile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProfileController{
    Profile profile;
    Registry r;
    String UserName;
    
    public ProfileController(Profile prof, Registry r, String Username){
        this.profile = prof;
        this.r = r;
        this.UserName = Username;
        profile.getjTextField1().setText(Username);
        profile.getjTextField2().setText(String.valueOf(this.getBalance()));
        profile.getjButton1().addActionListener(new ResetbtnAction());
        profile.getjButton2().addActionListener(new Depositbtn());
        profile.getjButton3().addActionListener(new Subscribe());
        profile.getjButton4().addActionListener(new PintDoc());
        profile.getjButton5().addActionListener(new RenewBook());
    }
    
    private Double getBalance(){
        Double balance = 0.0;
        try {
                ProfileInterface p = (ProfileInterface) r.lookup("profile");

                balance = p.getBalance(UserName);
                
            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        return balance;
    }
    
    class ResetbtnAction implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                
                ProfileInterface p = (ProfileInterface) r.lookup("profile"); 
                
                final JFrame parent = new JFrame();
                String ssn = (String)JOptionPane.showInputDialog(parent,
                            "What is your ssn?", null);
                
                String password = (String)JOptionPane.showInputDialog(parent,
                            "What is the new Password?", null);
                
                p.ResetPassword(Integer.parseInt(ssn), password);
                
               
            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class Depositbtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
        
            try {
                final JFrame parent = new JFrame();
                String money = (String)JOptionPane.showInputDialog(parent,
                            "How much to deposite?", null);
                
                ProfileInterface p = (ProfileInterface) r.lookup("profile"); 
                p.depositMoney(Double.valueOf(money), UserName);

            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class PintDoc implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                final JFrame parent = new JFrame();
                String type = (String)JOptionPane.showInputDialog(parent,
                            "What is type of document?", null);
                
                String size = (String)JOptionPane.showInputDialog(parent,
                            "What is the size of document?", null);
                
                String title = (String)JOptionPane.showInputDialog(parent,
                            "What is the title of document?", null);
                
                ProfileInterface p = (ProfileInterface) r.lookup("profile"); 
                
                p.printDocument(UserName, type, size, title);

            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class RenewBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                final JFrame parent = new JFrame();
                String bookID = (String)JOptionPane.showInputDialog(parent,
                            "What is type of document?", null);
                
                String newDate = (String)JOptionPane.showInputDialog(parent,
                            "What is the size of document?", null);
               
                int bookid = Integer.parseInt(bookID);
                
                ProfileInterface p = (ProfileInterface) r.lookup("profile"); 
                
                p.renewBook(bookid, UserName , newDate);

            } catch (RemoteException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }    
    
    class Subscribe implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
}
