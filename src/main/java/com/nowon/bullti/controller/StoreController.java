package com.nowon.bullti.controller;

import org.springframework.security.core.Authentication;
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
	public String page(Authentication auth,Model model) {
		service.list(auth, model);
		return "management/views/store";
	}
	
	
	
}
