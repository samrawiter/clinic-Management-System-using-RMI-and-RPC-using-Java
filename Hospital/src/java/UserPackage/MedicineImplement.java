package UserPackage;

import RMI_Interfaces.JaxbMarshaler;
import RMI_Interfaces.MedicineInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import modelPackage.Medicine;

public class MedicineImplement extends UnicastRemoteObject implements MedicineInterface {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/hospital";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbPassword = "kalebot";

    public MedicineImplement() throws RemoteException {

    }

    @Override
    public String addMedicine(String Name, String ManufacturedCountry, Date ManufacturedDate) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("INSERT INTO medicine values(?,?,?)");
            ts.setString(1, Name);
            ts.setString(2, ManufacturedCountry);
            ts.setDate(3, ManufacturedDate);

            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;
    }

    @Override
    public String updateMedicine(String Name, String ManufacturedCountry, Date ManufacturedDate) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Update medicine set ManufacturedCountry=? ,ManufacturedDate=? where  Name=?");

            ts.setString(1, ManufacturedCountry);
            ts.setDate(2, ManufacturedDate);
            ts.setString(3, Name);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;
    }

    @Override
    public String deleteMedicine(String Name) throws RemoteException {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("delete from medicine where Name=? ");
            ts.setString(1, Name);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;
    }

    @Override
    public String viewMedicine(String Name) throws RemoteException {
        Medicine medicine = new Medicine();

        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.medicine where hospital.medicine.Name='" + Name + "';");

            while (rs.next()) {
                medicine.setName(rs.getString("Name"));
                medicine.setManufacturedCountry(rs.getString("ManufacturedCountry"));
                medicine.setManufacturedDate(rs.getDate("ManufacturedDate"));

            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        JaxbMarshaler jM = new JaxbMarshaler();
        return jM.objectToJsonString(medicine);
    }

}
