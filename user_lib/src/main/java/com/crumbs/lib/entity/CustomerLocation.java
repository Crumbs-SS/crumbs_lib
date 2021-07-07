package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CustomerLocation {

    @EmbeddedId
    private CustomerLocationID id;

    @MapsId("customerID")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="customer_id")
    private Customer customer;

    @MapsId("locationID")
    @ManyToOne
    @JsonIgnore
    private Location location;

    public CustomerLocation(Customer customer, Location location) {
        this.customer = customer;
        this.location = location;
        this.id = new CustomerLocationID(customer.getId(), location.getId());
    }


}
