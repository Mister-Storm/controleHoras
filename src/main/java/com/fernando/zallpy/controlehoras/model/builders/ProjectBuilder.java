package com.fernando.zallpy.controlehoras.model.builders;

import com.fernando.zallpy.controlehoras.model.Programmer;
import com.fernando.zallpy.controlehoras.model.Project;

import java.util.Set;

public class ProjectBuilder {

    private Project project;

    public ProjectBuilder() {
        project = new Project();
    }

    public ProjectBuilder withId(Long id) {
        project.setId(id);
        return this;
    }

    public ProjectBuilder withProjectName(String name) {
        project.setProjectName(name);
        return this;
    }

    public ProjectBuilder withProgrammers(Set<Programmer> programmers) {
        project.setProgrammers(programmers);
        return this;
    }

    public Project build() {
        return project;
    }

}
