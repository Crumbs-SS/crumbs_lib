package com.crumbs.lib.repository;
import com.crumbs.lib.entity.DriverRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRatingRepository extends JpaRepository<DriverRating, Long> {
    DriverRating findDriverRatingByOrderId(Long id);
    List<DriverRating> findDriverRatingByDriverId(Long id);
}
