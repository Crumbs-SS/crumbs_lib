package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

        @Column(nullable = false)
        private String state;

        @ManyToOne
        private UserStatus userStatus;

        @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
        private List<Order> orders;

        @OneToOne
        @MapsId
        @JoinColumn(name = "user_details_id")
        @JsonBackReference
        @ToString.Exclude
        private UserDetails userDetails;

}

