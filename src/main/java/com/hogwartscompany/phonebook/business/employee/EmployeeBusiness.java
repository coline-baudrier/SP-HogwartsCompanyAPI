package com.hogwartscompany.phonebook.business.employee;

import com.hogwartscompany.phonebook.controller.employee.model.Employee;
import com.hogwartscompany.phonebook.controller.employee.model.NewEmployee;
import com.hogwartscompany.phonebook.dao.employee.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeBusiness {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeBusiness(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    public Employee createEmployeeService (NewEmployee employee) {
        return employeeDAO.create(employee);
    }
    public boolean deleteEmployeeService (int id) {
        return employeeDAO.delete(id);
    }
    public Employee updateEmployeeService (int id, NewEmployee employee) {
        return employeeDAO.update(id, employee);
    }
    public Employee getOneEmployeeService (int id) {
        return employeeDAO.getOne(id);
    }
    public List<Employee> getAllEmployeeService() {
        return employeeDAO.getAll();
    }
    public List<Employee> searchEmployeeByNameService(String searchEmployee) {
        return employeeDAO.searchEmployeeByName(searchEmployee);
    }

    public List<Employee> getEmployeesByServiceService(int idService) {
        return employeeDAO.getEmployeesByService(idService);
    }
}
