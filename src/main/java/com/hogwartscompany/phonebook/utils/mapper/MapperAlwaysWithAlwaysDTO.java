package com.hogwartscompany.phonebook.utils.mapper;

import com.hogwartscompany.phonebook.controller.always.model.Always;
import com.hogwartscompany.phonebook.dao.always.model.AlwaysDTO;

public class AlwaysMapper {

    public AlwaysDTO alwaysToDTO(Always always) {
        AlwaysDTO dto = new AlwaysDTO();
        dto.setEmployeeDTO(always.getEmployee());
        dto.setServiceSiteDTO(always.getServiceSite());
        dto.setWorksiteDTO(always.getWorksite());
        dto.setAddressDTO(always.getAddress());
        return dto;
    }

    public Always dtoToAlways(AlwaysDTO dto) {
        Always always = new Always();
        always.setEmployee(dto.getEmployeeDTO());
        always.setServiceSite(dto.getServiceSiteDTO());
        always.setWorksite(dto.getWorksiteDTO());
        always.setAddress(dto.getAddressDTO());
        return always;
    }
}
