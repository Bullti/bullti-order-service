package com.nowon.bullti.domain.dto.basket;

import com.nowon.bullti.domain.entity.item.ItemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemDTO {

	private String name;
	private int count;
	private String price;
	private String content;
	private String img;
}
