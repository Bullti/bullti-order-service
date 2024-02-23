package com.nowon.bullti.service;

import com.nowon.bullti.domain.dto.order.OrderSaveDTO;

public interface OrderService {

	public Long save(OrderSaveDTO dto);
}
