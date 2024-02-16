package com.nowon.bullti.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.store.StoreOrderListDTO;
import com.nowon.bullti.domain.dto.store.TestProduct;
import com.nowon.bullti.service.StoreService;

@Service
public class StoreProcess implements StoreService {

	@Override
	public void list(Model model) {
		List<StoreOrderListDTO> list = new ArrayList<>();
		List<TestProduct> products = new ArrayList<>();
		for(int i=0; i<5; i++) {
			products.clear();
			for(int j=0; j<3; j++) {
				products.add(TestProduct.builder()
						.name("양념치킨"+j)
						.quantity(j+1)
						.build());
			}
			list.add(StoreOrderListDTO.builder()
					.no(i)
					.username("green"+i)
					.address("서울시 노원구 상계동 13-"+i)
					.products(products)
					.totalPrice(54000+i)
					.build());
		}
		model.addAttribute("list", list);
	}

}
