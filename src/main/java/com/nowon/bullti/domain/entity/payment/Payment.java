package com.nowon.bullti.domain.entity.payment;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.nowon.bullti.domain.entity.order.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	private Long totalPrice;
	
	@CreationTimestamp
	private LocalDateTime payDateTime;
	
	@Enumerated(EnumType.STRING)
	private PayMethod method;
	
	@OneToOne(mappedBy = "payment")
	private Order order;
}