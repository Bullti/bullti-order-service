package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

	
	@GetMapping("/order/list")
	public String orderList() {
		return "/order/list";
	}
	
	@GetMapping("/my")
	public String my() {
		return "/my";
	}
	
	@GetMapping("/order/detail")
	public String orderDetail() {
		return "/order/detail";
	}
}
