package com.crumbs.lib.repository;

import com.crumbs.lib.entity.Customer;
import com.crumbs.lib.entity.Driver;
import com.crumbs.lib.entity.Order;
import com.crumbs.lib.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    Page<Order> findOrderByOrderStatusAndCustomer(OrderStatus orderStatus, Customer customer, Pageable pageable);
    Page<Order> findOrderByOrderStatus(OrderStatus orderStatus, Pageable pageable);
    List<Order> findOrderByOrderStatus(OrderStatus orderStatus);

    @Query("select o from restaurant_order o where o.driver.userDetails.username = ?1 and o.orderStatus.status = 'DELIVERING'")
    List<Order> findDriverAcceptedOrder(String username);

}




