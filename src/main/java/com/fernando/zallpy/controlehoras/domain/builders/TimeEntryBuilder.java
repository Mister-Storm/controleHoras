package com.fernando.zallpy.controlehoras.domain.builders;

import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.TimeEntryId;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TimeEntryBuilder {

    private TimeEntry timeEntry;

    public TimeEntryBuilder() {
        timeEntry = new TimeEntry();
    }

    public TimeEntryBuilder withAppointedHourId(Long programmerId, Long projectId) {
        timeEntry.setTimeEntryId(new TimeEntryId(programmerId, projectId));
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
