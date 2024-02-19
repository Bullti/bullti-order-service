package com.nowon.bullti.domain.entity.basket;

import java.util.List;

import com.nowon.bullti.domain.entity.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket")
@Entity
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@OneToOne(mappedBy = "basket")
	private Member member;
	
	@OneToMany(mappedBy = "basket")
	private List<BasketItem> basketItem;
}
