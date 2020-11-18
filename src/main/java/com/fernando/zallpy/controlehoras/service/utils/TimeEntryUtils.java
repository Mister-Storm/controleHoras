package com.fernando.zallpy.controlehoras.service.utils;

import com.fernando.zallpy.controlehoras.domain.ProfileEnum;
import com.fernando.zallpy.controlehoras.domain.Project;
import com.fernando.zallpy.controlehoras.domain.User;
import com.fernando.zallpy.controlehoras.security.UserSS;

public class TimeEntryUtils {

    public static boolean isTheSameUser( UserSS userSS, Long programmerId){

        return userSS != null && (userSS.hasHole(ProfileEnum.ADMIN) || userSS.getId().equals(programmerId));
    }

    public static boolean isTheProgrammerInList(User user, Project project) {
        return project.getProgrammers().contains(user);
    }
}
