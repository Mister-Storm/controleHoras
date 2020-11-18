package com.fernando.zallpy.controlehoras.ressources;

import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.service.TimeEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/timeEntry")
public class TimeEntryRessource {
    private final TimeEntryService service;

    public TimeEntryRessource(TimeEntryService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping(value = "/{programmer}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROGRAMMER')")
    public ResponseEntity<?> findAllByProgrammer(@PathVariable Long programmer) {
        return new ResponseEntity<>(service.findAllForProgrammer(programmer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity<>(service.save(timeEntry), HttpStatus.CREATED);
    }

}
