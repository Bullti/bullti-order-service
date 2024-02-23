package com.nowon.bullti.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.basket.BasketItemDTO;
import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.domain.dto.item.ItemListDTO;
import com.nowon.bullti.domain.entity.basket.Basket;
import com.nowon.bullti.domain.entity.basket.BasketItem;
import com.nowon.bullti.domain.entity.basket.BasketItemRepository;
import com.nowon.bullti.domain.entity.basket.BasketRopository;
import com.nowon.bullti.domain.entity.item.ItemEntity;
import com.nowon.bullti.domain.entity.item.ItemEntityRepository;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.member.MemberRepository;
import com.nowon.bullti.service.BasketService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BasketProcess implements BasketService{

	private final ItemEntityRepository itemRepo;
	private final MemberRepository memberRepo;
	private final BasketRopository basketRopo;
	private final BasketItemRepository basketItemRepo;
	
	@Transactional
	@Override
	public void update(BasketSaveDTO dto, long memberNo) {
		Member member = memberRepo.findById(memberNo).orElseThrow();
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
		long totPrice = totalPrice(basket.getNo());
		basket.setAmount(totPrice);
		basketRopo.save(basket);
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

	@Transactional
	@Override
	public List<BasketItemDTO> basketlist(Model model, long MemberNo) {
		Basket basket = basketRopo.findById(MemberNo).orElseThrow();
		
		List<BasketItemDTO> list = basketItemRepo.findByBasket(basket).stream()
		.map(i -> BasketItemDTO.builder()
				.name(i.getItem().getName())
				.count(i.getCount())
				.price(i.getItem().getPrice())
				.content(i.getItem().getContent())
				.img(i.getItem().getImg())
				.build())
				.collect(Collectors.toList());
		
		model.addAttribute("list", list);
		
		return null;
	}

	@Transactional
	@Override
	public void basketlistdel(long memberNo, String ItemName) {
		ItemEntity item = itemRepo.findByName(ItemName).orElseThrow();
		basketItemRepo.deleteByBasketNoAndItem(memberNo, item);
	}

}
