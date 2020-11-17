package com.fernando.zallpy.controlehoras.repository;

import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.TimeEntryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, TimeEntryId> {
}
