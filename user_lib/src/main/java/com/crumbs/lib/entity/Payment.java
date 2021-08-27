package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="stripe_id", nullable = false)
    private String stripeID;

    @Column(name="client_secret", nullable = false)
    private String clientSecret;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy="payment", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;


}
