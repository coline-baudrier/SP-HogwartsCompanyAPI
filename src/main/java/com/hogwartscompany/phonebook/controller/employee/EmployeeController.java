package com.hogwartscompany.phonebook.controller.employee;

import com.hogwartscompany.phonebook.business.employee.EmployeeBusiness;
import com.hogwartscompany.phonebook.controller.employee.model.Employee;
import com.hogwartscompany.phonebook.controller.employee.model.NewEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class EmployeeController {
    private final String version = "/api/v1";
    private final EmployeeBusiness employeeBusiness;

    @Autowired
    public EmployeeController(EmployeeBusiness employeeBusiness) {
        this.employeeBusiness = employeeBusiness;
    }

    @PostMapping(version + "/employees")
    public Employee createEmployee(@RequestBody NewEmployee employee) {
        return employeeBusiness.createEmployeeService(employee);
    }
    @DeleteMapping(version + "/employees/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return employeeBusiness.deleteEmployeeService(id);
    }
    @PutMapping(version + "/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody NewEmployee employee) {
        return employeeBusiness.updateEmployeeService(id, employee);
    }
    @GetMapping(version + "/employees/{id}")
    public Employee getOneEmployee(@PathVariable int id) {
        return employeeBusiness.getOneEmployeeService(id);
    }
    @GetMapping(version + "/employees")
    public List<Employee> getAllEmployee() {
        return employeeBusiness.getAllEmployeeService();
    }
    @GetMapping(version + "/employees/searchEmployee")
    public List<Employee> searchEmployeeByName(@RequestParam String searchEmployee) {
        return employeeBusiness.searchEmployeeByNameService(searchEmployee);
    }

    @GetMapping(version + "/employees/searchByService/{idService}")
    public List<Employee> getEmployeesByService(@PathVariable int idService) {
        return employeeBusiness.getEmployeesByServiceService(idService);
    }
}
