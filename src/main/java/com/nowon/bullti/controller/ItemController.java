package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nowon.bullti.service.ItemService;
import com.nowon.bullti.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemController {
	
	private final ItemService itemService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		itemService.list(model);

		return "list/list";
	}
	

}