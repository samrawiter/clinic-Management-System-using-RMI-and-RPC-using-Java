
package userpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for disablePatient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="disablePatient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disablePatient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "disablePatient", propOrder = {
    "disablePatient"
})
public class DisablePatient {

    protected String disablePatient;

    /**
     * Gets the value of the disablePatient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisablePatient() {
        return disablePatient;
    }

    /**
     * Sets the value of the disablePatient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisablePatient(String value) {
        this.disablePatient = value;
    }

}
