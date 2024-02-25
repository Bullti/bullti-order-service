package com.nowon.bullti.domain.entity.basket;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;

import jakarta.transaction.Transactional;

public interface BasketRopository extends JpaRepository<Basket, Long> {

   

}