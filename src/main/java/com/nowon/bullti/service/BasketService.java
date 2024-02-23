package com.nowon.bullti.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.basket.BasketItemDTO;
import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.domain.entity.basket.Basket;

public interface BasketService {

	void update(BasketSaveDTO dto, long memberNo);

	long totalPrice(Long basketNo);

	List<BasketItemDTO> basketlist(Model model, long MemberNo);

	void basketlistdel(long memberNo, String ItemName);
	
	//void basketList(Long MemberNo, );
	
}
