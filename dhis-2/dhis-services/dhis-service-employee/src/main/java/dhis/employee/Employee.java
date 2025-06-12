package dhis.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.hisp.dhis.common.BaseIdentifiableObject;
import org.hisp.dhis.common.DxfNamespaces;
import org.hisp.dhis.common.MetadataObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends BaseIdentifiableObject implements MetadataObject {

    @Column(name = "employee_number", unique = true)
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String employeeNumber;

    @Column(name = "firstname")
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String firstName;

    @Column(name = "lastname")
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String lastName;

    @Column(name = "email")
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String email;

    @Column(name = "phonenumber")
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String phoneNumber;

    @Column(name = "department")
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String department;

    @Column(name = "position")
    @JsonProperty
    @JacksonXmlProperty(namespace = DxfNamespaces.DXF_2_0)
    private String position;

    public Employee() {
        super();
    }

    // Auto-update name when firstName/lastName change
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateName();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateName();
    }

    private void updateName() {
        if (firstName != null && lastName != null) {
            setName(firstName + " " + lastName);
        }
    }

    // Standard getters/setters for the rest
    public String getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}