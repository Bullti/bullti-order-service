<<<<<<< HEAD
package com.nowon.bullti.domain.entity.basket;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nowon.bullti.domain.entity.item.ItemEntity;
import com.nowon.bullti.domain.entity.member.Member;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long>{

	boolean existsByBasketAndItem(Basket basket, ItemEntity item);

	Optional<BasketItem> findByBasketAndItem(Basket basket, ItemEntity item);

	List<BasketItem> findByBasket(Basket basket);

	void deleteByBasketNoAndItem(long memberNo, ItemEntity item);

}
=======
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
>>>>>>> refs/remotes/choose_remote_name/master
