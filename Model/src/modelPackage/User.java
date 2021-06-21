package modelPackage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    protected String userID;
    protected String Password;
    protected String FirstName;
    protected String LastName;
    protected String MiddleName;
    protected String Email;
    protected String Responsibility;
    protected String Gender;
    protected int Age;
    protected boolean Active;

    public String getUserID() {
        return userID;
    }

    @XmlElement
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return Password;
    }

    @XmlElement
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    @XmlElement
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    @XmlElement
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    @XmlElement
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getEmail() {
        return Email;
    }

    @XmlElement
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getResponsibility() {
        return Responsibility;
    }

    @XmlElement
    public void setResponsibility(String Responsibility) {
        this.Responsibility = Responsibility;
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

}
