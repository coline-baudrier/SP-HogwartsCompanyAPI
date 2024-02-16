package com.hogwartscompany.phonebook.controller.always;

import com.hogwartscompany.phonebook.business.always.AlwaysBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AlwaysController {
    private final String version = "/api/v1";
    private final AlwaysBusiness alwaysBusiness;

    @Autowired
    public AlwaysController(AlwaysBusiness alwaysBusiness) {
        this.alwaysBusiness = alwaysBusiness;
    }

}
