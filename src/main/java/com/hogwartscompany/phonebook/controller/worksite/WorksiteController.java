package com.hogwartscompany.phonebook.controller.worksite;

import com.hogwartscompany.phonebook.business.worksite.WorksiteBusiness;
import com.hogwartscompany.phonebook.controller.worksite.model.NewWorksite;
import com.hogwartscompany.phonebook.controller.worksite.model.Worksite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
public class WorksiteController {
    private final String version = "/api/v1";
    private final WorksiteBusiness worksiteBusiness;

    @Autowired
    public WorksiteController(WorksiteBusiness worksiteBusiness) {
        this.worksiteBusiness = worksiteBusiness;
    }

    @PostMapping(version + "/worksites")
    public Worksite createWorksite(@RequestBody NewWorksite worksite) {
        return worksiteBusiness.createWorksiteService(worksite);
    }
    @DeleteMapping(version + "/worksites/{id}")
    public boolean deleteWorksite(@PathVariable int id){
        return worksiteBusiness.deleteWorksiteService(id);
    }
    @PutMapping(version + "/worksites/{id}")
    public Worksite updateWorksite(@PathVariable int id, @RequestBody NewWorksite worksite) {
        return worksiteBusiness.updateWorksiteService(id, worksite);
    }
    @GetMapping(version + "/worksites/{id}")
    public Worksite getOneWorksite(@PathVariable int id) {
        return worksiteBusiness.getOneWorksiteService(id);
    }
    @GetMapping(version + "/worksites")
    public List<Worksite> getAllWorksites() {
        return worksiteBusiness.getAllWorksiteService();
    }
    @GetMapping(version + "/worksites/searchWorksite")
    public List<Worksite> searchWorksiteByName(@RequestParam String searchWorksite) {
        return worksiteBusiness.searchWorksiteByNameService(searchWorksite);
    }

}
