package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.domain.ProfileEnum;
import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.repository.TimeEntryRepository;
import com.fernando.zallpy.controlehoras.security.UserSS;
import com.fernando.zallpy.controlehoras.service.exception.AuthorizationException;
import com.fernando.zallpy.controlehoras.service.exception.UnauthorizedException;
import com.fernando.zallpy.controlehoras.service.utils.TimeEntryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TimeEntryService {

    @Autowired
    private TimeEntryRepository repository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    public List<TimeEntry> findAll() {
        return repository.findAll();
    }

    public List<TimeEntry> findAllForProgrammer(Long programmerId) {

        if (TimeEntryUtils.isTheSameUser(UserSSService.authenticated(), programmerId)) {
            return repository.findAllByTimeEntryId_ProgrammerId(programmerId);
        }
        throw new AuthorizationException("Access denied!!!!!");

    }

    public TimeEntry save(TimeEntry timeEntry) {
        UserSS user = UserSSService.authenticated();
        if(TimeEntryUtils.isTheSameUser(user, timeEntry.getTimeEntryId().getProgrammerId())
        && user.hasHole(ProfileEnum.PROGRAMMER)
        && TimeEntryUtils.isTheProgrammerInList(userService.findById(user.getId()),
                projectService.findById(timeEntry.getTimeEntryId().getProjectId()))){
            return repository.save(timeEntry);
        }
        throw new UnauthorizedException("You don't have authorization to realize this task!");
    }
}
