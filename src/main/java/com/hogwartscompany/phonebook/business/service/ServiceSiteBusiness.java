package com.hogwartscompany.phonebook.business.service;

import com.hogwartscompany.phonebook.dao.service.ServiceSiteDAO;
import com.hogwartscompany.phonebook.controller.service.model.NewServiceSite;
import com.hogwartscompany.phonebook.controller.service.model.ServiceSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSiteBusiness {

    private final ServiceSiteDAO serviceSiteDAO;

    @Autowired
    public ServiceSiteBusiness(ServiceSiteDAO serviceSiteDAO) {
        this.serviceSiteDAO = serviceSiteDAO;
    }
    public ServiceSite createServiceSiteService (NewServiceSite serviceSite){
        return serviceSiteDAO.create(serviceSite);
    }
    public boolean deleteServiceSiteService (int id) {
        return serviceSiteDAO.delete(id);
    }
    public ServiceSite updateServiceSiteService (int id, NewServiceSite serviceSite) {
        return serviceSiteDAO.update(id, serviceSite);
    }
    public ServiceSite getOneServiceSiteService (int id) {
        return serviceSiteDAO.getOne(id);
    }
    public List<ServiceSite> getAllServicesSiteService() {
        return serviceSiteDAO.getAll();
    }
    public List<ServiceSite> searchServiceSiteByNameService(String searchServiceSite) {
        return serviceSiteDAO.searchServiceSiteByName(searchServiceSite);
    }
    public List<ServiceSite> getServicesByWorksiteService(int idWorksite) {
        return serviceSiteDAO.getServicesByWorksite(idWorksite);
    }
}
