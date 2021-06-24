package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @Column(name = "user_details_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_status_id")
    @JsonIgnoreProperties("admins")
    private UserStatus userStatus;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_details_id")
    @JsonManagedReference
    @ToString.Exclude
    private UserDetails userDetails;
}


