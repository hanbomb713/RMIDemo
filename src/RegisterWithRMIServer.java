/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.registry.*;

public class RegisterWithRMIServer {

    /**
     * Main method
     */
    public static void main(String[] args) {
        try {
            StudentServerInterface obj
                    = new StudentServerInterfaceImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("StudentServerInterfaceImpl", obj);
            System.out.println("Student server " + obj + " registered");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
