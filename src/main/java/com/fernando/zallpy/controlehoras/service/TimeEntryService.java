package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.model.Programmer;
import com.fernando.zallpy.controlehoras.model.Project;
import com.fernando.zallpy.controlehoras.model.TimeEntry;
import com.fernando.zallpy.controlehoras.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TimeEntryService {

    private final TimeEntryRepository repository;
    private final ProgrammerService programmerService;
    private final ProjectService projectService;


    @Autowired
    public TimeEntryService(TimeEntryRepository repository, ProgrammerService programmerService, ProjectService projectService) {
        this.repository = repository;
        this.programmerService = programmerService;
        this.projectService = projectService;
    }

    public TimeEntry includeHoursWorked(Programmer programmer, Project project, LocalDate date, BigDecimal hours) {
        return null;
    }
}
