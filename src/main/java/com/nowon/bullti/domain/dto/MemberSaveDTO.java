package com.nowon.bullti.domain.dto;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.member.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberSaveDTO {
	
	private String id;
	private String name;
	private String tel;
	private String address;
	private LocalDate joinDate;
	private String password;
	
	public Member toEntity(PasswordEncoder passwordEncoder) {
		
		return Member.builder()
				.id(id)
				.password(passwordEncoder.encode(password))
				.name(name)
				.tel(tel)
				.address(address)
				.createAt(joinDate)
				.build().addRole(Role.USER);
	}
	
	
}
