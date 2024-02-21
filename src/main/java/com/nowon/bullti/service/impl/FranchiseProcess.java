package com.nowon.bullti.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.storelist.StoreListDTO;
import com.nowon.bullti.domain.entity.franchise.FranchiseEntity;
import com.nowon.bullti.domain.entity.franchise.FranchiseRepository;
import com.nowon.bullti.service.FranchiseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FranchiseProcess implements FranchiseService{
	
	private final FranchiseRepository franchiseRepository;

	@Override
	public List<StoreListDTO> getstoreList() {
		
		return franchiseRepository
				.findAll()
				.stream()
				.map(FranchiseEntity::toStoreListDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void storeList(Model model) {
		System.out.println(franchiseRepository.findAll().stream().map(FranchiseEntity::toStoreListDTO).collect(Collectors.toList()).toString());
		model.addAttribute("list",
				franchiseRepository.findAll().stream().map(FranchiseEntity::toStoreListDTO).collect(Collectors.toList()));	
	}
}
