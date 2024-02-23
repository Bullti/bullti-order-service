<<<<<<< HEAD
package com.nowon.bullti.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nowon.bullti.domain.dto.storelist.StoreSearchDTO;
import com.nowon.bullti.service.FranchiseService;

@Controller
public class SelectShopController {

    private final FranchiseService franchiseService;

    public SelectShopController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/storelist")
    public String showStoreList(Model model) {
        franchiseService.storeList(model);
        return "storelist/storelist";
    }

    @PostMapping("/searchStore")
    public String searchStore(Model model, StoreSearchDTO storeSearchDTO) {
        if (storeSearchDTO.getKeyword() != null && !storeSearchDTO.getKeyword().isEmpty()) {
            // 검색어가 있다면 검색 기능 수행
            model.addAttribute("list", franchiseService.searchStore(storeSearchDTO.getKeyword()));
        } else {
            // 검색어가 없으면 전체 매장 목록 조회
            franchiseService.storeList(model);
        }
        return "storelist/storelist";
    }
    
=======
package com.nowon.bullti.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nowon.bullti.domain.dto.storelist.StoreSearchDTO;
import com.nowon.bullti.service.FranchiseService;

@Controller
public class SelectShopController {

    private final FranchiseService franchiseService;

    public SelectShopController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/storelist")
    public String showStoreList(Model model) {
        franchiseService.storeList(model);
        return "storelist/storelist";
    }

    @PostMapping("/searchStore")
    public String searchStore(Model model, StoreSearchDTO storeSearchDTO) {
        if (storeSearchDTO.getKeyword() != null && !storeSearchDTO.getKeyword().isEmpty()) {
            // 검색어가 있다면 검색 기능 수행
            model.addAttribute("list", franchiseService.searchStore(storeSearchDTO.getKeyword()));
        } else {
            // 검색어가 없으면 전체 매장 목록 조회
            franchiseService.storeList(model);
        }
        return "storelist/storelist";
    }
    
>>>>>>> refs/remotes/choose_remote_name/master
}