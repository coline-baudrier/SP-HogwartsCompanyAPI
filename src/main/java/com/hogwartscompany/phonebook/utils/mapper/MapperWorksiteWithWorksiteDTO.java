package com.hogwartscompany.phonebook.utils.mapper;

import com.hogwartscompany.phonebook.dao.worksite.model.WorksiteDTO;
import com.hogwartscompany.phonebook.controller.worksite.model.NewWorksite;
import com.hogwartscompany.phonebook.controller.worksite.model.Worksite;

public class MapperWorksiteWithWorksiteDTO {

    public WorksiteDTO WorksiteToDTO (Worksite worksite) {
        WorksiteDTO dto = new WorksiteDTO();
        dto.setIdWorksite(worksite.getIdWorksite());
        dto.setNameWorksite(worksite.getNameWorksite());
        dto.setTypeWorksite(worksite.getTypeWorksite());
        dto.setPhoneWorksite(worksite.getPhoneWorksite());
        dto.setEmailWorksite(worksite.getEmailWorksite());
        dto.setIdAddress(worksite.getIdAddress());

        return dto;
    }

    public WorksiteDTO NewWorksiteDTO(NewWorksite worksite) {
        WorksiteDTO dto = new WorksiteDTO();
        dto.setNameWorksite(worksite.getNameWorksite());
        dto.setTypeWorksite(worksite.getTypeWorksite());
        dto.setPhoneWorksite(worksite.getPhoneWorksite());
        dto.setEmailWorksite(worksite.getEmailWorksite());
        dto.setIdAddress(worksite.getIdAddress());

        return dto;
    }

    public Worksite DTOToWorksite (WorksiteDTO dto) {
        Worksite worksite = new Worksite();
        worksite.setIdWorksite(dto.getIdWorksite());
        worksite.setNameWorksite(dto.getNameWorksite());
        worksite.setTypeWorksite(dto.getTypeWorksite());
        worksite.setPhoneWorksite(dto.getPhoneWorksite());
        worksite.setEmailWorksite(dto.getEmailWorksite());
        worksite.setIdAddress(dto.getIdAddress());

        return worksite;
    }
}
