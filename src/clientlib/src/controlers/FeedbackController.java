package controlers;

import RMI.SystemToolsInterface;
import clientlib.Feedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeedbackController {
    Feedback feed;
    Registry r;
    
    public FeedbackController(Feedback feed , Registry r) {
        this.feed = feed;
        this.r = r;
        feed.getjButton1().addActionListener(new MakeFeedbackBtn());
    }
    class MakeFeedbackBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try{
                int id = Integer.parseInt(feed.getjTextField1().getText());
                String title = feed.getjTextField2().getText();
                String Desc = feed.getjTextField3().getText();
                int rate =  Integer.parseInt(feed.getjTextField4().getText());
                
                SystemToolsInterface st = (SystemToolsInterface) r.lookup("login");
                st.makeFeedback(id, title, Desc, rate);

            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }  
            
            
        }
        
    }
}
