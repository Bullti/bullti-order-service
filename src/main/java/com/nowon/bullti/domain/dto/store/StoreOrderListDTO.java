package com.nowon.bullti.domain.dto.store;

import java.util.List;

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
	private String username;
	private String address;
	private List<TestProduct> products;
}
