
package userpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for viewUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="viewUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="viewUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viewUser", propOrder = {
    "viewUser"
})
public class ViewUser {

    protected String viewUser;

    /**
     * Gets the value of the viewUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewUser() {
        return viewUser;
    }

    /**
     * Sets the value of the viewUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewUser(String value) {
        this.viewUser = value;
    }

}
