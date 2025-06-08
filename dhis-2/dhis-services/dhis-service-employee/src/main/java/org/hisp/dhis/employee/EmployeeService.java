package org.hisp.dhis.employee;

import org.hisp.dhis.common.IdentifiableObjectStore;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    /**
     * Lấy tất cả Employee
     *
     * @return Danh sách Employee
     */
    @Transactional(readOnly = true)
    List<Employee> getAll();

    /**
     * Lấy Employee theo ID
     *
     * @param id ID của Employee
     * @return Employee hoặc null nếu không tìm thấy
     */
    @Transactional(readOnly = true)
    Employee get(long id);

    /**
     * Lưu Employee mới
     *
     * @param employee Employee cần lưu
     * @return ID của Employee vừa lưu
     */
    @Transactional
    long save(Employee employee);

    /**
     * Cập nhật Employee
     *
     * @param employee Employee cần cập nhật
     */
    @Transactional
    void update(Employee employee);

    /**
     * Xóa Employee
     *
     * @param employee Employee cần xóa
     */
    @Transactional
    void delete(Employee employee);
} 