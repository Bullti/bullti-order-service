package com.nowon.bullti.domain.entity.member;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class MyUser extends User{
	
	private static final long serialVersionUID = 1L;
	private long memberNo;
	private String memberName;
	
	private MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password,authorities);
		
	}
	
	public MyUser(Member member, Set<SimpleGrantedAuthority> grantedAuthority) {
		this(member.getId(), member.getPassword(), grantedAuthority);
		memberNo = member.getNo();
		memberName = member.getName();
		
	}
	
}
