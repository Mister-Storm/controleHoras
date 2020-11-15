package com.fernando.zallpy.controlehoras.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppointedHourId implements Serializable {

    private Long programmerId;
    private Long projectId;

    public AppointedHourId(){}
    public AppointedHourId(Long programmerId, Long projectId) {
        this.programmerId=programmerId;
        this.projectId=projectId;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointedHourId that = (AppointedHourId) o;
        return Objects.equals(programmerId, that.programmerId) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmerId, projectId);
    }
}
