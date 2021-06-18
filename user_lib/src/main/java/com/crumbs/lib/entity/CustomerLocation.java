package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLocation {

    @EmbeddedId
    private CustomerLocationID id;

    @MapsId("customerID")
    @ManyToOne
    @JsonIgnore
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
