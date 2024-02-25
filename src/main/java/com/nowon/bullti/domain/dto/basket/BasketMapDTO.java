package com.nowon.bullti.domain.dto.basket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketMapDTO {

	private String storeName;
	private String address;
	private String locationDetail;
	private String phone;
	
}
