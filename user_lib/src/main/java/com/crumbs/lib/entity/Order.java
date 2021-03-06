package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
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

    private String phone;
    private String preferences;
    private Timestamp deliverySlot;
    private Timestamp createdAt;
    private Timestamp pickedUpAt;
    private Timestamp deliveredAt;
    private String deliveryDistance;
    private String deliveryTime;
    private Float deliveryPay;

    @OneToOne(mappedBy = "order")
    private DriverRating driverRating;

    @OneToOne(mappedBy="order")
    private RestaurantRating restaurantRating;

    @ManyToOne
    @JoinColumn(name="status_id")
    private OrderStatus orderStatus;

    @ManyToOne
    @JsonIgnoreProperties(value = {"orders"})
    @JoinColumn(name="driver_id")
    private Driver driver;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders")
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="payment_id", referencedColumnName = "id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="delivery_location")
    private Location deliveryLocation;

    @ManyToOne
    @JsonIgnoreProperties(value = {"menuItems", "orders", "restaurantOwner"})
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "order")
    private List<FoodOrder> foodOrders = new ArrayList<>();
}
