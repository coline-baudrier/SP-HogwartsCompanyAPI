package com.hogwartscompany.phonebook.business.worksite;

import com.hogwartscompany.phonebook.dao.worksite.WorksiteDAO;
import com.hogwartscompany.phonebook.controller.worksite.model.NewWorksite;
import com.hogwartscompany.phonebook.controller.worksite.model.Worksite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksiteBusiness {
    private final WorksiteDAO worksiteDAO;

    @Autowired
    public WorksiteBusiness(WorksiteDAO worksiteDAO){
        this.worksiteDAO = worksiteDAO;
    }
    public Worksite createWorksiteService (NewWorksite worksite){
        return worksiteDAO.create(worksite);
    }
    public boolean deleteWorksiteService (int id) {
        return worksiteDAO.delete(id);
    }
    public Worksite updateWorksiteService (int id, NewWorksite worksite){
        return worksiteDAO.update(id, worksite);
    }
    public Worksite getOneWorksiteService(int id) {
        return worksiteDAO.getOne(id);
    }
    public List<Worksite> getAllWorksiteService() {
        return worksiteDAO.getAll();
    }
    public List<Worksite> searchWorksiteByNameService(String searchWorksite) {
        return worksiteDAO.searchWorksiteByName(searchWorksite);
    }


}
