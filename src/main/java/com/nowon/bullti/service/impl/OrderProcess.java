<<<<<<< HEAD
package com.nowon.bullti.service.impl;

import org.springframework.stereotype.Service;

import com.nowon.bullti.domain.dto.order.OrderSaveDTO;
import com.nowon.bullti.domain.entity.order.OrderItemRepository;
import com.nowon.bullti.domain.entity.order.OrderRepository;
import com.nowon.bullti.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderProcess implements OrderService{

	private final OrderRepository orderRepo;
	private final OrderItemRepository orderItemRepo;
	
	@Transactional
	@Override
	public Long save(OrderSaveDTO dto) {
		Long orderNo = orderRepo.save(dto.toEntity()).getNo();
		//List<> list= busketItemRopo.findByMember();
		//list.stream
		
		
		return null;
	}

	
	
}
=======
package com.nowon.bullti.service.impl;

import org.springframework.stereotype.Service;

import com.nowon.bullti.domain.dto.order.OrderSaveDTO;
import com.nowon.bullti.domain.entity.order.OrderItemRepository;
import com.nowon.bullti.domain.entity.order.OrderRepository;
import com.nowon.bullti.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderProcess implements OrderService{

	private final OrderRepository orderRepo;
	private final OrderItemRepository orderItemRepo;
	
	@Transactional
	@Override
	public Long save(OrderSaveDTO dto) {
		Long orderNo = orderRepo.save(dto.toEntity()).getNo();
		//List<> list= busketItemRopo.findByMember();
		//list.stream
		
		
		return null;
	}

	
	
}
>>>>>>> refs/remotes/choose_remote_name/master
