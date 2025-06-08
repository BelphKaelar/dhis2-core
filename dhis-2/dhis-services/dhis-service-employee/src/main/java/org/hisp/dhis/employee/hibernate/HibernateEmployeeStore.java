package org.hisp.dhis.employee.hibernate;

import jakarta.persistence.EntityManager;
import org.hisp.dhis.common.hibernate.HibernateIdentifiableObjectStore;
import org.hisp.dhis.employee.Employee;
import org.hisp.dhis.employee.EmployeeStore;
import org.hisp.dhis.security.acl.AclService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("org.hisp.dhis.employee.EmployeeStore")
public class HibernateEmployeeStore extends HibernateIdentifiableObjectStore<Employee> implements EmployeeStore {
    public HibernateEmployeeStore(
            EntityManager entityManager,
            JdbcTemplate jdbcTemplate,
            ApplicationEventPublisher publisher,
            AclService aclService) {
        super(entityManager, jdbcTemplate, publisher, Employee.class, aclService, true);
    }
} 