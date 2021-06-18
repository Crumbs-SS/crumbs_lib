package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select r from restaurant r where restaurant_owner_id = ?1")
    List<Restaurant> findRestaurantByOwnerID(Long id);
    String query = "SELECT DISTINCT r FROM restaurant r JOIN r.menuItems m WHERE m.restaurant.id = r.id " +
            "AND LOWER(m.name) LIKE LOWER(CONCAT('%', ?1, '%'))";

    @Query(query)
    Page<Restaurant> findRestaurantsByMenuItem(String menuItemName, Pageable pageable);

    @Query(query)
    List<Restaurant> findRestaurantsByMenuItem(String menuItemName, Sort sort);
}
