package com.crumbs.lib.repository;

import com.crumbs.lib.entity.DriverState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverStateRepository extends JpaRepository<DriverState, String> {
}
