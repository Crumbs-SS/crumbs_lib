package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "restaurant_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String preferences;
    private String phone;

    private String address;

    private Date deliveryTime;
    private Date createdAt;

    @ManyToOne
    private Location location;

    @OneToOne(mappedBy = "order")
    private DriverRating driverRating;

    @OneToOne(mappedBy="order")
    private RestaurantRating restaurantRating;

    @ManyToOne
    private RestaurantStatus restaurantStatus;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private Driver driver;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private Customer customer;

    @ManyToOne
    private Payment payment;

    @ManyToOne
    private Location deliveryLocation;

    @ManyToOne
    @JsonIgnoreProperties({"menuItems", "orders"})
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("order")
    private List<FoodOrder> foodOrders = new ArrayList<>();
}
