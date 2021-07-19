package com.crumbs.lib.repository;


import com.crumbs.lib.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("select d from Driver d where d.state.state = ?1 and d.userDetails.username like ?2%")
    Page<Driver> findAllByStatusAndSearchString(String status, String searchString, Pageable pageable);

    @Query("select d from Driver d where d.userDetails.username like ?1%")
    Page<Driver> findAllBySearchString(String searchString, Pageable pageable);

    @Query("select d from Driver d where d.state.state = ?1")
    Page<Driver> findAllByStatus(String status, Pageable pageable);
}
