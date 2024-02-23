package com.nowon.bullti.domain.entity.item;

import java.util.List;

import com.nowon.bullti.domain.entity.basket.BasketItem;
import com.nowon.bullti.domain.entity.order.OrderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity {
	
	@Id
	private long no;
	
	private String name;
	private String price;
	private String content;
	private String img;
	
	@OneToMany(mappedBy = "item")
	private List<BasketItem> basket;
	
	@OneToMany(mappedBy = "item")
	private List<OrderItem> order;
}
