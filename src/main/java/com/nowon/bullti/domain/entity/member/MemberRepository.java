package com.nowon.bullti.domain.entity.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findById(String memberId);

//	Optional<Member> findByMemberNo(long memberNo);
	
	
	
}
