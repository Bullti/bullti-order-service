package com.nowon.bullti.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.bullti.aspect.LogPerf;
import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;
import com.nowon.bullti.domain.entity.franchise.FranchiseRepository;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.member.MemberRepository;
import com.nowon.bullti.domain.entity.order.Order;
import com.nowon.bullti.domain.entity.order.OrderRepository;
import com.nowon.bullti.domain.entity.order.OrderState;
import com.nowon.bullti.service.StoreService;
import com.nowon.bullti.utils.AuthenUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreProcess implements StoreService {
	
	private final FranchiseRepository franchiseRepository;
	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;

	@Override
	public void list(Authentication auth, Model model) {
		model.addAttribute("storeStatus", franchiseRepository.findByMemberNo(memberRepository.findById(AuthenUtils.extractMemberNo(auth)).get()).get());
	}

	@LogPerf
	@Override
	public ModelAndView asynList(Authentication auth) {
		long memberNo = AuthenUtils.extractMemberNo(auth);
		Member memberEntity = memberRepository.findById(memberNo).get();
		FranchiseEntity franchiseEntity = franchiseRepository.findByMemberNo( memberEntity ).get();
		List<Order> orderList = orderRepository.findAllByFranchiseeNoAndState(franchiseEntity.getNo(), OrderState.progress);

		return new ModelAndView("management/views/list").addObject("orderList", 
				orderList.stream().map(Order::toStoreOrderListDTO).collect(Collectors.toList()));
//		return new ModelAndView("management/views/list").addObject("orderList",createTestData() );
	}
	
	/*
	private List<StoreOrderListDTO> createTestData() {

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
		return list;
	} */
}
