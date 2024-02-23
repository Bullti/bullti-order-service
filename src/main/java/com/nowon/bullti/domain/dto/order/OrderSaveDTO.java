package com.nowon.bullti.domain.dto.order;

import com.nowon.bullti.domain.entity.order.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderSaveDTO {

	private String temp;
	
	public Order toEntity() {
		return Order.builder()
				.adress(temp)
				.build();
	}
}
