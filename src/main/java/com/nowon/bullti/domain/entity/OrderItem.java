package com.nowon.bullti.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "order_item")
public class OrderItem {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	private int count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_no")
	private Order order;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "item_no")
//	private List<Item> item;
}
