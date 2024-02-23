package com.nowon.bullti.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.item.ItemListDTO;
import com.nowon.bullti.domain.entity.item.ItemEntityRepository;
import com.nowon.bullti.service.ItemService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ItemProcess implements ItemService{

	private final ItemEntityRepository itemRepo;
	
	
	@Override
	public void list(Model model) {
		
		List<ItemListDTO> dto = itemRepo.findAll().stream()
								.map(ItemEntity -> ItemListDTO.builder()
															  .name(ItemEntity.getName())
															  .price(ItemEntity.getPrice())
															  .img(ItemEntity.getImg())
															  .content(ItemEntity.getContent())
															  .build()).collect(Collectors.toList());
		
		model.addAttribute("list",dto);
		
	}

}
