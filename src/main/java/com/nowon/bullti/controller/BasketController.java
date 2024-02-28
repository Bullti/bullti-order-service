package com.nowon.bullti.controller;

import java.util.Map;

import org.hibernate.bytecode.spi.ReflectionOptimizer.AccessOptimizer;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nowon.bullti.domain.dto.basket.BasketMapDTO;
import com.nowon.bullti.domain.dto.basket.BasketSaveDTO;
import com.nowon.bullti.domain.dto.order.MemberOrderDTO;
import com.nowon.bullti.domain.dto.storelist.StoreListDTO;
import com.nowon.bullti.service.BasketService;
import com.nowon.bullti.service.OrderService;
import com.nowon.bullti.utils.AuthenUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BasketController {

	private final BasketService basketService;
	
	@PostMapping("/basket") 
	public String itemsave(@RequestBody BasketSaveDTO dto, Authentication authentication) {
	long MemberNo = AuthenUtils.extractMemberNo(authentication);
	
	basketService.update(dto, MemberNo);
	 
	return "basket/basket"; 
	
	} 
	
	@GetMapping("/basket")
	public String basketlist(Model model, Authentication authentication) {
		long MemberNo = AuthenUtils.extractMemberNo(authentication);
		
		basketService.basketlist(model, MemberNo);
		basketService.basketInfo(model, MemberNo);
		
		return "basket/basket";
	}
	 
	@ResponseBody
	@DeleteMapping("/basket")
	public void basketlistdel(@RequestBody Map<String, Object> data, Authentication authentication) {
		long MemberNo = AuthenUtils.extractMemberNo(authentication);
		String itemName = (String)data.get("name");
		basketService.basketlistdel(MemberNo, itemName);
	}
	 
	
	@ResponseBody
	@PostMapping("/basket/store") 
	public void mapSelect(@RequestParam(name = "storeNo") long storeNo, Authentication authentication) {
		long MemberNo = AuthenUtils.extractMemberNo(authentication);
		basketService.updateMap(storeNo, MemberNo);
		
	} 
	
}
