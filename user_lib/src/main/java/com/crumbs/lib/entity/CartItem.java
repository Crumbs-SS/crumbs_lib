package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String preferences;

    @ManyToOne
    private MenuItem menuItem;

    @ManyToOne
    @JsonIgnoreProperties({"cartItems", "orders"})
    private Customer customer;
}
