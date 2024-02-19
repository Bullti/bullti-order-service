package com.nowon.bullti.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderState {

	progress("진행중"),
	cancle("취소"),
	complate("완료");
	
	private final String stateName;
}
