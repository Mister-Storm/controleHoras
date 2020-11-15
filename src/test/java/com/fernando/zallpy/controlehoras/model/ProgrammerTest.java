package com.fernando.zallpy.controlehoras.model;

import com.fernando.zallpy.controlehoras.exception.AppointedHourViolationException;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammerTest {

    @Test
    public void given_a_project_that_the_programmer_is_registered_when_points_out_hours_should_be_trow_an_exception() throws AppointedHourViolationException {
        Programmer programmer = new Programmer();
        Project projA = new Project();
        projA.setId(1L);
        projA.setProjectName("Projeto A");
        Set<Project> projects = new HashSet<>();
        projects.add(projA);
        programmer.setProjects(projects);

        assertTrue(programmer.pointHours(projA, new BigDecimal(2.5), LocalDate.now()) != null);
    }

    @Test
    public void given_a_project_that_the_programmer_is_not_registered_when_points_out_hours_should_be_trow_an_exception() throws AppointedHourViolationException {
        Programmer programmer = new Programmer();
        Project projA = new Project();
        projA.setId(1L);
        projA.setProjectName("Projeto A");
        Set<Project> projects = new HashSet<>();
        projects.add(projA);
        programmer.setProjects(projects);
        Project projB = new Project();
        projA.setId(2L);
        projA.setProjectName("Projeto B");
        assertThrows(AppointedHourViolationException.class, ()-> programmer.pointHours(projB, new BigDecimal(2.5), LocalDate.now()));
    }

}