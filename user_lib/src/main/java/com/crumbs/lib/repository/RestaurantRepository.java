package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, JpaSpecificationExecutor<Restaurant> {

    @Query("select r from restaurant r where owner_id = ?1")
    List<Restaurant> findRestaurantByOwnerID(Long id);

    String query = "SELECT DISTINCT r FROM restaurant r JOIN r.menuItems m WHERE m.restaurant.id = r.id " +
            "AND LOWER(m.name) LIKE LOWER(CONCAT('%', ?1, '%'))";

    @Query(query)
    Page<Restaurant> findRestaurantsByMenuItem(String menuItemName, Pageable pageable);

    @Query(query)
    List<Restaurant> findRestaurantsByMenuItem(String menuItemName, Sort sort);


    @Query( value = "SELECT *, (3959*\n" +
            "acos(cos(radians(?1))*\n" +
            "cos(radians(latitude))*\n" +
            "cos(radians(longitude)-\n" +
            "radians(?2))+\n" +
            "sin(radians(?1))*\n" +
            "sin(radians(latitude)))) AS distance\n" +
            "FROM Restaurant ro\n" +
            "JOIN Location l ON ro.location_id=l.id\n" +
            "HAVING distance<?3",
            countQuery = "SELECT (*) FROM RESTAURANT",
            nativeQuery = true)

    Page<Restaurant> findRestaurantsByLocation(
            BigDecimal lat,
            BigDecimal lng,
            Integer maxDistance,
            Pageable pageable);
}
