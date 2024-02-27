package com.nowon.bullti.chatbot.bus;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


public interface BusService {

	ModelAndView stationListProcess(Coords coords);

	void busPageProcess(Model model);

	ModelAndView stationListProcess(Coords coords, Model model);

}
