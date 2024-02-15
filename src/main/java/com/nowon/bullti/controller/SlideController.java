package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SlideController {

	@GetMapping("/slide")
	public String slide() {
		return "slide/slide";
	}
}
