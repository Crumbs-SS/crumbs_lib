package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    @Column(name = "user_details_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_status_id")
    @JsonIgnoreProperties("owners")
    private UserStatus userStatus;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_details_id")
    @JsonBackReference
    @ToString.Exclude
    private UserDetails userDetails;

    @OneToMany(mappedBy="restaurantOwner", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
}


