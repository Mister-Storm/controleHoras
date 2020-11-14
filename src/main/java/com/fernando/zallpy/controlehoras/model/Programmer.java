package com.fernando.zallpy.controlehoras.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Programmer extends User {

   public Programmer() {
       this.setAdmin(false);
   }

   @ManyToMany(mappedBy = "programmers")
   private Set<Project> projects;

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
