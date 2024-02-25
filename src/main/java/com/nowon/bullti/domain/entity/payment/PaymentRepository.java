package com.nowon.bullti.domain.entity.payment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.entity.order.Order;

public interface PaymentRepository extends JpaRepository<Payment, String>{

	Optional<Payment> findByOrder(Order order);
}
