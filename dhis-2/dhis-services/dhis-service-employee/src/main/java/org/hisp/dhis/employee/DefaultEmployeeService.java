package org.hisp.dhis.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
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
    @Transactional
    public long save(Employee employee) {
        employeeStore.save(employee);
        return employee.getId();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        employeeStore.update(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee) {
        employeeStore.delete(employee);
    }
} 