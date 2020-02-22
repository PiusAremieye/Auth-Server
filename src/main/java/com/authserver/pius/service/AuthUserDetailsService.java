package com.authserver.pius.service;

import com.authserver.pius.model.MyUserDetails;
import com.authserver.pius.model.User;
import com.authserver.pius.repository.AuthServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private AuthServerRepository authServerRepository;

    @Autowired
    public AuthUserDetailsService(AuthServerRepository authServerRepository){
        this.authServerRepository = authServerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  authServerRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("could not find username " + username));
        return user.map(MyUserDetails::new).get();
    }
}
