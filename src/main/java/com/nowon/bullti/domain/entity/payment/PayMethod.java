package com.nowon.bullti.domain.entity.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayMethod {

	kakaopay("카카오페이");
	
	private final String payMethodName; 
}
