package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.domain.Project;
import com.fernando.zallpy.controlehoras.repository.ProjectRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    public Project findById(Long projectId) {
        return repository.findById(projectId).orElseThrow(()-> new ObjectNotFoundException(Project.class, "Project"));
    }
}
