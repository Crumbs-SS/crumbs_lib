package com.crumbs.lib.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class RestaurantStatus {

    @Id
    private String status;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Restaurant> restaurants;

}
