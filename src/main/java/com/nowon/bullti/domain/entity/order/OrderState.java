package com.nowon.bullti.domain.entity.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderState {

	progress("진행중"),
	cancle("취소"),
	temp("임시"),
	fall("주문실패"),
	complate("완료");
	
	private final String stateName;
}
