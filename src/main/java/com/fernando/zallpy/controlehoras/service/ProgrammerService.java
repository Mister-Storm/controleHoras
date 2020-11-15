package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.model.Programmer;
import com.fernando.zallpy.controlehoras.repository.ProgrammerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProgrammerService {

    private final ProgrammerRepository repository;

    @Autowired
    public ProgrammerService(ProgrammerRepository repository) {
        this.repository=repository;
    }

    public Set<Programmer> findAllProgrammers() {
        Set<Programmer> programmers = new HashSet<Programmer>();
        repository.findAll().stream().forEach(programmer-> programmers.add(programmer));
        return programmers;

    }

    public Programmer findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException(1L, "Programmer"));
    }



}
