package com.nowon.bullti.domain.dto.store;

import java.util.List;

import com.nowon.bullti.domain.entity.order.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StoreOrderListDTO {

	private long no;
	private String address;
	private String state;
	private List<OrderItem> orderItem;
	private int totalPrice;
	private String userName;
	
}
