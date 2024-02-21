package com.nowon.bullti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nowon.bullti.service.FranchiseService;

@Controller
public class SelectShopController {

    private final FranchiseService franchiseService;

    public SelectShopController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/storelist")
    public String notice_post(Model model) {
        franchiseService.storeList(model);
        return "storelist/storelist";
    }
}