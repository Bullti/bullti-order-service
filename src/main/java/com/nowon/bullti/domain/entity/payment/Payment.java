package com.nowon.bullti.domain.entity.payment;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.nowon.bullti.domain.entity.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "payment")
public class Payment {
	
	@Id
	private String no;
	
	private Long totalPrice;
	
	@CreationTimestamp
	private LocalDateTime payDateTime;
	
	@Enumerated(EnumType.STRING)
	private PayMethod method;
	
	@Enumerated(EnumType.STRING)
	private PayState state;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "order_no")
	private Order order;

	
	public void changeState(PayState state) {
		this.state = state;
	}
	
}
