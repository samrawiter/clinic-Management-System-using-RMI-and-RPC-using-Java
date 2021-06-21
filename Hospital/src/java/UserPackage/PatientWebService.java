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
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelPackage.Patient;

@WebService(serviceName = "PatientWebService")
public class PatientWebService {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/hospital";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String dbPassword = "kalebot";

    @WebMethod(operationName = "addPatient")
    public String addPatient(@WebParam(name = "patientID") String patientID,
            @WebParam(name = "FirstName") String FirstName,
            @WebParam(name = "LastName") String LastName,
            @WebParam(name = "MiddleName") String MiddleName,
            @WebParam(name = "Gender") String Gender,
            @WebParam(name = "Age") int Age,
            @WebParam(name = "RegisteredBy") String RegisteredBy
    ) {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("INSERT INTO patient values(?,?,?,?,?,?,true,?)");
            ts.setString(1, patientID);
            ts.setString(2, FirstName);
            ts.setString(3, LastName);
            ts.setString(4, MiddleName);
            ts.setString(5, Gender);
            ts.setInt(6, Age);
            ts.setString(7, RegisteredBy);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

    @WebMethod(operationName = "updatePatient")
    public String updatePatient(@WebParam(name = "patientID") String patientID,
            @WebParam(name = "FirstName") String FirstName,
            @WebParam(name = "LastName") String LastName,
            @WebParam(name = "MiddleName") String MiddleName,
            @WebParam(name = "Gender") String Gender,
            @WebParam(name = "Age") int Age,
            @WebParam(name = "RegisteredBy") String RegisteredBy
    ) {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Update Patient set FirstName=? ,"
                    + " LastName=? ,MiddleName=? ,Gender=? ,Age=? ,RegisteredBy=?  where  patientID=?");

            ts.setString(1, FirstName);
            ts.setString(2, LastName);
            ts.setString(3, MiddleName);
            ts.setString(4, Gender);
            ts.setInt(5, Age);
            ts.setString(6, RegisteredBy);
            ts.setString(7, patientID);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

    @WebMethod(operationName = "viewPatient")
    public String viewPatient(@WebParam(name = "viewPatient") String patientID
    ) {
        Patient patient = new Patient();

        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.patient where hospital.patient.patientID='" + patientID + "';");

            while (rs.next()) {
                patient.setPatientID(rs.getString("patientID"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setMiddleName(rs.getString("MiddleName"));
                patient.setLastName(rs.getString("LastName"));
                patient.setGender(rs.getString("Gender"));
                patient.setAge(rs.getInt("Age"));
                patient.setActive(rs.getBoolean("Active"));
                patient.setRegisteredBy(rs.getString("RegisteredBy"));

            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        JaxbMarshaler jM = new JaxbMarshaler();
        return jM.objectToJsonString(patient);

    }

    @WebMethod(operationName = "disablePatient")
    public String disablePatient(@WebParam(name = "disablePatient") String patientID
    ) {
        String bool = "false";
        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            PreparedStatement ts = con.prepareStatement("Update patient set Active=false where  patientID=?");
            ts.setString(1, patientID);
            ts.executeUpdate();
            bool = "true";
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bool;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listAll")
    public String listAll() {
        ArrayList<Patient> list = new ArrayList<Patient>();

        try {
            Class.forName(this.driver);
            this.con = DriverManager.getConnection(this.url, this.userName, this.dbPassword);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from hospital.patient;");

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientID(rs.getString("patientID"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setMiddleName(rs.getString("MiddleName"));
                patient.setLastName(rs.getString("LastName"));
                patient.setGender(rs.getString("Gender"));
                patient.setAge(rs.getInt("Age"));
                patient.setActive(rs.getBoolean("Active"));
                patient.setRegisteredBy(rs.getString("RegisteredBy"));
                list.add(patient);

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
