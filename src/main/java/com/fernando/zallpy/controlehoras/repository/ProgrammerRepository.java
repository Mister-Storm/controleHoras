package com.fernando.zallpy.controlehoras.repository;

import com.fernando.zallpy.controlehoras.model.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
}
