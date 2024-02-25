package com.nowon.bullti.domain.entity.franchise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FranchiseRepository extends JpaRepository<FranchiseEntity, Long> {

    @Query("SELECT f FROM FranchiseEntity f WHERE f.name LIKE %:keyword%")
    List<FranchiseEntity> searchByStoreName(String keyword);

//	FranchiseEntity findByMemberNo(long extractMemberNo);
}