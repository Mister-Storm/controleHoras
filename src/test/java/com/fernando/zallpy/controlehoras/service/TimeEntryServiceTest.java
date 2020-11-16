package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.model.Programmer;
import com.fernando.zallpy.controlehoras.model.Project;
import com.fernando.zallpy.controlehoras.model.TimeEntry;
import com.fernando.zallpy.controlehoras.repository.ProgrammerRepository;
import com.fernando.zallpy.controlehoras.repository.ProjectRepository;
import com.fernando.zallpy.controlehoras.repository.TimeEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TimeEntryServiceTest {


    TimeEntryService timeEntryService = Mockito.mock(TimeEntryService.class);;
    TimeEntryRepository repository = Mockito.mock(TimeEntryRepository.class);
    ProgrammerService programmerService= Mockito.mock(ProgrammerService.class);
    ProgrammerRepository programmerRepository= Mockito.mock(ProgrammerRepository.class);
    ProjectService projectService= Mockito.mock(ProjectService.class);
//    ProjectRepository projectRepository= Mockito.mock(ProjectRepository.class);

    @BeforeEach
    public void setup(){
        Mockito.spy(timeEntryService);
    }
    @Test
    void should_return_a_new_instance_of_Time_Entry_when_programmer_is_in_list() {

        TimeEntry timeEntry = timeEntryService.includeHoursWorked(new Programmer(), new Project(), LocalDate.now(), new BigDecimal(4));
        assertTrue(timeEntry != null);
    }
}