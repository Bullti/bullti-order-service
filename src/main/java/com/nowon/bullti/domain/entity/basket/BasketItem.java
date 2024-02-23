<<<<<<< HEAD
package com.nowon.bullti.domain.entity.basket;

import java.util.List;

import com.nowon.bullti.domain.entity.item.ItemEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket_item")
@Entity
public class BasketItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basket_no")
	private Basket basket;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ItemEntity item;
	
	private int count;

	public void updateCnt(int cnt) {
		this.count = count+cnt;
	}
	
	
}
=======
package com.nowon.bullti.domain.entity.basket;

import java.util.List;

import com.nowon.bullti.domain.entity.item.ItemEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket_item")
@Entity
public class BasketItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basket_no")
	private Basket basket;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ItemEntity item;
	
	private int count;

	public void updateCnt(int cnt) {
		this.count = count+cnt;
	}
}
>>>>>>> refs/remotes/choose_remote_name/master
