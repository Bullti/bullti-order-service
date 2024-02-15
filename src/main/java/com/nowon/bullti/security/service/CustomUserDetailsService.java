package com.nowon.bullti.security.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nowon.bullti.domain.entity.Member;
import com.nowon.bullti.domain.entity.MemberRepository;
import com.nowon.bullti.domain.entity.MyUser;

public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) {
		
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저"));
		
		Set<SimpleGrantedAuthority> grantedAuthority = member.getMemberRoles().stream()
				.map((myRole) -> new SimpleGrantedAuthority("ROLE_" + myRole.name())).collect(Collectors.toSet());
		
		return new MyUser(member, grantedAuthority);
		
	}
	
}
