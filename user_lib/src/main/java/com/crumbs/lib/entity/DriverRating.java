package com.crumbs.lib.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonIgnoreProperties("orders")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="driver_id")
    @JsonIgnoreProperties("orders")
    private Driver driver;

    @JsonIgnoreProperties({"driverRating","restaurantRating", "customer", "driver"})
    @OneToOne
    private Order order;

    private int rating;
    private String description;


}