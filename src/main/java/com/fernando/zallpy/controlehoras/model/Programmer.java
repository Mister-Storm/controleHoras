package com.fernando.zallpy.controlehoras.model;

import com.fernando.zallpy.controlehoras.exception.AppointedHourViolationException;
import com.fernando.zallpy.controlehoras.model.builders.AppointedHourBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
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



    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public AppointedHour pointHours(Project project, BigDecimal hours, LocalDate date) throws AppointedHourViolationException {
        if(projects.contains(project)) {
            return new AppointedHourBuilder()
                    .withAppointedHourId(this.getIdUser(), project.getId())
                    .withHours(hours)
                    .withDate(date)
                    .build();
        } else {
            throw new AppointedHourViolationException(project);
        }

    }
}
