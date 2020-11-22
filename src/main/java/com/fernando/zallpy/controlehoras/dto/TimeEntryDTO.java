package com.fernando.zallpy.controlehoras.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TimeEntryDTO {
    private Long programmerId;
    private String programmerName;
    private Long projectId;
    private String projectName;
    private BigDecimal hours;
    private LocalDate date;

    public TimeEntryDTO(Long programmerId, String programmerName, Long projectId, String projectName, BigDecimal hours, LocalDate date) {
        this.programmerId = programmerId;
        this.programmerName = programmerName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.hours = hours;
        this.date = date;
    }

    public Long getProgrammerId() {
        return programmerId;
    }

    public void setProgrammerId(Long programmerId) {
        this.programmerId = programmerId;
    }

    public String getProgrammerName() {
        return programmerName;
    }

    public void setProgrammerName(String programmerName) {
        this.programmerName = programmerName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
