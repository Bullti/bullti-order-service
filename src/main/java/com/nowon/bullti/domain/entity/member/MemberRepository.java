<<<<<<< HEAD
package com.nowon.bullti.domain.entity.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findById(String memberId);
	
	
	
}
=======
package com.nowon.bullti.domain.entity.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findById(String memberId);
	
	
	
}
>>>>>>> refs/remotes/choose_remote_name/master
