package com.fernando.zallpy.controlehoras.repository;

import com.fernando.zallpy.controlehoras.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}