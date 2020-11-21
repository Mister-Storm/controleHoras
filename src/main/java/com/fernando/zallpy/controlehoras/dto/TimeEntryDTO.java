package com.fernando.zallpy.controlehoras.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TimeEntryDTO {
    private Long programmerId;
    private Long projectId;
    private BigDecimal hours;
    private LocalDate date;

    public Long getProgrammerId() {
        return programmerId;
    }

    public void setProgrammerId(Long programmerId) {
        this.programmerId = programmerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
}
