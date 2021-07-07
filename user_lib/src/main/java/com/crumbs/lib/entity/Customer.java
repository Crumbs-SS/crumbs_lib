
package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
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

    @Column(nullable = false)
    private int loyaltyPoints;

    @Column(nullable = false)
    private String stripeId;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<CustomerLocation> locations;

    @ManyToOne
    @JoinColumn(name="user_status_id")
    @JsonIgnoreProperties("customers")
    private UserStatus userStatus;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_details_id")
    @JsonManagedReference(value = "customer")
    @ToString.Exclude
    private UserDetails userDetails;
}