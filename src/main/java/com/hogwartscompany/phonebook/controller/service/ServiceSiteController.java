package com.hogwartscompany.phonebook.controller.service;

import com.hogwartscompany.phonebook.business.service.ServiceSiteBusiness;
import com.hogwartscompany.phonebook.controller.service.model.NewServiceSite;
import com.hogwartscompany.phonebook.controller.service.model.ServiceSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ServiceSiteController {
    private final String version = "/api/v1";
    private final ServiceSiteBusiness serviceSiteBusiness;

    @Autowired
    public ServiceSiteController(ServiceSiteBusiness serviceSiteBusiness) {
        this.serviceSiteBusiness = serviceSiteBusiness;
    }

    @PostMapping(version + "/services")
    public ServiceSite createServiceSite(@RequestBody NewServiceSite serviceSite) {
        return serviceSiteBusiness.createServiceSiteService(serviceSite);
    }
    @DeleteMapping(version + "/services/{id}")
    public boolean deleteServiceSite(@PathVariable int id){
        return serviceSiteBusiness.deleteServiceSiteService(id);
    }
    @PutMapping(version + "/services/{id}")
    public ServiceSite updateServiceSite(@PathVariable int id, @RequestBody NewServiceSite serviceSite) {
        return serviceSiteBusiness.updateServiceSiteService(id, serviceSite);
    }
    @GetMapping(version + "/services/{id}")
    public ServiceSite getOneServiceSite(@PathVariable int id) {
        return serviceSiteBusiness.getOneServiceSiteService(id);
    }
    @GetMapping(version + "/services")
    public List<ServiceSite> getAllServicesSite() {
        return serviceSiteBusiness.getAllServicesSiteService();
    }
    @GetMapping(version + "/services/searchService")
    public List<ServiceSite> searchServiceSiteByName(@RequestParam String searchServiceSite) {
        return serviceSiteBusiness.searchServiceSiteByNameService(searchServiceSite);
    }
}
