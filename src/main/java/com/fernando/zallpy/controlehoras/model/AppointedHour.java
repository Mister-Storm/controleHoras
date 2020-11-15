package com.fernando.zallpy.controlehoras.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppointedHour {

    @EmbeddedId
    private AppointedHourId appointedHourId;

    @Column
    private BigDecimal hours;

    @Column
    private LocalDate date;

    public AppointedHourId getAppointedHourId() {
        return appointedHourId;
    }

    public void setAppointedHourId(AppointedHourId appointedHourId) {
        this.appointedHourId = appointedHourId;
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
        AppointedHour that = (AppointedHour) o;
        return Objects.equals(appointedHourId, that.appointedHourId) &&
                Objects.equals(hours, that.hours) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointedHourId, hours, date);
    }
}
