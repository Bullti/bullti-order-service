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
public class FranchiseProcess implements FranchiseService {

    private final FranchiseRepository franchiseRepository;

    @Override
    public List<StoreListDTO> getstoreList() {
        return franchiseRepository.findAll().stream().map(FranchiseEntity::toStoreListDTO).collect(Collectors.toList());
    }

    @Override
    public void storeList(Model model) {
        List<StoreListDTO> storeList = franchiseRepository.findAll().stream()
                .map(FranchiseEntity::toStoreListDTO)
                .collect(Collectors.toList());
        model.addAttribute("list", storeList);
    }

    @Override
    public List<StoreListDTO> searchStore(String keyword) {
        List<FranchiseEntity> searchResult = franchiseRepository.searchByStoreName(keyword);
        return searchResult.stream().map(FranchiseEntity::toStoreListDTO).collect(Collectors.toList());
    }
}