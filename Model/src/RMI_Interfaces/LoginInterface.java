/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface extends Remote {

    public String login(String userID, String Password) throws RemoteException;

}
