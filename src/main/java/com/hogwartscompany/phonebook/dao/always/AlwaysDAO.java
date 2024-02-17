package com.hogwartscompany.phonebook.dao.always;

import com.hogwartscompany.phonebook.controller.always.model.Always;
import com.hogwartscompany.phonebook.controller.employee.model.Employee;
import com.hogwartscompany.phonebook.dao.address.model.AddressDTO;
import com.hogwartscompany.phonebook.dao.always.model.AlwaysDTO;
import com.hogwartscompany.phonebook.dao.employee.model.EmployeeDTO;
import com.hogwartscompany.phonebook.dao.service.model.ServiceSiteDTO;
import com.hogwartscompany.phonebook.dao.worksite.model.WorksiteDTO;
import com.hogwartscompany.phonebook.utils.mapper.MapperAlwaysWithAlwaysDTO;
import com.hogwartscompany.phonebook.utils.mapper.MapperEmployeeWithEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlwaysDAO {

    private final JdbcTemplate jdbcTemplate;
    private final MapperAlwaysWithAlwaysDTO mapperAlwaysWithAlwaysDTO;

    @Autowired
    public AlwaysDAO(DataSource dataSource, MapperAlwaysWithAlwaysDTO mapperAlwaysWithAlwaysDTO) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapperAlwaysWithAlwaysDTO = mapperAlwaysWithAlwaysDTO;
    }

    private final RowMapper<AlwaysDTO> rowMapper = (rs, rowNum) -> {
        final AlwaysDTO always = new AlwaysDTO();

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setIdEmployee(rs.getInt("employee.id_employee"));
        employeeDTO.setFirstName(rs.getString("employee.first_name"));
        employeeDTO.setLastName(rs.getString("employee.last_name"));
        employeeDTO.setJobEmployee(rs.getString("employee.job"));
        employeeDTO.setServiceEmployee(rs.getInt("employee.service_employee"));
        employeeDTO.setPhoneEmployee(rs.getString("employee.phone_employee"));
        employeeDTO.setCellphoneEmployee(rs.getString("employee.cellphone_employee"));
        employeeDTO.setEmailEmployee(rs.getString("employee.email_employee"));
        employeeDTO.setBirthDate(rs.getTimestamp("employee.birthdate"));
        employeeDTO.setHiringDate(rs.getTimestamp("employee.hiring_date"));
        employeeDTO.setAdminApplication(rs.getBoolean("employee.admin_application"));

        WorksiteDTO worksiteDTO = new WorksiteDTO();
        worksiteDTO.setIdWorksite(rs.getInt("worksite.id_worksite"));
        worksiteDTO.setNameWorksite(rs.getString("worksite.name_worksite"));
        worksiteDTO.setTypeWorksite(rs.getString("worksite.type_worksite"));
        worksiteDTO.setPhoneWorksite(rs.getString("worksite.phone_worksite"));
        worksiteDTO.setEmailWorksite(rs.getString("worksite.email_worksite"));
        worksiteDTO.setIdAddress(rs.getInt("worksite.address_worksite"));

        ServiceSiteDTO serviceDTO = new ServiceSiteDTO();
        serviceDTO.setIdService(rs.getInt("service.id_service"));
        serviceDTO.setNameService(rs.getString("service.name_service"));
        serviceDTO.setTypeService(rs.getString("service.type_service"));
        serviceDTO.setPhoneService(rs.getString("service.phone_service"));
        serviceDTO.setEmailService(rs.getString("service.email_service"));
        serviceDTO.setDateCreationService(rs.getTimestamp("service.date_of_creation"));
        serviceDTO.setIdAddress(rs.getInt("service.address_service"));
        serviceDTO.setIdWorksite(rs.getInt("service.worksite_of_service"));


        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setIdAddress(rs.getInt("address.id_address"));
        addressDTO.setBuildingFloor(rs.getString("address.building_floor"));
        addressDTO.setBuildingName(rs.getString("address.building"));
        addressDTO.setLineAddress1(rs.getString("address.address_line_1"));
        addressDTO.setLineAddress2(rs.getString("address.address_line_2"));
        addressDTO.setDepartmentCode(rs.getString("address.department"));
        addressDTO.setCityName(rs.getString("address.city"));

        always.setEmployeeDTO(employeeDTO);
        always.setServiceSiteDTO(serviceDTO);
        always.setWorksiteDTO(worksiteDTO);
        always.setAddressDTO(addressDTO);

        return always;
    };

    //Informations des employés

    //Information sur un employé

    //Informations des services

    //Information sur un service

    //Informations des sites

    //Informations sur un site

    //Recherche totale

    public List<Always> getAll() {
        List<Always> listAlways = null;
        Always resp = null;

        String sqlQuery = "SELECT * FROM employee e JOIN service s ON e.service_employee = s.id_service JOIN worksite w ON s.worksite_of_service = w.id_worksite JOIN address a ON w.address_worksite = a.id_address WHERE e.id_employee = 37";

        List<AlwaysDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listAlways = new ArrayList<Always>();

            for (AlwaysDTO dto : dtos) {
                resp = mapperAlwaysWithAlwaysDTO.DTOToAlways(dto);
                listAlways.add(resp);
            }
        }
        return listAlways;
    }

}
