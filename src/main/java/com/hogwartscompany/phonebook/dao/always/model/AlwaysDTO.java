package com.hogwartscompany.phonebook.dao.always.model;

import com.hogwartscompany.phonebook.dao.address.model.AddressDTO;
import com.hogwartscompany.phonebook.dao.employee.model.EmployeeDTO;
import com.hogwartscompany.phonebook.dao.service.model.ServiceSiteDTO;
import com.hogwartscompany.phonebook.dao.worksite.model.WorksiteDTO;

public class AlwaysDTO {
    EmployeeDTO employeeDTO;
    ServiceSiteDTO serviceSiteDTO;
    WorksiteDTO worksiteDTO;
    AddressDTO addressDTO;

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }
    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public ServiceSiteDTO getServiceSiteDTO() {
        return serviceSiteDTO;
    }

    public void setServiceSiteDTO(ServiceSiteDTO serviceSiteDTO) {
        this.serviceSiteDTO = serviceSiteDTO;
    }

    public WorksiteDTO getWorksiteDTO() {
        return worksiteDTO;
    }

    public void setWorksiteDTO(WorksiteDTO worksiteDTO) {
        this.worksiteDTO = worksiteDTO;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
