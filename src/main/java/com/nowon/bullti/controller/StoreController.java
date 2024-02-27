package com.nowon.bullti.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.bullti.domain.dto.store.OrderStateDTO;
import com.nowon.bullti.service.OrderService;
import com.nowon.bullti.service.StoreService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/store")
public class StoreController {

	private final StoreService service;
	private final OrderService orderService;
	
	@GetMapping
	public String page(Authentication auth,Model model) {
		service.list(auth, model);
		return "management/views/store";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public ModelAndView list(Authentication auth) {
		return service.asynList(auth);
	}
	
	@ResponseBody
	@PostMapping
	public void orderAccep(@RequestBody OrderStateDTO dto) {
		orderService.storeResult(dto.getOrderNo(), dto.getAction());
	}
	
}
