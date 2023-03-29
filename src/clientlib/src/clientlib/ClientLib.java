/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientlib;


import clientlib.Login;
import controlers.LoginController;
import controlers.SystemToolsContr;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        Login l = new Login();
        l.setLocationRelativeTo(null);
        l.setVisible(true);

        Registry r2 = LocateRegistry.getRegistry(500);
        Registry r3 = LocateRegistry.getRegistry(600);
        Registry r = LocateRegistry.getRegistry(700);
        LoginController controller = new LoginController(l,r2, r, r3);
        l.setVisible(true);
    }
}
