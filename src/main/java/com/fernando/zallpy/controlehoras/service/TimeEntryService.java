package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.domain.ProfileEnum;
import com.fernando.zallpy.controlehoras.domain.TimeEntry;
import com.fernando.zallpy.controlehoras.domain.User;
import com.fernando.zallpy.controlehoras.dto.TimeEntryDTO;
import com.fernando.zallpy.controlehoras.dto.mappers.TimeEntryMapper;
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

        UserSS user = UserSSService.authenticated();
        if (TimeEntryUtils.isTheSameUser(user, programmerId)
        || user.hasHole(ProfileEnum.ADMIN)) {
            return repository.findAllByProgrammerId(programmerId);
        }
        throw new AuthorizationException("Access denied!!!!!");

    }

    public TimeEntry save(TimeEntryDTO dto) {

        if(verifyAuthorizationsFromUser(dto)){
            return repository.save(TimeEntryMapper.toEntity(dto));
        }
        throw new UnauthorizedException("You don't have authorization to realize this task!");
    }

    private boolean verifyAuthorizationsFromUser(TimeEntryDTO dto) {
        UserSS user = UserSSService.authenticated();
        return TimeEntryUtils.isTheSameUser(user, dto.getProgrammerId())
        && user.hasHole(ProfileEnum.PROGRAMMER)
        && TimeEntryUtils.isTheProgrammerInList(userService.findById(user.getId()),
                projectService.findById(dto.getProjectId()));
    }
}
