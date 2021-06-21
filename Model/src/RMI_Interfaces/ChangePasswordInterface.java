package RMI_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChangePasswordInterface extends Remote {

    public String change(String userID, String OldPassword, String NewPassword) throws RemoteException;

}
