package com.crumbs.lib.repository;

import com.crumbs.fss.entity.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Long> {
}
