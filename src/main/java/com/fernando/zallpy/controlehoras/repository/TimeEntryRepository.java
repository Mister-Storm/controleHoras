package com.fernando.zallpy.controlehoras.repository;

import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    List<TimeEntry> findAllByProgrammerId(Long programmerId);
}
