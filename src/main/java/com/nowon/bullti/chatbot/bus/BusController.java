package com.nowon.bullti.chatbot.bus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class BusController {

	private final BusService service;
	
	@GetMapping("/bus")
	public String busPage(Model model) {
		service.busPageProcess(model);
		return "chatbot/main";
	}
	
	
	@PostMapping("/bus/stations")
	public String stationList(@RequestBody Coords coords, Model model) {
		//System.out.println(">>>"+coords);
		service.stationListProcess(coords, model);
		return "chatbot/station-list";
	}
}
