package com.fernando.zallpy.controlehoras.model.builders;

import com.fernando.zallpy.controlehoras.model.Programmer;
import com.fernando.zallpy.controlehoras.model.Project;

import java.util.Set;

public class ProgrammerBuilder {

    Programmer programmer;

    public ProgrammerBuilder(){
        programmer= new Programmer();
    }

    public ProgrammerBuilder withId(Long id) {
        programmer.setIdUser(id);
        return this;
    }

    public ProgrammerBuilder withName(String name) {
        programmer.setName(name);
        return this;
    }

    public ProgrammerBuilder withPassword(String password) {
        programmer.setPassword(password);
        return this;
    }

    public ProgrammerBuilder withEmail(String email) {
        programmer.setEmail(email);
        return this;
    }

    public ProgrammerBuilder withProjects(Set<Project> projects) {
        programmer.setProjects(projects);
        return this;
    }

    public Programmer builder(){
        return programmer;
    }
}
