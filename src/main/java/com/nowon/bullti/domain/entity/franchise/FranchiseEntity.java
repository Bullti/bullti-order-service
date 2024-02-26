package com.nowon.bullti.domain.entity.franchise;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nowon.bullti.domain.dto.storelist.StoreListDTO;
import com.nowon.bullti.domain.entity.BaseEntity;
import com.nowon.bullti.domain.entity.member.Member;
import com.nowon.bullti.domain.entity.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "franchisee")
@Entity
public class FranchiseEntity extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    private String locationDetail;
    @Column(nullable = false)
    private String phone;
    private boolean isOpen;

    @OneToOne
    @JoinColumn(name = "member_no")
    private Member memberNo;

    @OneToMany(mappedBy = "franchisee")
    private List<Order> order;

    public StoreListDTO toStoreListDTO() {
        return StoreListDTO.builder()
                .id(no).name(name).location(location).locationDetail(locationDetail).phone(phone)
                .build();
    }
    
    
}