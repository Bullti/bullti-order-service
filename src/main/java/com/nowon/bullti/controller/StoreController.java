package com.nowon.bullti.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.bullti.service.StoreService;
import com.nowon.bullti.service.impl.OrderProcess;
import com.nowon.bullti.service.impl.StoreProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/store")
public class StoreController {

	private final StoreService service;
	private final OrderProcess orderProcess;
	
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
	
	@PostMapping
	public void orderAccep() {
		orderProcess.storeResult(null, 0);
	}
	
}
