package com.crumbs.lib.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    private String name;
    private double rating;
    private Integer priceRating;

    @ManyToOne
    @JsonIgnoreProperties("restaurants")
    @JoinColumn(name="owner_id")
    private Owner restaurantOwner;

    @OneToMany(mappedBy="restaurant", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems = new ArrayList<>();

    @JsonIgnoreProperties("restaurant")
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantCategory> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="restaurant_status_id")
    private RestaurantStatus restaurantStatus;
}

