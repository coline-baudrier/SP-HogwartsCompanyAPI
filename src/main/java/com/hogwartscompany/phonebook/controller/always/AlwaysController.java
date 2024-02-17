package com.hogwartscompany.phonebook.controller.always;

import com.hogwartscompany.phonebook.business.always.AlwaysBusiness;
import com.hogwartscompany.phonebook.controller.always.model.Always;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class AlwaysController {
    private final String version = "/api/v1";
    private final AlwaysBusiness alwaysBusiness;

    @Autowired
    public AlwaysController(AlwaysBusiness alwaysBusiness) {
        this.alwaysBusiness = alwaysBusiness;
    }

    @GetMapping(version + "/always/allInfos")
    public List<Always> getAllInfos(
            @RequestParam(value = "idEmployee", required = false) Integer idEmployee,
            @RequestParam(value = "idService", required = false) Integer idService,
            @RequestParam(value = "idWorksite", required = false) Integer idWorksite,
            @RequestParam(value = "nameEmployee", required = false) String nameEmployee,
            @RequestParam(value = "nameService", required = false) String nameService,
            @RequestParam(value = "nameWorksite", required = false) String nameWorksite
    ) {
        return alwaysBusiness.getALlInfosService(idEmployee, idService, idWorksite, nameEmployee, nameService, nameWorksite);
    }
}
