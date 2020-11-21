package com.fernando.zallpy.controlehoras.dto.mappers;

import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.builders.TimeEntryBuilder;
import com.fernando.zallpy.controlehoras.dto.TimeEntryDTO;

public class TimeEntryMapper {

    public static TimeEntry toEntity(TimeEntryDTO dto){
        return new TimeEntryBuilder()
                .withProgrammer(dto.getProgrammerId())
                .withProject(dto.getProjectId())
                .withHours(dto.getHours())
                .withDate(dto.getDate())
                .build();
    }
}
