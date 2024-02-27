package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nowon.bullti.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemController {
	
	private final ItemService itemService;
	
	@GetMapping("/items")
	public String list(Model model) {
		
		itemService.list(model);

		return "items/list";
	}
	
}
