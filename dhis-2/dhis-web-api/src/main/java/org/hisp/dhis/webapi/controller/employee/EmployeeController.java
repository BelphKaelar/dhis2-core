package org.hisp.dhis.webapi.controller.employee;

import org.hisp.dhis.common.DhisApiVersion;
import org.hisp.dhis.common.OpenApi;
import org.hisp.dhis.dxf2.webmessage.WebMessageException;
import org.hisp.dhis.dxf2.webmessage.WebMessageUtils;
import org.hisp.dhis.employee.Employee;
import org.hisp.dhis.employee.EmployeeService;
import org.hisp.dhis.security.RequiresAuthority;
import org.hisp.dhis.webapi.mvc.annotation.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.hisp.dhis.security.Authorities.ALL;

@OpenApi.Document(
    entity = Employee.class,
    classifiers = {"team:platform", "purpose:metadata"})
@RestController
@RequestMapping(value = EmployeeController.RESOURCE_PATH)
@ApiVersion({DhisApiVersion.DEFAULT, DhisApiVersion.ALL})
public class EmployeeController {
    public static final String RESOURCE_PATH = "/employees";

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @RequiresAuthority(anyOf = ALL)
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @RequiresAuthority(anyOf = ALL)
    public Employee getEmployee(@PathVariable long id) throws WebMessageException {
        Employee employee = employeeService.get(id);
        if (employee == null) {
            throw new WebMessageException(WebMessageUtils.notFound("Employee not found with id: " + id));
        }
        return employee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequiresAuthority(anyOf = ALL)
    public void createEmployee(@RequestBody Employee employee, HttpServletResponse response) {
        long id = employeeService.save(employee);
        response.setHeader("Location", RESOURCE_PATH + "/" + id);
    }

    @PutMapping("/{id}")
    @RequiresAuthority(anyOf = ALL)
    public void updateEmployee(@PathVariable long id, @RequestBody Employee employee) throws WebMessageException {
        Employee existingEmployee = employeeService.get(id);
        if (existingEmployee == null) {
            throw new WebMessageException(WebMessageUtils.notFound("Employee not found with id: " + id));
        }

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setName(employee.getFirstName() + " " + employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setPosition(employee.getPosition());

        employeeService.update(existingEmployee);
    }

    @DeleteMapping("/{id}")
    @RequiresAuthority(anyOf = ALL)
    public void deleteEmployee(@PathVariable long id) throws WebMessageException {
        Employee employee = employeeService.get(id);
        if (employee == null) {
            throw new WebMessageException(WebMessageUtils.notFound("Employee not found with id: " + id));
        }
        employeeService.delete(employee);
    }

    @GetMapping("/test")
    @RequiresAuthority(anyOf = ALL)
    public String test() {
        return "Employee controller is working!";
    }

    @PostConstruct
    public void init() {
        System.out.println("==== EMPLOYEE CONTROLLER LOADED ====");
    }
} 