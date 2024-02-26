package com.nowon.bullti.service;

import com.nowon.bullti.domain.dto.order.BuyerInfoDTO;
import com.nowon.bullti.domain.dto.order.MemberOrderDTO;
import com.nowon.bullti.domain.dto.order.OrderSaveDTO;

public interface OrderService {

	public void save(OrderSaveDTO dto);

	// 주문하기 페이지 유저 정보
	public MemberOrderDTO getOrderInfo(long memberNo);

	// 주문하기 페이지 구매자 정보
	public BuyerInfoDTO getBuyerInfo(long memberNo);

	public Long save(long memberNo);

	// 주문:결제 완료
	public void complete(Long orderNo, int no);
	
	public void storeResult(Long orderNo, int no);
}
