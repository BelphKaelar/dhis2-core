package org.hisp.dhis.webapi.controller.employee;

import org.hisp.dhis.common.DhisApiVersion;
import org.hisp.dhis.common.OpenApi;
import org.hisp.dhis.employee.Employee;
import org.hisp.dhis.employee.EmployeeService;
import org.hisp.dhis.webapi.controller.AbstractCrudController;
import org.hisp.dhis.webapi.mvc.annotation.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// manual wasn't working, might switch back
@OpenApi.Document(
        entity = Employee.class,
        classifiers = {"team:platform", "purpose:metadata"})
@RestController
@RequestMapping(value = "/employees")
@ApiVersion({DhisApiVersion.DEFAULT, DhisApiVersion.ALL})
public class EmployeeController extends AbstractCrudController<Employee, EmployeeService> {

}