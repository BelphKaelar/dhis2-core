package dhis.employee;

import lombok.RequiredArgsConstructor;
import org.hisp.dhis.common.CodeGenerator;
import org.hisp.dhis.common.DeleteNotAllowedException;
import org.hisp.dhis.user.UserDetails;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Default implementation of EmployeeService
 */
@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class DefaultEmployeeService implements EmployeeService {
    private final EmployeeStore employeeStore;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeStore.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee get(long id) {
        return employeeStore.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getByUid(String uid) {
        return employeeStore.getByUid(uid);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getByCode(String code) {
        return employeeStore.getByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getByName(String name) {
        return employeeStore.getByName(name);
    }

    @Override
    public void save(Employee employee) {
        save(employee, true);
    }

    @Override
    public void save(@Nonnull Employee employee, boolean clearSharing) {
        if (employee.getUid() == null || employee.getUid().isEmpty()) {
            employee.setUid(CodeGenerator.generateUid());
        }

        if (employee.getName() == null || employee.getName().isEmpty()) {
            if (employee.getFirstName() != null && employee.getLastName() != null) {
                employee.setName(employee.getFirstName() + " " + employee.getLastName());
            }
        }

        employeeStore.save(employee, clearSharing);
    }

    @Override
    public void save(Employee employee, UserDetails userDetails, boolean clearSharing) {
        if (employee.getUid() == null || employee.getUid().isEmpty()) {
            employee.setUid(CodeGenerator.generateUid());
        }

        if (employee.getName() == null || employee.getName().isEmpty()) {
            if (employee.getFirstName() != null && employee.getLastName() != null) {
                employee.setName(employee.getFirstName() + " " + employee.getLastName());
            }
        }

        employeeStore.save(employee, userDetails, clearSharing);
    }

    @Override
    public void update(Employee employee) {
        employeeStore.update(employee);
    }

    @Override
    public void delete(Employee employee) throws DeleteNotAllowedException {
        employeeStore.delete(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public int getCount() {
        return employeeStore.getCount();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllOrderedName() {
        return employeeStore.getAllOrderedName();
    }
}