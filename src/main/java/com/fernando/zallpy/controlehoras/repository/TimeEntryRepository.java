package com.fernando.zallpy.controlehoras.repository;

import com.fernando.zallpy.controlehoras.model.TimeEntry;
import com.fernando.zallpy.controlehoras.model.TimeEntryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, TimeEntryId> {
}
