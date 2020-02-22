package com.authserver.pius.repository;

import com.authserver.pius.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AuthServerRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
