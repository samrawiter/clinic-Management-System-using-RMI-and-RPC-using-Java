/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface MedicineInterface extends Remote{
    
    public String addMedicine(String Name, String ManufacturedCountry,Date ManufacturedDate) throws RemoteException;

    public String updateMedicine(String Name, String ManufacturedCountry,Date ManufacturedDate) throws RemoteException;

    public String deleteMedicine(String Name) throws RemoteException;

    public String viewMedicine(String Name) throws RemoteException;

}
