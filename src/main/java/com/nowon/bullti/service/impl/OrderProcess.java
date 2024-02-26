package com.nowon.bullti.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nowon.bullti.domain.dto.order.BuyerInfoDTO;
import com.nowon.bullti.domain.dto.order.MemberOrderDTO;
import com.nowon.bullti.domain.dto.order.OrderSaveDTO;
import com.nowon.bullti.domain.entity.basket.Basket;
import com.nowon.bullti.domain.entity.basket.BasketItem;
import com.nowon.bullti.domain.entity.basket.BasketItemRepository;
import com.nowon.bullti.domain.entity.basket.BasketRopository;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.member.MemberRepository;
import com.nowon.bullti.domain.entity.order.Order;
import com.nowon.bullti.domain.entity.order.OrderItem;
import com.nowon.bullti.domain.entity.order.OrderItemRepository;
import com.nowon.bullti.domain.entity.order.OrderRepository;
import com.nowon.bullti.domain.entity.order.OrderState;
import com.nowon.bullti.domain.entity.payment.Payment;
import com.nowon.bullti.domain.entity.payment.PaymentRepository;
import com.nowon.bullti.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderProcess implements OrderService{

	private final OrderRepository orderRepo;
	private final OrderItemRepository orderItemRepo;
	private final BasketRopository basketRopo;
	private final MemberRepository memberRepo;
	private final BasketItemRepository basketItemRepo;
	private final PaymentRepository paymentRepo;
	
	@Transactional
	@Override
	public Long save(OrderSaveDTO dto) {
		Long orderNo = orderRepo.save(dto.toEntity()).getNo();
		//List<> list= busketItemRopo.findByMember();
		//list.stream
		
		
		return null;
	}

	/**
	 * 주문하기 페이지
	 */
	@Transactional
	@Override
	public MemberOrderDTO getOrderInfo(long memberNo) {
		Basket basket = basketRopo.findById(memberNo).orElseThrow();
		int size = basket.getBasketItem().size();
		String itemName = size > 1 ?  basket.getBasketItem().get(0).getItem().getName()
				: basket.getBasketItem().get(0).getItem().getName() + " 등"+ size+ "개";
		
		return MemberOrderDTO.builder()
				.amount(basket.getAmount())
				.storeName(basket.getFran().getName())
				.tel(basket.getMember().getTel())
				.adress(basket.getMember().getAddress())
				.storeNo(basket.getFran().getNo())
				.itemName(itemName)
				.build();
	}

	/**
	 * 주문하기 페이지 구매자 정보
	 */
	@Override
	public BuyerInfoDTO getBuyerInfo(long memberNo) {
		Member member = memberRepo.findById(memberNo).orElseThrow();
		return BuyerInfoDTO.builder()
				.id(member.getId())
				.name(member.getName())
				.build();
	}

	@Transactional
	@Override
	public Long save(long memberNo) {
		Member member = memberRepo.findById(memberNo).orElseThrow();
		Basket basket = basketRopo.findById(memberNo).orElseThrow();
		Order order = Order.builder()
		.adress(member.getAddress())
		.state(OrderState.temp)
		.payment(null)
		.franchisee(basket.getFran())
		.member(member)
		.build();
		
		Order saveorder = orderRepo.save(order);
		
		List<BasketItem> basketItems = basketItemRepo.findByBasket(basket);
		for(BasketItem basketItem : basketItems) {
			OrderItem orderItem = OrderItem.builder()
			.count(basketItem.getCount())
			.item(basketItem.getItem())
			.order(saveorder)
			.build();
			
			orderItemRepo.save(orderItem);
		}
		
		return saveorder.getNo();
	}

	/**
	 * 주문 결제 완료
	 */
	@Override
	public void complete(Long orderNo, int no) {
		Order order = orderRepo.findById(orderNo).orElseThrow();
		Payment payment = paymentRepo.findByOrder(order).orElseThrow();
		if(no==1) {
			order.changeState(OrderState.progress);
			payment.succes();
		}else {
			order.changeState(OrderState.fall);
			payment.fall();
		}
		orderRepo.save(order);
		paymentRepo.save(payment);
	}

	/**
	 * 가게 승인 / 반려
	 * 승인 : 1
	 * 반려 : 0
	 */
	@Override
	public void storeResult(Long orderNo, int no) {
		Order order = orderRepo.findById(orderNo).orElseThrow();
		
		if(no == 0) {
			order.changeState(OrderState.cancle);
		}else if(no == 1) {
			order.changeState(OrderState.complate);
		}
	}

	
	
}
