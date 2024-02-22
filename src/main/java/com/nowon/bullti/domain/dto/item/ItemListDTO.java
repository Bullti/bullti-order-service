package com.nowon.bullti.domain.dto.item;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Builder
public class ItemListDTO {

	private String name;
	private String price;
	private String content;
	private String img;
}
