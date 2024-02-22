package com.nowon.bullti.domain.dto.basket;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Builder
public class BasketSaveDTO {

	private String name;
	private int price;
	private String content;
	private int count;
}
