package RMI_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface TakenInterface extends Remote {

    public String addTaken(String MedicineName, String patientID, Date StartDate, Date EndDate) throws RemoteException;

    public String updateTaken(String MedicineName, String patientID, Date StartDate, Date EndDate) throws RemoteException;

    public String deleteTaken(String MedicineName, String patientID, Date StartDate, Date EndDate) throws RemoteException;

    public String viewTaken(String patientID) throws RemoteException;

}
