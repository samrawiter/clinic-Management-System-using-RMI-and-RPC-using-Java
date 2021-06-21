/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelPackage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {

    protected String patientID;
    protected String FirstName;
    protected String MiddleName;
    protected String LastName;
    protected String Gender;
    protected int Age;
    protected boolean Active;
    protected String RegisteredBy;

    public String getPatientID() {
        return patientID;
    }

    @XmlElement
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return FirstName;
    }

    @XmlElement
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    @XmlElement
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    @XmlElement
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    @XmlElement
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getAge() {
        return Age;
    }

    @XmlElement
    public void setAge(int Age) {
        this.Age = Age;
    }

    public boolean isActive() {
        return Active;
    }

    @XmlElement
    public void setActive(boolean Active) {
        this.Active = Active;
    }

    
    public String getRegisteredBy() {
        return RegisteredBy;
    }

    @XmlElement
    public void setRegisteredBy(String RegisteredBy) {
        this.RegisteredBy = RegisteredBy;
    }

}
