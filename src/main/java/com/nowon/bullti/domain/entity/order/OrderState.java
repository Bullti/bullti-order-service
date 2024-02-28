package com.nowon.bullti.domain.entity.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderState {

	progress("가맹점 확인중"),
	cancle("가맹점 주문취소"),
	temp("임시"),
	fall("주문실패"),
	complate("가맹점 확인완료");
	
	private final String stateName;
}
