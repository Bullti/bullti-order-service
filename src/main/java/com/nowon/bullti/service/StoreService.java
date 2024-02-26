package com.nowon.bullti.service;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public interface StoreService {

	void list(Authentication auth, Model model);

}
