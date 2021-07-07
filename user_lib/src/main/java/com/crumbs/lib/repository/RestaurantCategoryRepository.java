package com.crumbs.lib.repository;

import com.crumbs.lib.entity.RestaurantCategory;
import com.crumbs.lib.entity.RestaurantCategoryID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface
RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, RestaurantCategoryID> {

    @Transactional
    @Modifying
    @Query("DELETE FROM restaurant_category WHERE restaurant_id= ?1")
    void deleteByRestaurantID(Long id);

    @Modifying
    @Query(value = "INSERT INTO restaurant_category VALUES (:restaurant_id, :category_id)", nativeQuery = true)
    void insertRestaurantCategory(@Param("restaurant_id") Long restaurantID, @Param("category_id") String categoryName);
}
