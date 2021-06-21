package UserPackage;

import RMI_Interfaces.JaxbMarshaler;
import RMI_Interfaces.LoginInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelPackage.User;

public class LoginImplement extends UnicastRemoteObject implements LoginInterface {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/hospital";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbPassword = "kalebot";

    public LoginImplement() throws RemoteException {

    }

    @Override
    public String login(String userID, String Password) throws RemoteException {
        User user = new User();
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.user where hospital.user.userID='" + userID + "' and hospital.user.Password='" + Password + "' ;");

            while (rs.next()) {
                user.setUserID(rs.getString("userID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setMiddleName(rs.getString("MiddleName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setResponsibility(rs.getString("Responsibility"));
                user.setGender(rs.getString("Gender"));
                user.setAge(rs.getInt("Age"));
                user.setActive(rs.getBoolean("Active"));

            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        JaxbMarshaler jb = new JaxbMarshaler();
        return jb.objectToJsonString(user);
    }

}
