package com.hogwartscompany.phonebook.utils.mapper;

import com.hogwartscompany.phonebook.dao.service.model.ServiceSiteDTO;
import com.hogwartscompany.phonebook.controller.service.model.NewServiceSite;
import com.hogwartscompany.phonebook.controller.service.model.ServiceSite;

public class MapperServiceWithServiceSiteDTO {
    public ServiceSiteDTO ServiceToDTO (ServiceSite service) {
        ServiceSiteDTO dto = new ServiceSiteDTO();
        dto.setIdService(service.getIdService());
        dto.setNameService(service.getNameService());
        dto.setTypeService(service.getTypeService());
        dto.setPhoneService(service.getPhoneService());
        dto.setEmailService(service.getEmailService());
        dto.setDateCreationService(service.getDateCreationService());
        dto.setIdAddress(service.getIdAddress());
        dto.setIdWorksite(service.getIdWorksite());

        return dto;
    }

    public ServiceSiteDTO NewServiceDTO (NewServiceSite service) {
        ServiceSiteDTO dto = new ServiceSiteDTO();
        dto.setNameService(service.getNameService());
        dto.setTypeService(service.getTypeService());
        dto.setPhoneService(service.getPhoneService());
        dto.setEmailService(service.getEmailService());
        dto.setDateCreationService(service.getDateCreationService());
        dto.setIdAddress(service.getIdAddress());
        dto.setIdWorksite(service.getIdWorksite());

        return dto;
    }

    public ServiceSite DTOToService (ServiceSiteDTO dto) {
        ServiceSite service = new ServiceSite();
        service.setIdService(dto.getIdService());
        service.setNameService(dto.getNameService());
        service.setTypeService(dto.getTypeService());
        service.setPhoneService(dto.getPhoneService());
        service.setEmailService(dto.getEmailService());
        service.setDateCreationService(dto.getDateCreationService());
        service.setIdAddress(dto.getIdAddress());
        service.setIdWorksite(dto.getIdWorksite());

        return service;
    }
}
