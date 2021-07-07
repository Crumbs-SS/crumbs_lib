package com.crumbs.lib.repository;


import com.crumbs.lib.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("select street from location where street = ?1")
    String findLocationByStreet(String street);
}
