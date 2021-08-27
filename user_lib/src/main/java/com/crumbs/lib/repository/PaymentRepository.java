package com.crumbs.lib.repository;

import com.crumbs.lib.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Long> {
    Payment findPaymentByStripeID(String stripeID);
}
