package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "user_details_id", unique = true, nullable = false)
    private Long id;


    @Column(nullable = false) @Size(max = 20)
    private String phone;

    @Column(nullable = false)
    private Long loyaltyPoints;

    @Column(nullable = false)
    private String stripeId;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Location> locations;

    @ManyToOne
    private UserStatus userStatus;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_details_id")
    @JsonBackReference
    @ToString.Exclude
    private UserDetails userDetails;
}

