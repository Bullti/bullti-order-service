package com.nowon.bullti.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nowon.bullti.domain.dto.MemberSaveDTO;
import com.nowon.bullti.domain.entity.basket.Basket;
import com.nowon.bullti.domain.entity.basket.BasketRopository;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.member.MemberRepository;
import com.nowon.bullti.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberProcess implements MemberService{
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final BasketRopository basketRopository;
	
	@Transactional
	@Override
	public void saveMember(MemberSaveDTO memberSaveDTO) {
	    Member member = memberSaveDTO.toEntity(passwordEncoder);
	    Basket basket = Basket.builder().member(member).build(); 
	    
	    basketRopository.save(basket);
	    memberRepository.save(member);
	    
	}


}
