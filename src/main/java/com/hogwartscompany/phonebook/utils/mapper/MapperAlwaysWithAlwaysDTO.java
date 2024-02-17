package com.hogwartscompany.phonebook.utils.mapper;

import com.hogwartscompany.phonebook.controller.always.model.Always;
import com.hogwartscompany.phonebook.dao.always.model.AlwaysDTO;

public class MapperAlwaysWithAlwaysDTO {

    private final MapperEmployeeWithEmployeeDTO mapperEmployee;
    private final MapperAddressWithAddressDTO mapperAddress;
    private final MapperWorksiteWithWorksiteDTO mapperWorksite;
    private final MapperServiceWithServiceSiteDTO mapperServiceSite;

    public MapperAlwaysWithAlwaysDTO(MapperEmployeeWithEmployeeDTO mapperEmployee, MapperAddressWithAddressDTO mapperAddress,
                                     MapperWorksiteWithWorksiteDTO mapperWorksite, MapperServiceWithServiceSiteDTO mapperServiceSite) {
        this.mapperEmployee = mapperEmployee;
        this.mapperAddress = mapperAddress;
        this.mapperWorksite = mapperWorksite;
        this.mapperServiceSite = mapperServiceSite;
    }

    public AlwaysDTO AlwaysToDTO(Always always) {
        AlwaysDTO dto = new AlwaysDTO();
        dto.setEmployeeDTO(mapperEmployee.EmployeeToDTO(always.getEmployee()));
        dto.setServiceSiteDTO(mapperServiceSite.ServiceToDTO(always.getServiceSite()));
        dto.setWorksiteDTO(mapperWorksite.WorksiteToDTO(always.getWorksite()));
        dto.setAddressDTO(mapperAddress.AddressToDTO(always.getAddress()));

        return dto;
    }

    public Always DTOToAlways (AlwaysDTO dto) {
        Always always = new Always();
        always.setEmployee(mapperEmployee.DTOToEmployee(dto.getEmployeeDTO()));
        always.setServiceSite(mapperServiceSite.DTOToService(dto.getServiceSiteDTO()));
        always.setWorksite(mapperWorksite.DTOToWorksite(dto.getWorksiteDTO()));
        always.setAddress(mapperAddress.DTOToAddress(dto.getAddressDTO()));

        return always;
    }

}
