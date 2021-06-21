/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

import RMI_Interfaces.JaxbMarshaler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelPackage.User;

/**
 *
 * @author kaleb
 */
@WebService(serviceName = "UserWebService")
public class UserWebService {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/hospital";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbPassword = "kalebot";

    @WebMethod(operationName = "addUser")
    public String addUser(@WebParam(name = "userID") String userID,
            @WebParam(name = "Password") String Password,
            @WebParam(name = "FirstName") String FirstName,
            @WebParam(name = "LastName") String LastName,
            @WebParam(name = "MiddleName") String MiddleName,
            @WebParam(name = "Email") String Email,
            @WebParam(name = "Responsibility") String Responsibility,
            @WebParam(name = "Gender") String Gender,
            @WebParam(name = "Age") int Age
    ) {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("INSERT INTO user values(?,?,?,?,?,?,?,?,?,true)");
            ts.setString(1, userID);
            ts.setString(2, Password);
            ts.setString(3, FirstName);
            ts.setString(4, MiddleName);
            ts.setString(5, LastName);
            ts.setString(6, Email);
            ts.setString(7, Responsibility);
            ts.setString(8, Gender);
            ts.setInt(9, Age);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

    @WebMethod(operationName = "updateUser")
    public String updateUser(@WebParam(name = "userID") String userID,
            @WebParam(name = "FirstName") String FirstName,
            @WebParam(name = "LastName") String LastName,
            @WebParam(name = "MiddleName") String MiddleName,
            @WebParam(name = "Email") String Email,
            @WebParam(name = "Responsibility") String Responsibility,
            @WebParam(name = "Gender") String Gender,
            @WebParam(name = "Age") int Age
    ) {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Update USER set "
                    + " FirstName=? ,LastName=? ,MiddleName=? ,Email=? ,Responsibility=? ,Gender=? ,Age=? where  userID=?");

            ts.setString(1, FirstName);
            ts.setString(2, LastName);
            ts.setString(3, MiddleName);
            ts.setString(4, Email);
            ts.setString(5, Responsibility);
            ts.setString(6, Gender);
            ts.setInt(7, Age);
            ts.setString(8, userID);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

    @WebMethod(operationName = "viewUser")
    public String viewUser(@WebParam(name = "viewUser") String userID
    ) {
        User user = new User();

        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.user where hospital.user.userID='" + userID + "';");

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
        JaxbMarshaler jM = new JaxbMarshaler();
        return jM.objectToJsonString(user);

    }

    @WebMethod(operationName = "disableUser")
    public String disableUser(@WebParam(name = "disableUser") String userID
    ) {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Update USER set Active=false where  userID=?");
            ts.setString(1, userID);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

}
