package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Customer;
import com.crumbs.lib.entity.Order;
import com.crumbs.lib.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findOrderByOrderStatusAndCustomer(OrderStatus orderStatus, Customer customer, Pageable pageable);
}
