package com.nowon.bullti.service;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface StoreService {

	void list(Authentication auth, Model model);

	ModelAndView asynList(Authentication auth);

}
