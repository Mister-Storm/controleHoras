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
import java.util.stream.Collectors;


@Service
public class TimeEntryService {

    private final String ERROR_MESSAGE="You don't have authorization to realize this task! Please contact the system manager";

    @Autowired
    private TimeEntryRepository repository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    public List<TimeEntryDTO> findAll() {
        return repository.findAll().stream().map(timeEntry ->
                TimeEntryMapper.toDTO(timeEntry)).collect(Collectors.toList());
    }

    public List<TimeEntryDTO> findAllForProgrammer(Long programmerId) {
        User user = new User();
        user.setId(programmerId);
        UserSS userSS = UserSSService.authenticated();
        if (TimeEntryUtils.isTheSameUser(userSS, programmerId)
        || userSS.hasHole(ProfileEnum.ADMIN)) {
            return repository.findAllByProgrammer(user).stream().map(timeEntry ->
                    TimeEntryMapper.toDTO(timeEntry)).collect(Collectors.toList());
        }
        throw new AuthorizationException(ERROR_MESSAGE);

    }

    public TimeEntry save(TimeEntryDTO dto) {

        if(verifyAuthorizationsFromUser(dto)){
            return repository.save(TimeEntryMapper.toEntity(dto));
        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    private boolean verifyAuthorizationsFromUser(TimeEntryDTO dto) {
        UserSS user = UserSSService.authenticated();
        return TimeEntryUtils.isTheSameUser(user, dto.getProgrammerId())
        && user.hasHole(ProfileEnum.PROGRAMMER)
        && TimeEntryUtils.isTheProgrammerInList(userService.findById(user.getId()),
                projectService.findById(dto.getProjectId()));
    }
}
