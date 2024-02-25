package com.nowon.bullti.domain.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberOrderDTO {
	
	private long amount;
	private String storeName;
	private String tel;
	private String adress;
}
