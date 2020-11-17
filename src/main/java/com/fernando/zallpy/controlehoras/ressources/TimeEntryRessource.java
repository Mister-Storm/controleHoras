package com.fernando.zallpy.controlehoras.ressources;

import com.fernando.zallpy.controlehoras.service.TimeEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/timeEntry")
public class TimeEntryRessource {
    private final TimeEntryService service;

    public TimeEntryRessource(TimeEntryService service) {
        this.service = service;
    }

}
