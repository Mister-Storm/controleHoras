package com.fernando.zallpy.controlehoras.domain.builders;

import com.fernando.zallpy.controlehoras.domain.Project;
import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.TimeEntryId;
import com.fernando.zallpy.controlehoras.domain.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TimeEntryBuilder {

    private TimeEntry timeEntry;

    public TimeEntryBuilder() {
        timeEntry = new TimeEntry();
    }

    public TimeEntryBuilder withProgrammer(Long programmerId) {
        timeEntry.setProgrammer(new User(programmerId));
        return this;
    }

    public TimeEntryBuilder withProject(Long projectId) {
        timeEntry.setProject(new Project(projectId));
        return this;
    }

    public TimeEntryBuilder withHours(BigDecimal hours) {
        timeEntry.setHours(hours);
        return this;
    }
    public TimeEntryBuilder withDate(LocalDate date) {
        timeEntry.setDate(date);
        return this;
    }
    public TimeEntry build() {
        return timeEntry;
    }

}
