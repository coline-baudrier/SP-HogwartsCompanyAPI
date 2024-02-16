package com.hogwartscompany.phonebook.controller.always.model;

import com.hogwartscompany.phonebook.controller.address.model.Address;
import com.hogwartscompany.phonebook.controller.employee.model.Employee;
import com.hogwartscompany.phonebook.controller.service.model.ServiceSite;
import com.hogwartscompany.phonebook.controller.worksite.model.Worksite;

public class Always {
    Employee employee;
    ServiceSite serviceSite;
    Worksite worksite;
    Address address;
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ServiceSite getServiceSite() {
        return serviceSite;
    }

    public void setServiceSite(ServiceSite serviceSite) {
        this.serviceSite = serviceSite;
    }

    public Worksite getWorksite() {
        return worksite;
    }

    public void setWorksite(Worksite worksite) {
        this.worksite = worksite;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
