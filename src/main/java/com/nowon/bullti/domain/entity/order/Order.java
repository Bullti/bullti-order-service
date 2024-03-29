package com.nowon.bullti.domain.entity.order;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.nowon.bullti.domain.dto.store.StoreOrderListDTO;
import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;
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
	
	
	@OneToOne(mappedBy = "order")
	private Payment payment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "franchisee_no")
	private FranchiseEntity franchisee;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderItem> orderItem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_no")
	private Member member;

	public void changeState(OrderState state) {
		this.state = state;
	}
	
	public StoreOrderListDTO toStoreOrderListDTO() {
		int totalPrice = orderItem.stream().mapToInt( orderItem->Integer.valueOf(orderItem.getItem().getPrice()) ).sum();
		return StoreOrderListDTO.builder()
				.no(no)
				.address(adress)
				.state(state.getStateName())
				.orderItem(orderItem)
				.totalPrice(totalPrice)
				.userName(member.getId())
				.build();
	}

}
