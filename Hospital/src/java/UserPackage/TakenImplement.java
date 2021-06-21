
package UserPackage;

import RMI_Interfaces.JaxbMarshaler;
import RMI_Interfaces.TakenInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelPackage.Taken;

public class TakenImplement extends UnicastRemoteObject implements TakenInterface {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/hospital";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbPassword = "kalebot";

    public TakenImplement() throws RemoteException {

    }

    @Override
    public String addTaken(String MedicineName, String patientID, Date StartDate, Date EndDate) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("INSERT INTO taken values(?,?,?,?)");
            ts.setString(1, MedicineName);
            ts.setString(2, patientID);
            ts.setDate(3, StartDate);
            ts.setDate(4, EndDate);

            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

    @Override
    public String updateTaken(String MedicineName, String patientID, Date StartDate, Date EndDate) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Update taken set StartDate=? ,EndDate=? where  MedicineName=? and patientID=?");

            ts.setDate(1, StartDate);
            ts.setDate(2, EndDate);
            ts.setString(3, MedicineName);
            ts.setString(4, patientID);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;
    }

    @Override
    public String deleteTaken(String MedicineName, String patientID, Date StartDate, Date EndDate) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Delete from taken where  MedicineName=? and patientID=? and StartDate=? and EndDate=?");

            ts.setString(1, MedicineName);
            ts.setString(2, patientID);
            ts.setDate(3, StartDate);
            ts.setDate(4, EndDate);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;
    }

    @Override
    public String viewTaken(String patientID) throws RemoteException {

        ArrayList<Taken> list = new ArrayList<Taken>();
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.taken where hospital.taken.patientID='" + patientID + "';");

            while (rs.next()) {
                Taken taken = new Taken();
                taken.setMedicineName(rs.getString("MedicineName"));
                taken.setPatientID(rs.getString("patientID"));
                taken.setStartDate(rs.getDate("StartDate"));
                taken.setEndDate(rs.getDate("EndDate"));
                list.add(taken);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        JaxbMarshaler jb = new JaxbMarshaler();
        return jb.objectToJsonString(list);
    }

}
