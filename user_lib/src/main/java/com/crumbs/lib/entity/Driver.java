package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

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



        @OneToOne
        @MapsId
        @JoinColumn(name = "user_details_id")
        @JsonBackReference
        @ToString.Exclude
        private UserDetails userDetails;

}

