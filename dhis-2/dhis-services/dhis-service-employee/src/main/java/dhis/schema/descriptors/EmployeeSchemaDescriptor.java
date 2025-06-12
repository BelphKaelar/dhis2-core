package dhis.schema.descriptors;

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

    @Override
    public Schema getSchema() {
        Schema schema = new Schema(Employee.class, SINGULAR, PLURAL);
        schema.setRelativeApiEndpoint(API_ENDPOINT);
        schema.setOrder(1500);

        schema.getAuthorities().add(new Authority(AuthorityType.CREATE, Arrays.asList("ALL")));
        schema.getAuthorities().add(new Authority(AuthorityType.DELETE, Arrays.asList("ALL")));
        schema.getAuthorities().add(new Authority(AuthorityType.UPDATE, Arrays.asList("ALL")));
        schema.getAuthorities().add(new Authority(AuthorityType.READ, Arrays.asList("ALL")));

        return schema;
    }
}