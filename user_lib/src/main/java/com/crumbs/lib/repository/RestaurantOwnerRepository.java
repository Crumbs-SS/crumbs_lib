package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantOwnerRepository extends JpaRepository<Owner, Long> {
}
