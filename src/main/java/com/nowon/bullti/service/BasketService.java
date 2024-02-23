package com.nowon.bullti.service;

import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.domain.entity.basket.Basket;

public interface BasketService {

	void update(BasketSaveDTO dto, String memberId);

	long totalPrice(Long basketNo);
	
	//void basketList(Long MemberNo, );
	
}
