package com.hogwartscompany.phonebook.business.always;

import com.hogwartscompany.phonebook.controller.always.model.Always;
import com.hogwartscompany.phonebook.dao.address.AddressDAO;
import com.hogwartscompany.phonebook.dao.always.AlwaysDAO;
import com.hogwartscompany.phonebook.dao.employee.EmployeeDAO;
import com.hogwartscompany.phonebook.dao.service.ServiceSiteDAO;
import com.hogwartscompany.phonebook.dao.worksite.WorksiteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlwaysBusiness {
    private final AlwaysDAO alwaysDAO;
    private final EmployeeDAO employeeDAO;
    private final ServiceSiteDAO serviceSiteDAO;
    private final WorksiteDAO worksiteDAO;
    private final AddressDAO addressDAO;

    @Autowired
    public AlwaysBusiness (AlwaysDAO alwaysDAO, EmployeeDAO employeeDAO, ServiceSiteDAO serviceSiteDAO, WorksiteDAO worksiteDAO, AddressDAO addressDAO) {
        this.alwaysDAO = alwaysDAO;
        this.employeeDAO = employeeDAO;
        this.serviceSiteDAO = serviceSiteDAO;
        this.worksiteDAO = worksiteDAO;
        this.addressDAO = addressDAO;
    }

    public List<Always> getAllService() {
        return alwaysDAO.getAll();
    }

}
