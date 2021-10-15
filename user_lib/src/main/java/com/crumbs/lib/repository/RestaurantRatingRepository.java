package com.crumbs.lib.repository;

import com.crumbs.lib.entity.DriverRating;
import com.crumbs.lib.entity.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRatingRepository extends JpaRepository<RestaurantRating, Long> {
    RestaurantRating findRestaurantRatingByOrderId(Long id);
    List<RestaurantRating> findRestaurantRatingByRestaurantId(Long id);
}
