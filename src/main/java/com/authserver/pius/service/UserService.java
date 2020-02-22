package com.authserver.pius.service;

import com.authserver.pius.model.User;
import com.authserver.pius.repository.AuthServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private AuthServerRepository authServerRepository;

    @Autowired
    public UserService(AuthServerRepository authServerRepository, PasswordEncoder passwordEncoder){
        this.authServerRepository = authServerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User user){
        System.out.println("create");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authServerRepository.save(user);
    }
}
