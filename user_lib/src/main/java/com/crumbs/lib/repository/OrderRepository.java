package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Customer;
import com.crumbs.lib.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByFulfilledAndCustomer(Boolean fulfilled, Customer customer);
}
