package com.nowon.bullti.domain.entity.order;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.nowon.bullti.domain.entity.franchisee.FranchiseeEntity;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.payment.Payment;

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
@Table(name = "orders")
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_no")
	private Member member;
	
//private 가맹점
}
