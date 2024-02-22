package com.nowon.bullti.service.impl;

import org.springframework.stereotype.Service;

import com.nowon.bullti.domain.entity.item.ItemEntityRepository;
import com.nowon.bullti.service.BasketService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BasketProcess implements BasketService{

	private final ItemEntityRepository itemRepo;
	
}
