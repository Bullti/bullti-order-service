package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.service.BasketService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BasketController {

	private final BasketService basketService;

	
	/*
	 * @GetMapping("/basket") public String basket() {
	 * 
	 * return "management/views/basket"; }
	 */

	@GetMapping("/basket")
	public String basket() {

		return "basket/basket";
	}

	
	@PostMapping("/basket") 
	public String itemsave(@RequestBody BasketSaveDTO dto) {
		 //,Authentication authentication {
	  
	String MemberId = null;
	basketService.update(dto, MemberId);
	System.out.println(">>>>>>>>>>>>>>"+dto);
	  
	return "basket/basket"; 
	
	}
	 

}
