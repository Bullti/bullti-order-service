package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class IndexController {

	@GetMapping("/")
	public String indexPage(
			@RequestParam(name = "error_code", required = false) String error_code,
			@RequestParam(name = "error_msg", required = false) String error_msg,
			Model model
			) {
		
		model.addAttribute("error_code", error_code);
		model.addAttribute("error_msg", error_msg);
		
		return "index";
	}
	
	@GetMapping("/my")
	public String myPage() {
		return "/my";
	}
	
}
