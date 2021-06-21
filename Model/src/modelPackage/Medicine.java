/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelPackage;

import java.sql.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Medicine {

    protected String Name;
    protected String ManufacturedCountry;
    protected Date ManufacturedDate;

    public String getName() {
        return Name;
    }

    @XmlElement
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getManufacturedCountry() {
        return ManufacturedCountry;
    }

    @XmlElement
    public void setManufacturedCountry(String ManufacturedCountry) {
        this.ManufacturedCountry = ManufacturedCountry;
    }

    public Date getManufacturedDate() {
        return ManufacturedDate;
    }

    @XmlElement
    public void setManufacturedDate(Date ManufacturedDate) {
        this.ManufacturedDate = ManufacturedDate;
    }

}
