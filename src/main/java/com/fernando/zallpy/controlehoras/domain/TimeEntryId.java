package com.fernando.zallpy.controlehoras.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TimeEntryId implements Serializable {

    @ManyToOne
    @JoinColumn
    private User programmer;

    @ManyToOne
    @JoinColumn
    private Project project;

    public TimeEntryId(){}

    public User getProgrammer() {
        return programmer;
    }

    public void setProgrammer(User programmer) {
        this.programmer = programmer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntryId that = (TimeEntryId) o;
        return Objects.equals(programmer, that.programmer) &&
                Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmer, project);
    }
}
