package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

public class RestaurantRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Driver driver;

    @JsonIgnoreProperties("restaurant_rating")
    @OneToOne
    private Order order;

    private Float rating;
    private String description;

}
