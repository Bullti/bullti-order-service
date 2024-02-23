package com.nowon.bullti.domain.entity.basket;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.entity.item.ItemEntity;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long>{

	boolean existsByBasketAndItem(Basket basket, ItemEntity item);

	Optional<BasketItem> findByBasketAndItem(Basket basket, ItemEntity item);

	List<BasketItem> findByBasket(Basket basket);

}
