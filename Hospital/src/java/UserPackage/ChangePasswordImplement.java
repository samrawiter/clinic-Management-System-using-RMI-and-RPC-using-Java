package UserPackage;

import RMI_Interfaces.ChangePasswordInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangePasswordImplement extends UnicastRemoteObject implements ChangePasswordInterface {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/hospital";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbPassword = "kalebot";

    public ChangePasswordImplement() throws RemoteException {
    }

    @Override
    public String change(String userID, String OldPassword, String NewPassword) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.user where hospital.user.userID='" + userID + "' and hospital.user.Password='" + OldPassword + "' ;");

            while (rs.next()) {

                PreparedStatement ts = con.prepareStatement("Update USER set Password=? where  userID=?");
                ts.setString(1, NewPassword);
                ts.setString(2, userID);
                ts.executeUpdate();
                bool = "true";
            }

            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return bool;
    }

}
