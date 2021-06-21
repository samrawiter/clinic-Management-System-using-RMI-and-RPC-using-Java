
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

    private final static QName _DisableUser_QNAME = new QName("http://UserPackage/", "disableUser");
    private final static QName _UpdateUser_QNAME = new QName("http://UserPackage/", "updateUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://UserPackage/", "addUserResponse");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://UserPackage/", "updateUserResponse");
    private final static QName _DisableUserResponse_QNAME = new QName("http://UserPackage/", "disableUserResponse");
    private final static QName _ViewUserResponse_QNAME = new QName("http://UserPackage/", "viewUserResponse");
    private final static QName _ViewUser_QNAME = new QName("http://UserPackage/", "viewUser");
    private final static QName _AddUser_QNAME = new QName("http://UserPackage/", "addUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: userpackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DisableUserResponse }
     * 
     */
    public DisableUserResponse createDisableUserResponse() {
        return new DisableUserResponse();
    }

    /**
     * Create an instance of {@link ViewUserResponse }
     * 
     */
    public ViewUserResponse createViewUserResponse() {
        return new ViewUserResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link ViewUser }
     * 
     */
    public ViewUser createViewUser() {
        return new ViewUser();
    }

    /**
     * Create an instance of {@link DisableUser }
     * 
     */
    public DisableUser createDisableUser() {
        return new DisableUser();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisableUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "disableUser")
    public JAXBElement<DisableUser> createDisableUser(DisableUser value) {
        return new JAXBElement<DisableUser>(_DisableUser_QNAME, DisableUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisableUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "disableUserResponse")
    public JAXBElement<DisableUserResponse> createDisableUserResponse(DisableUserResponse value) {
        return new JAXBElement<DisableUserResponse>(_DisableUserResponse_QNAME, DisableUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "viewUserResponse")
    public JAXBElement<ViewUserResponse> createViewUserResponse(ViewUserResponse value) {
        return new JAXBElement<ViewUserResponse>(_ViewUserResponse_QNAME, ViewUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "viewUser")
    public JAXBElement<ViewUser> createViewUser(ViewUser value) {
        return new JAXBElement<ViewUser>(_ViewUser_QNAME, ViewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserPackage/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

}
