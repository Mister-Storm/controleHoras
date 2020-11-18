package com.fernando.zallpy.controlehoras.service;

import com.fernando.zallpy.controlehoras.domain.User;
import com.fernando.zallpy.controlehoras.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException(User.class, "User"));
    }
}
