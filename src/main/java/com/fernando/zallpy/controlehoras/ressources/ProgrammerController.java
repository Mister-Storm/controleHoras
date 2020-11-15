package com.fernando.zallpy.controlehoras.ressources;

import com.fernando.zallpy.controlehoras.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/programmers")
public class ProgrammerController {

    private final ProgrammerService service;

    @Autowired
    public ProgrammerController(ProgrammerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity(service.findAllProgrammers(), HttpStatus.OK);

    }
}
