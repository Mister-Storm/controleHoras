package com.fernando.zallpy.controlehoras.service.utils;

import com.fernando.zallpy.controlehoras.domain.ProfileEnum;
import com.fernando.zallpy.controlehoras.domain.Project;
import com.fernando.zallpy.controlehoras.domain.User;
import com.fernando.zallpy.controlehoras.security.UserSS;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TimeEntryUtilsTest {

    @Test
    public void should_retun_true_when_same_user(){
        Set<ProfileEnum> profiles = new HashSet<>();
        profiles.add(ProfileEnum.PROGRAMMER);
        UserSS user = new UserSS(1L, "fulano@123.com", "123", profiles);
        assertTrue(TimeEntryUtils.isTheSameUser(user,1L));
    }

    @Test
    public void should_retun_false_when_not_same_user(){
        Set<ProfileEnum> profiles = new HashSet<>();
        profiles.add(ProfileEnum.PROGRAMMER);
        UserSS user = new UserSS(1L, "fulano@123.com", "123", profiles);
        assertFalse(TimeEntryUtils.isTheSameUser(user,2L));
    }

    @Test
    public void should_retun_true_when_admin_user(){
        Set<ProfileEnum> profiles = new HashSet<>();
        profiles.add(ProfileEnum.ADMIN);
        UserSS user = new UserSS(1L, "fulano@123.com", "123", profiles);
        assertTrue(TimeEntryUtils.isTheSameUser(user,2L));
    }

    @Test
    public void should_retun_false_when_user_is_null(){
        UserSS user = null;
        assertFalse(TimeEntryUtils.isTheSameUser(user,2L));
    }

    @Test
    public void should_retun_true_when_admin_and_same_user(){
        Set<ProfileEnum> profiles = new HashSet<>();
        profiles.add(ProfileEnum.ADMIN);
        UserSS user = new UserSS(1L, "fulano@123.com", "123", profiles);
        assertTrue(TimeEntryUtils.isTheSameUser(user,1L));
    }

    @Test
    public void should_return_true_when_user_in_list() {
        Project project = new Project();
        User programmer = new User();
        programmer.setEmail("fulano@123.com");
        programmer.setIdUser(1L);
        programmer.setName("fulano");
        Set<User> programmers = createProgrammers();
        programmers.add(programmer);
        project.setProgrammers(programmers);
        assertTrue(TimeEntryUtils.isTheProgrammerInList(programmer, project));
    }

    @Test
    public void should_return_false_when_user_not_in_list() {
        Project project = new Project();
        User programmer = new User();
        programmer.setEmail("fulano@123.com");
        programmer.setIdUser(1L);
        programmer.setName("fulano");
        Set<User> programmers = createProgrammers();
        project.setProgrammers(programmers);
        assertFalse(TimeEntryUtils.isTheProgrammerInList(programmer, project));
    }

    private Set<User> createProgrammers() {

        Set<User> programmers = new HashSet<>();
        for(int i=2; i<10; i++) {
            User programmer = new User();
            programmer.setEmail("fulano" +i+"@123.com");
            programmer.setIdUser((long) i);
            programmer.setName("fulano" +i);
            programmers.add(programmer);
        }
        return programmers;
    }
}