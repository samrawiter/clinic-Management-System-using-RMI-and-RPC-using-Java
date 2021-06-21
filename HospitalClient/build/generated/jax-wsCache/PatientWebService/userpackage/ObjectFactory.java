
package userpackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the userpackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DisablePatient_QNAME = new QName("http://UserPackage/", "disablePatient");
    private final static QName _ListAll_QNAME = new QName("http://UserPackage/", "listAll");
    private final static QName _AddPatientResponse_QNAME = new QName("http://UserPackage/", "addPatientResponse");
    private final static QName _UpdatePatientResponse_QNAME = new QName("http://UserPackage/", "updatePatientResponse");
    private final static QName _ViewPatient_QNAME = new QName("http://UserPackage/", "viewPatient");
    private final static QName _DisablePatientResponse_QNAME = new QName("http://UserPackage/", "disablePatientResponse");
    private final static QName _AddPatient_QNAME = new QName("http://UserPackage/", "addPatient");
    private final static QName _UpdatePatient_QNAME = new QName("http://UserPackage/", "updatePatient");
    private final static QName _ViewPatientResponse_QNAME = new QName("http://UserPackage/", "viewPatientResponse");
    private final static QName _ListAllResponse_QNAME = new QName("http://UserPackage/", "listAllResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: userpackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ViewPatient }
     * 
     */
    public ViewPatient createViewPatient() {
        return new ViewPatient();
    }

    /**
     * Create an instance of {@link DisablePatientResponse }
     * 
     */
    public DisablePatientResponse createDisablePatientResponse() {
        return new DisablePatientResponse();
    }

    /**
     * Create an instance of {@link ListAllResponse }
     * 
     */
    public ListAllResponse createListAllResponse() {
        return new ListAllResponse();
    }

    /**
     * Create an instance of {@link AddPatient }
     * 
     */
    public AddPatient createAddPatient() {
        return new AddPatient();
    }

    /**
     * Create an instance of {@link UpdatePatient }
     * 
     */
    public UpdatePatient createUpdatePatient() {
        return new UpdatePatient();
    }

    /**
     * Create an instance of {@link ViewPatientResponse }
     * 
     */
    public ViewPatientResponse createViewPatientResponse() {
        return new ViewPatientResponse();
    }

    /**
     * Create an instance of {@link DisablePatient }
     * 
     */
    public DisablePatient createDisablePatient() {
        return new DisablePatient();
    }

    /**
     * Create an instance of {@link AddPatientResponse }
     * 
     */
    public AddPatientResponse createAddPatientResponse() {
        return new AddPatientResponse();
    }

    /**
     * Create an instance of {@link ListAll }
     * 
     */
    public ListAll createListAll() {
        return new ListAll();
    }

    /**
     * Create an instance of {@link UpdatePatientResponse }
     * 
     */
    public UpdatePatientResponse createUpdatePatientResponse() {
        return new UpdatePatientResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisablePatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "disablePatient")
    public JAXBElement<DisablePatient> createDisablePatient(DisablePatient value) {
        return new JAXBElement<DisablePatient>(_DisablePatient_QNAME, DisablePatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "listAll")
    public JAXBElement<ListAll> createListAll(ListAll value) {
        return new JAXBElement<ListAll>(_ListAll_QNAME, ListAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "addPatientResponse")
    public JAXBElement<AddPatientResponse> createAddPatientResponse(AddPatientResponse value) {
        return new JAXBElement<AddPatientResponse>(_AddPatientResponse_QNAME, AddPatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "updatePatientResponse")
    public JAXBElement<UpdatePatientResponse> createUpdatePatientResponse(UpdatePatientResponse value) {
        return new JAXBElement<UpdatePatientResponse>(_UpdatePatientResponse_QNAME, UpdatePatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "viewPatient")
    public JAXBElement<ViewPatient> createViewPatient(ViewPatient value) {
        return new JAXBElement<ViewPatient>(_ViewPatient_QNAME, ViewPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisablePatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "disablePatientResponse")
    public JAXBElement<DisablePatientResponse> createDisablePatientResponse(DisablePatientResponse value) {
        return new JAXBElement<DisablePatientResponse>(_DisablePatientResponse_QNAME, DisablePatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "addPatient")
    public JAXBElement<AddPatient> createAddPatient(AddPatient value) {
        return new JAXBElement<AddPatient>(_AddPatient_QNAME, AddPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "updatePatient")
    public JAXBElement<UpdatePatient> createUpdatePatient(UpdatePatient value) {
        return new JAXBElement<UpdatePatient>(_UpdatePatient_QNAME, UpdatePatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewPatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "viewPatientResponse")
    public JAXBElement<ViewPatientResponse> createViewPatientResponse(ViewPatientResponse value) {
        return new JAXBElement<ViewPatientResponse>(_ViewPatientResponse_QNAME, ViewPatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "listAllResponse")
    public JAXBElement<ListAllResponse> createListAllResponse(ListAllResponse value) {
        return new JAXBElement<ListAllResponse>(_ListAllResponse_QNAME, ListAllResponse.class, null, value);
    }

}
