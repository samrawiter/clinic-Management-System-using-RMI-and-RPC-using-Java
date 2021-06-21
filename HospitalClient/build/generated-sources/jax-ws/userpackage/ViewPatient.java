
package userpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for viewPatient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="viewPatient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="viewPatient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viewPatient", propOrder = {
    "viewPatient"
})
public class ViewPatient {

    protected String viewPatient;

    /**
     * Gets the value of the viewPatient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewPatient() {
        return viewPatient;
    }

    /**
     * Sets the value of the viewPatient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewPatient(String value) {
        this.viewPatient = value;
    }

}
