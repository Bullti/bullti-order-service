package com.nowon.bullti.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
