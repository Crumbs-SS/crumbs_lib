package com.crumbs.lib.repository;

import com.crumbs.lib.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByUsernameOrEmail(String username, String email);
    Optional<UserDetails> findByUsername(String username);
    Optional<UserDetails> findByEmail(String email);

    Page<UserDetails> findByRole(Pageable pageable, String role);
}