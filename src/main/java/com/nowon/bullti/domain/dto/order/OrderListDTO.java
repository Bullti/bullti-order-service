package com.nowon.bullti.domain.dto.order;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDTO {

	Long orderNo;
	String storeName;
	String itemName;
	String tot;
	LocalDateTime orderDateTime;
	String orderState;
}
