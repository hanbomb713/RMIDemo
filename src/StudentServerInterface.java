/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;

public interface StudentServerInterface extends Remote {

    /**
     * Return the score for specified the name
     *
     * @param name the student name
     * @return an double score or –1 if the student is not found
     */
    public double findScore(String name) throws RemoteException;
}
