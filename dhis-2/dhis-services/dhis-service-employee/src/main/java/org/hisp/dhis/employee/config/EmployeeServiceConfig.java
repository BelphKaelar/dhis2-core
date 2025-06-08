package org.hisp.dhis.employee.config;

import org.hisp.dhis.schema.descriptors.EmployeeSchemaDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.hisp.dhis.employee")
public class EmployeeServiceConfig {
    @Bean
    public EmployeeSchemaDescriptor employeeSchemaDescriptor() {
        return new EmployeeSchemaDescriptor();
    }
}