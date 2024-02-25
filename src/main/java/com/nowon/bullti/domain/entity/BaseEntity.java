package com.nowon.bullti.domain.entity;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseEntity {
	
	@CreationTimestamp
	LocalDateTime createdDate;
	@UpdateTimestamp
	LocalDateTime updatedDate;
}

