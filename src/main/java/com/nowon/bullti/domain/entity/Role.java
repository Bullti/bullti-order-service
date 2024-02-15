package com.nowon.bullti.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

	USER("일반유저"),
	STORE("가맹점");
	
	private final String roleName;
	
	
}
