package com.fernando.zallpy.controlehoras.repository;

import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.TimeEntryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, TimeEntryId> {

    List<TimeEntry> findAllByTimeEntryId_ProgrammerId(Long programmerId);
}
