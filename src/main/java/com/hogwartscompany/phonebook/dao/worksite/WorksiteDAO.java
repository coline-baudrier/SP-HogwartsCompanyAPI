package com.hogwartscompany.phonebook.dao.worksite;

import com.hogwartscompany.phonebook.dao.worksite.model.WorksiteDTO;
import com.hogwartscompany.phonebook.controller.worksite.model.NewWorksite;
import com.hogwartscompany.phonebook.controller.worksite.model.Worksite;
import com.hogwartscompany.phonebook.utils.mapper.MapperWorksiteWithWorksiteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WorksiteDAO {

    private static final String ID_FIELD = "id_worksite";
    private static final String NAMEWORKSITE_FIELD = "name_worksite";
    private static final String TYPEWORKSITE_FIELD = "type_worksite";
    private static final String PHONEWORKSITE_FIELD = "phone_worksite";
    private static final String EMAILWORKSITE_FIELD = "email_worksite";
    private static final String ADDRESSWORKSITE_FIELD = "address_worksite";

    private final JdbcTemplate jdbcTemplate;
    private final MapperWorksiteWithWorksiteDTO mapperWorksiteWithWorksiteDTO;

    @Autowired
    public WorksiteDAO(DataSource dataSource, MapperWorksiteWithWorksiteDTO mapperWorksiteWithWorksiteDTO) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapperWorksiteWithWorksiteDTO = mapperWorksiteWithWorksiteDTO;
    }

    private final RowMapper<WorksiteDTO> rowMapper = (rs, rowNum) -> {
        final WorksiteDTO worksite = new WorksiteDTO();
        worksite.setIdWorksite(rs.getInt(ID_FIELD));
        worksite.setNameWorksite(rs.getString(NAMEWORKSITE_FIELD));
        worksite.setTypeWorksite(rs.getString(TYPEWORKSITE_FIELD));
        worksite.setPhoneWorksite(rs.getString(PHONEWORKSITE_FIELD));
        worksite.setEmailWorksite(rs.getString(EMAILWORKSITE_FIELD));
        worksite.setIdAddress(rs.getInt(ADDRESSWORKSITE_FIELD));

        return worksite;
    };

    public Worksite getOne (int id) {
        Worksite worksite = null;
        String sqlQuery = "SELECT * FROM worksite WHERE id_worksite = " + id;

        List<WorksiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() == 1) {
            worksite = mapperWorksiteWithWorksiteDTO.DTOToWorksite(dtos.get(0));
        }
        return worksite;

    }
    public List<Worksite> getAll () {
        List<Worksite> listWorksite = null;
        Worksite resp = null;

        String sqlQuery = "SELECT * FROM worksite";

        List<WorksiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listWorksite = new ArrayList<Worksite>();

            for(WorksiteDTO dto : dtos){
                resp = mapperWorksiteWithWorksiteDTO.DTOToWorksite(dto);
                listWorksite.add(resp);
            }
        }
        return listWorksite;
    }

    public Worksite create(NewWorksite worksite){
        WorksiteDTO worksite1 = null;
        Worksite worksite2 = null;

        final String sqlQuery = "INSERT INTO worksite (name_worksite, type_worksite, phone_worksite, email_worksite, address_worksite) VALUES (?, ?, ?, ?, ?)";
        int resultCreation = this.jdbcTemplate.update(
                sqlQuery,
                worksite.getNameWorksite(),
                worksite.getTypeWorksite(),
                worksite.getPhoneWorksite(),
                worksite.getEmailWorksite(),
                worksite.getIdAddress()
        );

        if (resultCreation == 1) {
            worksite1 = mapperWorksiteWithWorksiteDTO.NewWorksiteDTO(worksite);
            worksite2 = mapperWorksiteWithWorksiteDTO.DTOToWorksite(worksite1);
        }

        return worksite2;
    }
    public Worksite update(int id, NewWorksite worksite){
        WorksiteDTO worksite1 = null;
        Worksite worksite2 = null;

        final String sqlQuery = "UPDATE worksite SET name_worksite = ?, type_worksite = ?, phone_worksite = ?, email_worksite = ?, address_worksite = ? WHERE id_worksite = ?";
        int resultUpdate = this.jdbcTemplate.update(
                sqlQuery,
                worksite.getNameWorksite(),
                worksite.getTypeWorksite(),
                worksite.getPhoneWorksite(),
                worksite.getEmailWorksite(),
                worksite.getIdAddress(),
                id
        );

        if (resultUpdate == 1) {
            worksite1 = mapperWorksiteWithWorksiteDTO.NewWorksiteDTO(worksite);
            worksite2 = mapperWorksiteWithWorksiteDTO.DTOToWorksite(worksite1);
        }

        return worksite2;
    }

    public boolean delete(int id) {
        final String sqlQuery = "DELETE FROM worksite WHERE id_worksite = ?";
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

    public List<Worksite> searchWorksiteByName (String searchWorksite) {
        List<Worksite> listWorksite = null;
        Worksite resp = null;

        String sqlQuery = "SELECT * FROM worksite WHERE name_worksite LIKE ?";

        List<WorksiteDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                new Object[]{"%" + searchWorksite + "%"},
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listWorksite = new ArrayList<Worksite>();

            for(WorksiteDTO dto : dtos){
                resp = mapperWorksiteWithWorksiteDTO.DTOToWorksite(dto);
                listWorksite.add(resp);
            }
        }
        return listWorksite;
    }
}
