package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.service.ItemService;
import com.nowon.bullti.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemController {
	
	private final ItemService itemService;
	
	@GetMapping("/items")
	public String list(Model model) {
		
		itemService.list(model);

		return "list/list";
	}
	
	@PostMapping("/list")
	public String itemsave(@RequestBody BasketSaveDTO dto)
			//,Authentication authentication
	{
		
		System.out.println(">>>>>>>>>>>>>>"+dto);
		
		return "basket/basket";
	}

}
