package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BasketController {
	
	//private final BasketService listService;
	
	@GetMapping("/basket")
	public String basket() {
		
		return "management/views/basket";
	}
	
	
	
	@PostMapping("/basket")
	public String itemsave(@RequestBody BasketSaveDTO dto)
			//,Authentication authentication
	{
		
		System.out.println(">>>>>>>>>>>>>>"+dto.getName());
		System.out.println(">>>>>>>>>>>>>>"+dto);
		
		return "basket/basket";
	}
	

	
}
