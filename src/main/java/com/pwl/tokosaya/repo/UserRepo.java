package com.pwl.tokosaya.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pwl.tokosaya.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
