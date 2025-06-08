package org.hisp.dhis.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hisp.dhis.common.BaseIdentifiableObject;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends BaseIdentifiableObject {
    private Long employeeId;
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    private String position;
}