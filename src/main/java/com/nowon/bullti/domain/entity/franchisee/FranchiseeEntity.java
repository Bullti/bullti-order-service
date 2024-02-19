package com.nowon.bullti.domain.entity.franchisee;

import java.util.List;

import com.nowon.bullti.domain.entity.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "franchisee")
@Entity
public class FranchiseeEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String location;
	private String locationDetail;
	@Column(nullable = false)
	private String phone;
	private long member_no;
	
	@OneToMany(mappedBy = "franchisee")
	private List<Order> order;
}
