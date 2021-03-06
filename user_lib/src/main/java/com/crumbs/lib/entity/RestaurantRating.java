package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RestaurantRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    @JsonIgnoreProperties({"orders", "menuItems"})
    private Restaurant restaurant;

    @OneToOne
    @JsonIgnoreProperties({"restaurantRating","driverRating", "restaurant"})
    private Order order;

    private int rating;
    private String description;

}
