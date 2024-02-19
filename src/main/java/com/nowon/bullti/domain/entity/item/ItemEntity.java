package com.nowon.bullti.domain.entity.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class ItemEntity {
	
	@Id
	private long no;
	
	private String name;
	private String price;
	private String content;
	private String img;
}
