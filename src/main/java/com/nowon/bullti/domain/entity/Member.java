package com.nowon.bullti.domain.entity;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_no")
	private long no;
	
	@Column(nullable = false, unique = true)
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	private String tel;
	
	private String address;
	
	//가입일
	private LocalDate createAt;
	
	//정보수정일
	private LocalDate updateAt;
	
	//탈퇴일
	private LocalDate deleteAt;
	
	//권한
	@Builder.Default
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "member_role")
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> memberRoles = new HashSet<>();

	public Member addRole(Role role) {
		memberRoles.add(role);
		return this;
	}
	
	public void setPassword(String password) {
	       this.password = password;
	   }
	
	
}
