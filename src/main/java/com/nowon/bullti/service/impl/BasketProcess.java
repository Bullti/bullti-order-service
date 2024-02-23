package com.nowon.bullti.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.domain.entity.basket.Basket;
import com.nowon.bullti.domain.entity.basket.BasketItem;
import com.nowon.bullti.domain.entity.basket.BasketItemRepository;
import com.nowon.bullti.domain.entity.basket.BasketRopository;
import com.nowon.bullti.domain.entity.item.ItemEntity;
import com.nowon.bullti.domain.entity.item.ItemEntityRepository;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.member.MemberRepository;
import com.nowon.bullti.service.BasketService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BasketProcess implements BasketService{

	private final ItemEntityRepository itemRepo;
	private final MemberRepository memberRepo;
	private final BasketRopository basketRopo;
	private final BasketItemRepository basketItemRepo;
	
	@Override
	public void update(BasketSaveDTO dto, String memberId) {
		Member member = memberRepo.findById(memberId).orElseThrow();
		Basket basket = basketRopo.findById(member.getNo()).orElseThrow();
		ItemEntity item = itemRepo.findByName(dto.getName()).orElseThrow();
		boolean flag = basketItemRepo.existsByBasketAndItem(basket, item);
		
		if(flag) {
			BasketItem basketItem = basketItemRepo.findByBasketAndItem(basket, item).orElseThrow();
			basketItem.updateCnt(dto.getCount());
			basketItemRepo.save(basketItem);
		}else {
			BasketItem basketItem = BasketItem.builder()
					.count(dto.getCount())
					.item(item)
					.basket(basket)
					.build();
			basketItemRepo.save(basketItem);
		}
	}

	@Override
	public long totalPrice(Long basketNo) {
		Basket basket = basketRopo.findById(basketNo).orElseThrow();
		List<BasketItem> basketList = basketItemRepo.findByBasket(basket);
		long tot = 0;
		for(BasketItem item : basketList) {
			tot += Long.valueOf(item.getItem().getPrice()) * item.getCount();
		}
		return tot;
	}

}
