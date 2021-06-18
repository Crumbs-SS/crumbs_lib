package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    private String phone;

    @ManyToOne
    private UserStatus userStatus;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_details_id")
    @JsonBackReference
    @ToString.Exclude
    private UserDetails userDetails;
}

