package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.model.Programmer;
import com.fernando.zallpy.controlehoras.model.Project;
import com.fernando.zallpy.controlehoras.model.TimeEntry;
import com.fernando.zallpy.controlehoras.model.builders.ProgrammerBuilder;
import com.fernando.zallpy.controlehoras.model.builders.ProjectBuilder;
import com.fernando.zallpy.controlehoras.repository.ProgrammerRepository;
import com.fernando.zallpy.controlehoras.repository.ProjectRepository;
import com.fernando.zallpy.controlehoras.repository.TimeEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TimeEntryServiceTest {


    TimeEntryService timeEntryService = Mockito.mock(TimeEntryService.class);;
    TimeEntryRepository repository = Mockito.mock(TimeEntryRepository.class);
    ProgrammerService programmerService= Mockito.mock(ProgrammerService.class);
    ProgrammerRepository programmerRepository= Mockito.mock(ProgrammerRepository.class);
    ProjectService projectService= Mockito.mock(ProjectService.class);

    @BeforeEach
    public void setup(){
        Mockito.spy(timeEntryService);
    }
    @Test
    void should_return_a_new_instance_of_Time_Entry_when_programmer_is_in_list() throws TimeoutException {

        Programmer programmer = createProgrammer();
        Project project = createProject();
        TimeEntry timeEntry = timeEntryService.includeHoursWorked(programmer, project, LocalDate.now(), new BigDecimal(4));
        assertTrue(timeEntry != null);
    }

    private Project createProject() {
        Set<Programmer> programmers = new HashSet<Programmer>();
        programmers.add(createProgrammer());
        return new ProjectBuilder()
                .withId(1L)
                .withProgrammers(programmers)
                .withProjectName("project A")
                .build();
    }

    private Programmer createProgrammer() {
        return new ProgrammerBuilder()
                .withName("Fulano")
                .withEmail("fulano@123.com")
                .withId(1L)
                .withPassword("123456")
                .withProjects(new HashSet<Project>())
                .builder();
    }
}