package UserPackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NewClass {

    public static void main(String args[]) throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(5050);
            LoginImplement lp = new LoginImplement();
            ChangePasswordImplement ch = new ChangePasswordImplement();
            TakenImplement tk = new TakenImplement();
            MedicineImplement md = new MedicineImplement();
            reg.rebind("login", lp);
            reg.rebind("change", ch);
            reg.rebind("taken", tk);
            reg.rebind("medicine", md);
            System.out.println("Server is ready");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
