package org.hisp.dhis.schema.descriptors;

import org.hisp.dhis.employee.Employee;
import org.hisp.dhis.schema.Schema;
import org.hisp.dhis.schema.SchemaDescriptor;
import org.hisp.dhis.security.Authority;
import org.hisp.dhis.security.AuthorityType;

import java.util.Arrays;

public class EmployeeSchemaDescriptor implements SchemaDescriptor {
    public static final String SINGULAR = "employee";
    public static final String PLURAL = "employees";
    public static final String API_ENDPOINT = "/" + PLURAL;

    ///  ???
    @Override
    public Schema getSchema() {
        Schema schema = new Schema(Employee.class, SINGULAR, PLURAL);
        schema.setRelativeApiEndpoint(API_ENDPOINT);
        schema.setOrder(1500);

        schema.getAuthorities().add(new Authority(AuthorityType.CREATE, Arrays.asList("F_EMPLOYEE_ADD")));
        schema.getAuthorities().add(new Authority(AuthorityType.DELETE, Arrays.asList("F_EMPLOYEE_DELETE")));
        schema.getAuthorities().add(new Authority(AuthorityType.UPDATE, Arrays.asList("F_EMPLOYEE_UPDATE")));
        schema.getAuthorities().add(new Authority(AuthorityType.READ, Arrays.asList("F_EMPLOYEE_VIEW", "F_EMPLOYEE_LIST")));

        return schema;
    }
} 