package com.nowon.bullti.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@CreationTimestamp
	private LocalDateTime createdDateTime; 
	
	private LocalDateTime complatedDateTime;
	
	private String adress;
	
	@Enumerated(EnumType.STRING)
	private OrderState state;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_no")
	private Payment payment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "franchisee_no")
	private FranchiseeEntity franchisee;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem;
	
//private 가맹점
}
