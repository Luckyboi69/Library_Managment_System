package controlers;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import RMI.SystemToolsInterface;
import clientlib.Feedback;
import clientlib.Profile;
import clientlib.SystemTools;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SystemToolsContr{
    SystemTools sys;
    Registry r;
    Registry r2;
    
    public SystemToolsContr(SystemTools sys , Registry r, Registry r2) {
        this.sys = sys;
        this.r = r;
        this.r2 = r2;
        sys.getjButton1().addActionListener(new ViewBooksBtn());
        sys.getjButton2().addActionListener(new SearchBook());
        sys.getjButton3().addActionListener(new MakeFeedback());
        sys.getjButton4().addActionListener(new RentBook());
        sys.getjButton5().addActionListener(new RequestMissingBook());
        sys.getjButton6().addActionListener(new ViewRooms());
        sys.getjButton7().addActionListener(new ViewRoomScheduals());
        sys.getjButton8().addActionListener(new RentRoom());
        sys.getjButton9().addActionListener(new openProfile());
    }
    
    class ViewBooksBtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
                sys.getjTextArea1().selectAll();
                sys.getjTextArea1().replaceSelection("");
                for(int i = 0; i < st.viewBooks().size(); i++){
                    if(i % 4 == 0 && i != 0){
                        sys.getjTextArea1().append("\n");
                    }
                    sys.getjTextArea1().append(st.viewBooks().get(i) + "\n");
                }
                
            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class SearchBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            sys.getjTextArea1().selectAll();
            sys.getjTextArea1().replaceSelection("");
            try{
               SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
               final JFrame parent = new JFrame();
                String title = (String)JOptionPane.showInputDialog(parent,
                            "What Title Are You Looking For?", null);

                String x = st.getBook(title);
                String[] bookDetails = x.split(":"); 
                for(String detail : bookDetails){
                    sys.getjTextArea1().append(detail + "\n");
                }

            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class MakeFeedback implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            sys.getjTextArea1().selectAll();
            sys.getjTextArea1().replaceSelection("");
            Feedback feedback = new Feedback();
            feedback.setVisible(true);
            FeedbackController feedbackC = new FeedbackController(feedback, r);
        }    
    }
    
    class RentBook implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            sys.getjTextArea1().selectAll();
            sys.getjTextArea1().replaceSelection("");
            try{
               SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
               final JFrame parent = new JFrame();
                String title = (String)JOptionPane.showInputDialog(parent,
                            "What Title Are You Looking For?", null);

                st.RentBook(title);

            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    class RequestMissingBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            sys.getjTextArea1().selectAll();
            sys.getjTextArea1().replaceSelection("");
            try{
               SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
               final JFrame parent = new JFrame();
                String title = (String)JOptionPane.showInputDialog(parent,
                            "What Book Title Do You Want?", null);
                String name = (String)JOptionPane.showInputDialog(parent,
                            "What Is Author Name?", null);

                st.requestMissingBook(title, name);

            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    class ViewRooms implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
                sys.getjTextArea1().selectAll();
                sys.getjTextArea1().replaceSelection("");
                for(int i = 0; i < st.viewRooms().size(); i++){
                    if(i % 15 == 0 && i != 0){
                        sys.getjTextArea1().append("\n");
                    }
                    sys.getjTextArea1().append(st.viewRooms().get(i) + "\n");
                }
                
            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class ViewRoomScheduals implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
                sys.getjTextArea1().selectAll();
                sys.getjTextArea1().replaceSelection("");
                final JFrame parent = new JFrame();
                String id = (String)JOptionPane.showInputDialog(parent,
                            "What Book Title Do You Want?", null);
                for(int i = 0; i < st.viewRoomScheduals(Integer.parseInt(id)).size(); i++){
                    if(i % 12 == 0 && i != 0){
                        sys.getjTextArea1().append("\n");
                    }
                    sys.getjTextArea1().append(st.viewRoomScheduals(Integer.parseInt(id)) + "\n");
                }
                
            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class RentRoom implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            sys.getjTextArea1().selectAll();
            sys.getjTextArea1().replaceSelection("");
            try{
               SystemToolsInterface st = (SystemToolsInterface) r.lookup("Tools");
               final JFrame parent = new JFrame();
                String id = (String)JOptionPane.showInputDialog(parent,
                            "What ID Are You Looking For?", null);
                String StartDate = (String)JOptionPane.showInputDialog(parent,
                            "What Start Date Are You Looking For?", null);
                String EndDate = (String)JOptionPane.showInputDialog(parent,
                            "What End Date Are You Looking For?", null);

                st.RentRoom(Integer.parseInt(id), StartDate, EndDate);

            }catch(RemoteException ex){
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(libcont.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    class openProfile implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            sys.getjTextArea1().selectAll();
            sys.getjTextArea1().replaceSelection("");
            sys.setVisible(false);
            Profile profile = new Profile();
            profile.setVisible(true);
            ProfileController profileC = new ProfileController(profile, r2, sys.getUserName());
        }
        
    }
}
