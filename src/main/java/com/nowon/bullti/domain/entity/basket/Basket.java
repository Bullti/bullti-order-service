package com.nowon.bullti.domain.entity.basket;

import java.util.List;

import com.nowon.bullti.domain.dto.basket.BasketMapDTO;
import com.nowon.bullti.domain.dto.storelist.StoreListDTO;
import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;
import com.nowon.bullti.domain.entity.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basket")
@Entity
public class Basket {
	
	
	@Id
	@Column(name = "member_no", nullable = false)
	private long no;
	
	@OneToOne
	@MapsId 
    @JoinColumn(name = "member_no")
	private Member member;
	
	@OneToMany(mappedBy = "basket")
	private List<BasketItem> basketItem;
	
	@JoinColumn(name = "order_store")
	@ManyToOne(fetch = FetchType.LAZY)
	private FranchiseEntity fran;

	@Column(nullable = true)
	private long amount;
	
	public void setAmount(long totPrice) {
		this.amount = totPrice;
	}

	public void updateMap(FranchiseEntity franchiseEntity) {
        this.fran = franchiseEntity;
    }

	public void setFran(FranchiseEntity fran) {
		this.fran = fran;
		
	}
	
	



}
