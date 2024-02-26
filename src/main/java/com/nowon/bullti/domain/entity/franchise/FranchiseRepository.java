package com.nowon.bullti.domain.entity.franchise;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nowon.bullti.domain.dto.basket.BasketMapDTO;
import com.nowon.bullti.domain.entity.member.Member;

public interface FranchiseRepository extends JpaRepository<FranchiseEntity, Long> {

    @Query("SELECT f FROM FranchiseEntity f WHERE f.name LIKE %:keyword%")
    List<FranchiseEntity> searchByStoreName(String keyword);

	Optional<FranchiseEntity> findByName(String storeName);

	Optional<FranchiseEntity> findById(Long no);
}