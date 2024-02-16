package com.hogwartscompany.phonebook.business.always;

import com.hogwartscompany.phonebook.dao.address.AddressDAO;
import com.hogwartscompany.phonebook.dao.employee.EmployeeDAO;
import com.hogwartscompany.phonebook.dao.service.ServiceSiteDAO;
import com.hogwartscompany.phonebook.dao.worksite.WorksiteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlwaysBusiness {

    private EmployeeDAO employeeDAO;
    private ServiceSiteDAO serviceSiteDAO;
    private WorksiteDAO worksiteDAO;
    private AddressDAO addressDAO;

    @Autowired
    public AlwaysBusiness (EmployeeDAO employeeDAO, ServiceSiteDAO serviceSiteDAO, WorksiteDAO worksiteDAO, AddressDAO addressDAO) {
        this.employeeDAO = employeeDAO;
        this.serviceSiteDAO = serviceSiteDAO;
        this.worksiteDAO = worksiteDAO;
        this.addressDAO = addressDAO;
    }

}
