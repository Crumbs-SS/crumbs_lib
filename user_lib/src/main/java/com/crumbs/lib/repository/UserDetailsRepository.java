package com.crumbs.lib.repository;

import com.crumbs.lib.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByUsernameOrEmail(String username, String email);
    Optional<UserDetails> findByUsername(String username);
}