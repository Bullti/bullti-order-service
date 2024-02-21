package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListController {

	@GetMapping("/list")
	public String slide() {
		return "list/list";
	}
	

	@PostMapping("/list")
	public String list() {
		
		return "order/order";
	}
}
