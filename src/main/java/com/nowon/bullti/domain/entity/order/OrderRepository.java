package com.nowon.bullti.domain.entity.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.dto.order.OrderSaveDTO;

public interface OrderRepository extends JpaRepository<Order, Long>{

	public Order save(Order order);
	
}
