package dhis.employee;

import jakarta.persistence.EntityManager;
import org.hisp.dhis.common.hibernate.HibernateIdentifiableObjectStore;
import org.hisp.dhis.security.acl.AclService;
import org.hisp.dhis.user.CurrentUserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of EmployeeStore
 */
@Repository("org.hisp.dhis.employee.EmployeeStore")
public class HibernateEmployeeStore extends HibernateIdentifiableObjectStore<Employee> implements EmployeeStore {

    public HibernateEmployeeStore(
            EntityManager entityManager,
            JdbcTemplate jdbcTemplate,
            ApplicationEventPublisher publisher,
            CurrentUserService currentUserService,
            AclService aclService) {
        super(entityManager, jdbcTemplate, publisher, Employee.class, currentUserService, aclService, true);
    }
}