package com.nowon.bullti.domain.entity.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.dto.order.OrderSaveDTO;
import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;

public interface OrderRepository extends JpaRepository<Order, Long>{

	public Order save(Order order);

	public List<Order> findAllByFranchiseeNo(FranchiseEntity franchiseEntity);
	
}
