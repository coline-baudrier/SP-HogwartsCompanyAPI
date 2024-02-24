package com.hogwartscompany.phonebook.dao.service;

import com.hogwartscompany.phonebook.dao.service.model.ServiceSiteDTO;
import com.hogwartscompany.phonebook.controller.service.model.NewServiceSite;
import com.hogwartscompany.phonebook.controller.service.model.ServiceSite;
import com.hogwartscompany.phonebook.utils.mapper.MapperServiceWithServiceSiteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceSiteDAO {
    private static final String ID_FIELD = "id_service";
    private static final String NAMESERVICE_FIELD = "name_service";
    private static final String TYPESERVICE_FIELD = "type_service";
    private static final String PHONESERVICE_FIELD = "phone_service";
    private static final String EMAILSERVICE_FIELD = "email_service";
    private static final String DATEOFCREATION_FIELD = "date_of_creation";
    private static final String ADDRESSSERVICE_FIELD = "address_service";
    private static final String WORKSITEOFSERVICE_FIELD = "worksite_of_service";

    private final JdbcTemplate jdbcTemplate;
    private final MapperServiceWithServiceSiteDTO mapperServiceWithServiceDTO;

    @Autowired
    public ServiceSiteDAO(DataSource dataSource, MapperServiceWithServiceSiteDTO mapperServiceWithServiceDTO) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapperServiceWithServiceDTO = mapperServiceWithServiceDTO;
    }

    private final RowMapper<ServiceSiteDTO> rowMapper = (rs, rowNum) -> {
        final ServiceSiteDTO service = new ServiceSiteDTO();
        service.setIdService(rs.getInt(ID_FIELD));
        service.setNameService(rs.getString(NAMESERVICE_FIELD));
        service.setTypeService(rs.getString(TYPESERVICE_FIELD));
        service.setPhoneService(rs.getString(PHONESERVICE_FIELD));
        service.setEmailService(rs.getString(EMAILSERVICE_FIELD));
        service.setDateCreationService(rs.getTimestamp(DATEOFCREATION_FIELD));
        service.setIdAddress(rs.getInt(ADDRESSSERVICE_FIELD));
        service.setIdWorksite(rs.getInt(WORKSITEOFSERVICE_FIELD));

        return service;
    };

    public ServiceSite getOne (int id) {
        ServiceSite service = null;
        String sqlQuery = "SELECT * FROM service WHERE id_service = " + id;

        List<ServiceSiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() == 1) {
            service = mapperServiceWithServiceDTO.DTOToService(dtos.get(0));
        }
        return service;
    }


    public List<ServiceSite> getAll () {
        List<ServiceSite> listService = null;
        ServiceSite resp = null;

        String sqlQuery = "SELECT * FROM service";

        List<ServiceSiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listService = new ArrayList<ServiceSite>();

            for (ServiceSiteDTO dto : dtos) {
                resp = mapperServiceWithServiceDTO.DTOToService(dto);
                listService.add(resp);
            }
        }
        return listService;
    }

    public List<ServiceSite> getServicesByWorksite (int idWorksite) {
        List<ServiceSite> listService = null;
        ServiceSite resp = null;

        String sqlQuery = "SELECT * FROM service WHERE worksite_of_service = " + idWorksite;

        List<ServiceSiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listService = new ArrayList<ServiceSite>();

            for (ServiceSiteDTO dto : dtos) {
                resp = mapperServiceWithServiceDTO.DTOToService(dto);
                listService.add(resp);
            }
        }
        return listService;
    }

    public ServiceSite create(NewServiceSite service){
        ServiceSiteDTO service1 = null;
        ServiceSite service2 = null;

        final String sqlQuery = "INSERT INTO service (name_service, type_service, phone_service, email_service, date_of_creation, address_service, worksite_of_service) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int resultCreation = this.jdbcTemplate.update(
                sqlQuery,
                service.getNameService(),
                service.getTypeService(),
                service.getPhoneService(),
                service.getEmailService(),
                service.getDateCreationService(),
                service.getIdAddress(),
                service.getIdWorksite()
        );

        if (resultCreation == 1) {
            service1 = mapperServiceWithServiceDTO.NewServiceDTO(service);
            service2 = mapperServiceWithServiceDTO.DTOToService(service1);
        }
        return service2;
    }

    public ServiceSite update(int id, NewServiceSite service){
        ServiceSiteDTO service1 = null;
        ServiceSite service2 = null;

        final String sqlQuery = "UPDATE service SET name_service = ?, type_service = ?, phone_service = ?, email_service = ?, date_of_creation = ?, address_service = ?, worksite_of_service = ? WHERE id_service = ?";
        int resultUpdate = this.jdbcTemplate.update(
                sqlQuery,
                service.getNameService(),
                service.getTypeService(),
                service.getPhoneService(),
                service.getEmailService(),
                service.getDateCreationService(),
                service.getIdAddress(),
                service.getIdWorksite(),
                id
        );

        if (resultUpdate == 1) {
            service1 = mapperServiceWithServiceDTO.NewServiceDTO(service);
            service2 = mapperServiceWithServiceDTO.DTOToService(service1);
        }
        return service2;
    }

    public boolean delete(int id) {
        final String sqlQuery = "DELETE FROM service WHERE id_service = ?";
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

    public List<ServiceSite> searchServiceSiteByName (String searchServiceSite) {
        List<ServiceSite> listService = null;
        ServiceSite resp = null;

        String sqlQuery = "SELECT * FROM service WHERE name_service LIKE ?" ;

        List<ServiceSiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                new Object[]{"%" + searchServiceSite + "%"},
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listService = new ArrayList<ServiceSite>();

            for (ServiceSiteDTO dto : dtos) {
                resp = mapperServiceWithServiceDTO.DTOToService(dto);
                listService.add(resp);
            }
        }
        return listService;
    }
}
