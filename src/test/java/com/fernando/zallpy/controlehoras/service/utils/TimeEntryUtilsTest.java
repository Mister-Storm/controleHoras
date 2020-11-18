package com.fernando.zallpy.controlehoras.service.utils;

import com.fernando.zallpy.controlehoras.domain.ProfileEnum;
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
}