package com.hogwartscompany.phonebook.dao.address;

import com.hogwartscompany.phonebook.dao.address.model.AddressDTO;
import com.hogwartscompany.phonebook.controller.address.model.Address;
import com.hogwartscompany.phonebook.controller.address.model.NewAddress;
import com.hogwartscompany.phonebook.utils.mapper.MapperAddressWithAddressDTO;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDAO {

    //Ici je viens noter les attributs de la table qui est concernée
    private static final String ID_FIELD = "id_address";
    private static final String BUILDINGFLOOR_FIELD = "building_floor";
    private static final String BUILDINGNAME_FIELD = "building";
    private static final String ADDRESSLINE1_FIELD = "address_line_1";
    private static final String ADDRESSLINE2_FIELD = "address_line_2";
    private static final String DEPARTMENT_FIELD = "department";
    private static final String CITY_FIELD = "city";

    private final JdbcTemplate jdbcTemplate;
    private final MapperAddressWithAddressDTO mapperAddressWithAddressDTO;

    @Autowired
    public AddressDAO(DataSource dataSource, MapperAddressWithAddressDTO mapperAddressWithAddressDTO){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapperAddressWithAddressDTO = mapperAddressWithAddressDTO;
    }

    private final RowMapper<AddressDTO> rowMapper = (rs, rowNum) -> {
      final AddressDTO address = new AddressDTO();
      address.setIdAddress(rs.getInt(ID_FIELD));
      address.setBuildingFloor(rs.getString(BUILDINGFLOOR_FIELD));
      address.setBuildingName(rs.getString(BUILDINGNAME_FIELD));
      address.setLineAddress1(rs.getString(ADDRESSLINE1_FIELD));
      address.setLineAddress2(rs.getString(ADDRESSLINE2_FIELD));
      address.setDepartmentCode(rs.getString(DEPARTMENT_FIELD));
      address.setCityName(rs.getString(CITY_FIELD));
      return address;
    };

    //Recherche par seulement un ID pour ne pas avoir de bugs

    public Address getOne (int id) {
        //Lis les informations d'une seule adresse
        Address address = null;
        String sqlQuery = "SELECT * FROM address WHERE id_address = " + id;

        List<AddressDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() == 1) {
            address = mapperAddressWithAddressDTO.DTOToAddress(dtos.get(0));
        }

        return address;
    }

    public List<Address> getAll (String buildingName, String departmentCode, String cityName) {
        //Lis les informations de toutes les adresses de la BDD
        List<Address> listAddresses = null;
        Address resp = null;

        String sqlQuery = "SELECT * FROM address";

        if (buildingName != null && !buildingName.isEmpty()) {
            sqlQuery += " WHERE building LIKE '%" + buildingName + "%'";
        }

        if (departmentCode != null && !departmentCode.isEmpty()) {
            sqlQuery += " WHERE department LIKE '%" + departmentCode + "%'";
        }

        if (cityName != null && !cityName.isEmpty()) {
            sqlQuery += " WHERE city LIKE '%" + cityName + "%'";
        }

        List<AddressDTO> dtos = this.jdbcTemplate.query(
                sqlQuery,
                this.rowMapper
        );

        if (dtos != null && dtos.size() > 0) {
            listAddresses = new ArrayList<Address>();

            for(AddressDTO dto : dtos) {
                resp = mapperAddressWithAddressDTO.DTOToAddress(dto);
                listAddresses.add(resp);
            }
        }
        return listAddresses;
    }

    public Address create(NewAddress address){
        //Insère une nouvelle adresse dans la db
        //Pas besoin d'initialiser l'ID puisqu'il est en auto_incr dans la BDD

        AddressDTO address1 = null;
        Address address2 = null;

        final String sqlQuery = "INSERT INTO address (building_floor, building, address_line_1, address_line_2, department, city) VALUES (?,?,?,?,?,?)";
        int resultCreation = this.jdbcTemplate.update(
                sqlQuery,
                address.getBuildingFloor(),
                address.getBuildingName(),
                address.getLineAddress1(),
                address.getLineAddress2(),
                address.getDepartmentCode(),
                address.getCityName()
        );

        if (resultCreation == 1) { //J'attends un résultat de type Address
            //Mais comme je récupère un objet de type AddressDTO, il faut que je le retransforme en Address
            //Donc double mapping, mais je peux créer un mapper qui fait NewAddressToAddress
            address1 = mapperAddressWithAddressDTO.NewAddressToDTO(address);
            address2 = mapperAddressWithAddressDTO.DTOToAddress(address1);
        }

        return address2;
    }

    public Address update(int id, NewAddress address) {
        //Met à jour l'ID indiqué dans les paramètres
        AddressDTO address1 = null;
        Address address2 = null;

        final String sqlQuery = "UPDATE address SET building_floor = ?, building = ?, address_line_1 = ?, address_line_2 = ?, department = ?, city = ? WHERE id_address = ?";
        int resultUpdate = this.jdbcTemplate.update (
                sqlQuery,
                address.getBuildingFloor(),
                address.getBuildingName(),
                address.getLineAddress1(),
                address.getLineAddress2(),
                address.getDepartmentCode(),
                address.getCityName(),
                id
        );

        if (resultUpdate == 1){
            address1 = mapperAddressWithAddressDTO.NewAddressToDTO(address);
            address2 = mapperAddressWithAddressDTO.DTOToAddress(address1);
        }
        return address2;
    }

    public boolean delete(int id) {
        final String sqlQuery = "DELETE FROM address WHERE id_address = ?";
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

}
