
package com.crumbs.lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {
    @Id
    private String status;

    @OneToMany(mappedBy="orderStatus", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("orderStatus")
    private List<Order> orders;
}