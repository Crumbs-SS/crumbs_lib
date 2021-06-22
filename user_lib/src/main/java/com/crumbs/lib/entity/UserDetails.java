package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetails")
    @JsonManagedReference
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetails")
    @JsonManagedReference
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetails")
    @JsonManagedReference
    private Owner owner;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetails")
    @JsonManagedReference
    private Admin admin;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    @Size(min = 60, max = 60)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<Search> searches = new ArrayList<>();
}
