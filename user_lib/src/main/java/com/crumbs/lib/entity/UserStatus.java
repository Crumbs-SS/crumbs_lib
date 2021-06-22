package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserStatus {

    @Id
    private String status;

    @OneToMany(mappedBy = "userStatus")
    @JsonIgnore
    private List<Admin> admins;

    @OneToMany(mappedBy = "userStatus")
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(mappedBy = "userStatus")
    @JsonIgnore
    private List<Owner> owners;

    @OneToMany(mappedBy = "userStatus")
    @JsonIgnore
    private List<Driver> drivers;
}
