package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.domain.ProfileEnum;
import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.repository.TimeEntryRepository;
import com.fernando.zallpy.controlehoras.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TimeEntryService {

    @Autowired
    private TimeEntryRepository repository;

    public List<TimeEntry> findAll() {
        return repository.findAll();
    }

    public List<TimeEntry> findAllForProgrammer(Long programmerId) {
        UserSS userSS = UserSSService.authenticated();
        if (userSS == null || userSS.hasHole(ProfileEnum.ADMIN) || userSS.getId().equals(programmerId)) {
            return repository.findAllByTimeEntryId_ProgrammerId(programmerId);
        }
        throw new AuthorizationException("Access denied!!!!!");

    }
}
