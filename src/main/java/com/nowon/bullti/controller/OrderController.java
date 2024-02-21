package com.nowon.bullti.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nowon.bullti.domain.entity.member.MyUser;
import com.nowon.bullti.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {
	
	private final MemberService memberService;
	
	/*
	 * @GetMapping("/order") public String order(Authentication authentication,
	 * Model model) { MyUser myuser = (MyUser) authentication.getPrincipal();
	 * memberService.findById(myuser.getMemberNo());
	 * 
	 * System.out.println(model);
	 * 
	 * return "order/order"; }
	 */
	
	@GetMapping("/order")
	public String order() {
		return "order/order";
	}
	
	@PostMapping("/order")
	public String orderlist(@RequestParam String price) {
		System.out.println(price);
		return "order/order";
	}



}
