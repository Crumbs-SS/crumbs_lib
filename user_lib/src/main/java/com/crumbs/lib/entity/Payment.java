package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;

    @Column(name="stripe_id")
    private String stripeID;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean isValid;

    @OneToMany(mappedBy = "payment")
    @JsonIgnore
    private List<Order> orders;
}
