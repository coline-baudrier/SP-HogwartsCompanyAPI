package com.hogwartscompany.phonebook.dao.employee;

import com.hogwartscompany.phonebook.controller.employee.model.Employee;
import com.hogwartscompany.phonebook.controller.employee.model.NewEmployee;
import com.hogwartscompany.phonebook.dao.employee.model.EmployeeDTO;
import com.hogwartscompany.phonebook.utils.mapper.MapperEmployeeWithEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {
    private static final String ID_FIELD = "id_employee";
    private static final String FIRSTNAME_FIELD = "first_name";
    private static final String LASTNAME_FIELD = "last_name";
    private static final String JOBEMPLOYEE_FIELD = "job";
    private static final String SERVICEEMPLOYEE_FIELD = "service_employee";
    private static final String PHONEEMPLOYEE_FIELD = "phone_employee";
    private static final String CELLPHONEEMPLOYEE_FIELD = "cellphone_employee";
    private static final String EMAILEMPLOYEE_FIELD = "email_employee";
    private static final String BIRTHDATE_FIELD = "birthdate";
    private static final String HIRINGDATE_FIELD = "hiring_date";
    private static final String ADMINAPPLICATION_FIELD = "admin_application";

    private final JdbcTemplate jdbcTemplate;
    private final MapperEmployeeWithEmployeeDTO mapperEmployeeWithEmployeeDTO;

    @Autowired
    public EmployeeDAO(DataSource dataSource, MapperEmployeeWithEmployeeDTO mapperEmployeeWithEmployeeDTO) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapperEmployeeWithEmployeeDTO = mapperEmployeeWithEmployeeDTO;
    }

    private final RowMapper<EmployeeDTO> rowMapper = (rs, rowNum) -> {
        final EmployeeDTO employee = new EmployeeDTO();
        employee.setIdEmployee(rs.getInt(ID_FIELD));
        employee.setFirstName(rs.getString(FIRSTNAME_FIELD));
        employee.setLastName(rs.getString(LASTNAME_FIELD));
        employee.setJobEmployee(rs.getString(JOBEMPLOYEE_FIELD));
        employee.setServiceEmployee(rs.getInt(SERVICEEMPLOYEE_FIELD));
        employee.setPhoneEmployee(rs.getString(PHONEEMPLOYEE_FIELD));
        employee.setCellphoneEmployee(rs.getString(CELLPHONEEMPLOYEE_FIELD));
        employee.setEmailEmployee(rs.getString(EMAILEMPLOYEE_FIELD));
        employee.setBirthDate(rs.getTimestamp(BIRTHDATE_FIELD));
        employee.setHiringDate(rs.getTimestamp(HIRINGDATE_FIELD));
        employee.setAdminApplication(rs.getBoolean(ADMINAPPLICATION_FIELD));

        return employee;
    };

    public Employee getOne (int id) {
        Employee employee = null;
        String sqlQuery = "SELECT * FROM employee WHERE id_employee = " + id;

        List<EmployeeDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() == 1) {
            employee = mapperEmployeeWithEmployeeDTO.DTOToEmployee(dtos.get(0));
        }

        return employee;
    }

    public List<Employee> getAll () {
        List<Employee> listEmployee = null;
        Employee resp = null;

        String sqlQuery = "SELECT * FROM employee";

        List<EmployeeDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listEmployee = new ArrayList<Employee>();

            for (EmployeeDTO dto : dtos) {
                resp = mapperEmployeeWithEmployeeDTO.DTOToEmployee(dto);
                listEmployee.add(resp);
            }
        }
        return listEmployee;
    }

    public List<Employee> getEmployeesByService (int idService) {
        List<Employee> listEmployee = null;
        Employee resp = null;

        String sqlQuery = "SELECT * FROM employee WHERE service_employee = " + idService;

        List<EmployeeDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listEmployee = new ArrayList<Employee>();

            for (EmployeeDTO dto : dtos) {
                resp = mapperEmployeeWithEmployeeDTO.DTOToEmployee(dto);
                listEmployee.add(resp);
            }
        }
        return listEmployee;
    }

    public Employee create(NewEmployee employee) {
        EmployeeDTO employee1 = null;
        Employee employee2 = null;

        final String sqlQuery = "INSERT INTO employee (first_name, last_name, job, service_employee, phone_employee, cellphone_employee, email_employee, birthdate, hiring_date, admin_application) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int resultCreation = this.jdbcTemplate.update(
                sqlQuery,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobEmployee(),
                employee.getServiceEmployee(),
                employee.getPhoneEmployee(),
                employee.getCellphoneEmployee(),
                employee.getEmailEmployee(),
                employee.getBirthDate(),
                employee.getHiringDate(),
                employee.getAdminApplication()
        );

        if (resultCreation == 1) {
            employee1 = mapperEmployeeWithEmployeeDTO.NewEmployeeToDTO(employee);
            employee2 = mapperEmployeeWithEmployeeDTO.DTOToEmployee(employee1);
        }
        return employee2;
    }

    public Employee update(int id, NewEmployee employee) {
        EmployeeDTO employee1 = null;
        Employee employee2 = null;

        final String sqlQuery = "UPDATE employee SET first_name = ?, last_name = ?, job = ?, service_employee = ?, phone_employee = ?, cellphone_employee = ?, email_employee = ?, birthdate = ?, hiring_date = ?, admin_application = ? WHERE id_employee = ?";
        int resultUpdate = this.jdbcTemplate.update(
                sqlQuery,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobEmployee(),
                employee.getServiceEmployee(),
                employee.getPhoneEmployee(),
                employee.getCellphoneEmployee(),
                employee.getEmailEmployee(),
                employee.getBirthDate(),
                employee.getHiringDate(),
                employee.getAdminApplication(),
                id
        );

        if (resultUpdate == 1) {
            employee1 = mapperEmployeeWithEmployeeDTO.NewEmployeeToDTO(employee);
            employee2 = mapperEmployeeWithEmployeeDTO.DTOToEmployee(employee1);
        }
        return employee2;
    }

    public boolean delete(int id) {
        final String sqlQuery = "DELETE FROM employee WHERE id_employee = ?";
        int resultDelete = this.jdbcTemplate.update(
                sqlQuery,
                id
        );

        if (resultDelete == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Employee> searchEmployeeByName (String searchEmployee) {
        List<Employee> listEmployee = null;
        Employee resp = null;

        String sqlQuery = "SELECT * FROM employee WHERE last_name LIKE ? OR first_name LIKE ?";

        List<EmployeeDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                new Object[]{"%" + searchEmployee + "%", "%" + searchEmployee + "%"},
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listEmployee = new ArrayList<Employee>();

            for (EmployeeDTO dto : dtos) {
                resp = mapperEmployeeWithEmployeeDTO.DTOToEmployee(dto);
                listEmployee.add(resp);
            }
        }
        return listEmployee;
    }
}
