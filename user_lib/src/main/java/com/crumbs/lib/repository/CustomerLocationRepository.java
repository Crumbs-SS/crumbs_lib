package com.crumbs.lib.repository;

import com.crumbs.lib.entity.CustomerLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLocationRepository extends JpaRepository<CustomerLocation, Long> {
}
