package com.nowon.bullti.domain.entity.order;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.entity.member.Member;

public interface OrderRepository extends JpaRepository<Order, Long>{

	public Order save(Order order);

	public List<Order> findAllByFranchiseeNo(long no);
	
	public List<Order> findAllByFranchiseeNoAndState(long franchiseeNo, OrderState progress);

	public List<Order> findByMemberAndStateIn(Member member, List<OrderState> states, Sort sort);
}
