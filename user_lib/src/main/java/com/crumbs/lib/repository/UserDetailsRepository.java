package com.crumbs.lib.repository;

import com.crumbs.lib.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByUsernameOrEmail(String username, String email);
    Optional<UserDetails> findByUsername(String username);
}