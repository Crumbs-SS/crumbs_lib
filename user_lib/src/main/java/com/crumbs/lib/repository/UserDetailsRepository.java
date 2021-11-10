package com.crumbs.lib.repository;

import com.crumbs.lib.entity.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
   String query = " AND (u.username LIKE CONCAT('%',:query,'%')" +
           " OR u.firstName LIKE CONCAT('%',:query,'%') OR u.lastName LIKE CONCAT('%',:query,'%')" +
           "OR u.email LIKE CONCAT('%',:query,'%'))";


   String admin = "SELECT u FROM UserDetails u JOIN u.admin us WHERE us IS NOT NULL" + query;
   String customer = "SELECT u FROM UserDetails u JOIN u.customer us WHERE us IS NOT NULL" + query;
   String owner = "SELECT u FROM UserDetails u JOIN u.owner us WHERE us IS NOT NULL" + query;
   String driver = "SELECT u FROM UserDetails u JOIN u.driver us WHERE us IS NOT NULL" + query;

   Optional<UserDetails> findByUsernameOrEmail(String username, String email);
   Optional<UserDetails> findByUsername(String username);
   Optional<UserDetails> findByEmail(String email);

   @Query(admin)
   Page<UserDetails> findByAdmin(Pageable pageable, String query);
   @Query(customer)
   Page<UserDetails> findByCustomer(Pageable pageable, String query);
   @Query(driver)
   Page<UserDetails> findByDriver(Pageable pageable, String query);
   @Query(owner)
   Page<UserDetails> findByOwner(Pageable pageable, String query);
}