package com.fernando.zallpy.controlehoras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {

    @Id
    private Long id;
    @Column
    private String projectName;
    @ManyToMany
    private List<Programmer> programers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Programmer> getProgramers() {
        return programers;
    }

    public void setProgramers(List<Programmer> programers) {
        this.programers = programers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }
}
