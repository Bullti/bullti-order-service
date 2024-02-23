package com.nowon.bullti.domain.entity.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEntityRepository extends JpaRepository<ItemEntity, Long>{

	Optional<ItemEntity> findByName(String name);

}
