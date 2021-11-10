package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal longitude;
    private BigDecimal latitude;
    private String address;

    @JsonIgnore
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private Restaurant restaurant;

    @OneToMany(mappedBy="deliveryLocation", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;
}
