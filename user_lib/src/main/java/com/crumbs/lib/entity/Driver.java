package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
        @Id
        @Column(name = "user_details_id", unique = true, nullable = false)
        private Long id;


        @Column(nullable = false) @Size(max = 30)
        private String licenseId;

        @JoinColumn(name="state_id")
        @ManyToOne
        @JsonIgnoreProperties("drivers")
        private DriverState state;

        @ManyToOne
        @JoinColumn(name="status_id")
        @JsonIgnoreProperties("drivers")
        private UserStatus userStatus;

        @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
        private List<Order> orders;

        @OneToOne
        @MapsId
        @JoinColumn(name = "user_details_id")
        @JsonIgnoreProperties(value = {"driver", "customer"})
        @ToString.Exclude
        private UserDetails userDetails;

        private Float totalPay;

}

