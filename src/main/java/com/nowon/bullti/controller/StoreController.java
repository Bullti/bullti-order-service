package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nowon.bullti.service.StoreService;
import com.nowon.bullti.service.impl.StoreProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/store")
public class StoreController {

	private final StoreService service;
	
	@GetMapping
	public String page(Model model) {
		service.list(model);
		return "management/views/store";
	}
	
}
