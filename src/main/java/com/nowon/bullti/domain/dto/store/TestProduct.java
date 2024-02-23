package com.nowon.bullti.domain.dto.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TestProduct {
	private String name;
	private int quantity;
	private int price;
}
