package com.fernando.zallpy.controlehoras.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TimeEntry {

    @EmbeddedId
    private TimeEntryId timeEntryId;

    @Column
    private BigDecimal hours;

    @Column
    private LocalDate date;

    public TimeEntryId getTimeEntryId() {
        return timeEntryId;
    }

    public void setTimeEntryId(TimeEntryId timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry that = (TimeEntry) o;
        return Objects.equals(timeEntryId, that.timeEntryId) &&
                Objects.equals(hours, that.hours) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeEntryId, hours, date);
    }
}
