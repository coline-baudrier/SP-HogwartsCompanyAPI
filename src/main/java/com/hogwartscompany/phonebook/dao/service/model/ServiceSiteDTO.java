package com.hogwartscompany.phonebook.dao.service.model;

import java.sql.Timestamp;

public class ServiceSiteDTO {
    int idService;
    String nameService;
    String typeService;
    String phoneService;
    String emailService;
    Timestamp dateCreationService;
    int idAddress;
    int idWorksite;

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(String phoneService) {
        this.phoneService = phoneService;
    }

    public String getEmailService() {
        return emailService;
    }

    public void setEmailService(String emailService) {
        this.emailService = emailService;
    }

    public Timestamp getDateCreationService() {
        return dateCreationService;
    }

    public void setDateCreationService(Timestamp dateCreationService) {
        this.dateCreationService = dateCreationService;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdWorksite() {
        return idWorksite;
    }

    public void setIdWorksite(int idWorksite) {
        this.idWorksite = idWorksite;
    }
}
