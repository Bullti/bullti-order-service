package com.nowon.bullti.domain.entity.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayState {

	succes("성공"),
	temp("확인중"),
	fall("실패");
	
	private final String PayStateName;
}
