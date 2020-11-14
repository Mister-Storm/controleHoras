package com.fernando.zallpy.controlehoras.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Programmer extends User {

   public Programmer() {
       super(false);
   }

   @ManyToMany
    List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
