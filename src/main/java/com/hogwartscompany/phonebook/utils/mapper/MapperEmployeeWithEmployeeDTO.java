package com.hogwartscompany.phonebook.utils.mapper;

import com.hogwartscompany.phonebook.controller.employee.model.Employee;
import com.hogwartscompany.phonebook.controller.employee.model.NewEmployee;
import com.hogwartscompany.phonebook.dao.employee.model.EmployeeDTO;

public class MapperEmployeeWithEmployeeDTO {
    public EmployeeDTO EmployeeToDTO (Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setIdEmployee(employee.getIdEmployee());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setJobEmployee(employee.getJobEmployee());
        dto.setServiceEmployee(employee.getServiceEmployee());
        dto.setPhoneEmployee(employee.getPhoneEmployee());
        dto.setCellphoneEmployee(employee.getCellphoneEmployee());
        dto.setEmailEmployee(employee.getEmailEmployee());
        dto.setBirthDate(employee.getBirthDate());
        dto.setHiringDate(employee.getHiringDate());
        dto.setAdminApplication(employee.getAdminApplication());

        return dto;
    }

    public EmployeeDTO NewEmployeeToDTO (NewEmployee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setJobEmployee(employee.getJobEmployee());
        dto.setServiceEmployee(employee.getServiceEmployee());
        dto.setPhoneEmployee(employee.getPhoneEmployee());
        dto.setCellphoneEmployee(employee.getCellphoneEmployee());
        dto.setEmailEmployee(employee.getEmailEmployee());
        dto.setBirthDate(employee.getBirthDate());
        dto.setHiringDate(employee.getHiringDate());
        dto.setAdminApplication(employee.getAdminApplication());

        return dto;
    }

    public Employee DTOToEmployee (EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setIdEmployee(dto.getIdEmployee());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setJobEmployee(dto.getJobEmployee());
        employee.setServiceEmployee(dto.getServiceEmployee());
        employee.setPhoneEmployee(dto.getPhoneEmployee());
        employee.setCellphoneEmployee(dto.getCellphoneEmployee());
        employee.setEmailEmployee(dto.getEmailEmployee());
        employee.setBirthDate(dto.getBirthDate());
        employee.setHiringDate(dto.getHiringDate());
        employee.setAdminApplication(dto.getAdminApplication());

        return employee;
    }

}
