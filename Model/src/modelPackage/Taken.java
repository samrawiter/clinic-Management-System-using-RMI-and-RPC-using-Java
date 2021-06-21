package modelPackage;

import java.sql.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Taken {

    protected String MedicineName;
    protected String patientID;
    protected Date StartDate;
    protected Date EndDate;

    public String getMedicineName() {
        return MedicineName;
    }

    @XmlElement
    public void setMedicineName(String MedicineName) {
        this.MedicineName = MedicineName;
    }

    public String getPatientID() {
        return patientID;
    }

    @XmlElement
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    @XmlElement
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    @XmlElement
    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

}
